package spm.db.web_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMethod;
import spm.db.db_repositories.FEDirectorRepository;
import spm.db.db_repositories.DateTimeStatisticsRepository;
import spm.db.db_repositories.StorageGroupRepository;
import spm.db.db_repositories.StorageGroupStatisticsRepository;
import spm.db.models.*;
import spm.db.utils.OutlierDetector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kokoster on 09/04/2017.
 */
@RestController
public class SPMConnectionController {
    @Autowired
    FEDirectorRepository feDirectorRepository;

    @Autowired
    StorageGroupRepository storageGroupRepository;

    @Autowired
    DateTimeStatisticsRepository dateTimeStatisticsRepository;

    @Autowired
    StorageGroupStatisticsRepository storageGroupStatisticsRepository;

    @RequestMapping(value = "/fedirectors", method = RequestMethod.GET)
    public List<FEDirector> getFEDirectors() {
        return feDirectorRepository.readFEDirectors();
    }

    @RequestMapping(value = "/storagegroups", method = RequestMethod.GET)
    public List<StorageGroup> getStorageGroups() {
        return storageGroupRepository.readStorageGroups();
    }

    @RequestMapping(value = "/fedirectors/business", method = RequestMethod.GET)
    public List<FEDirectorBusinessStatistics> getFEDirectorsBusiness() {
        List<FEDirector> feDirectors = feDirectorRepository.readFEDirectors();

        List<FEDirectorBusinessStatistics> businessStatisticsList =
                new ArrayList<>();
        for (FEDirector feDirector : feDirectors) {
            List<DateTime> dateTimeList = dateTimeStatisticsRepository.findFEDirectorBusinessTime(feDirector);

            businessStatisticsList.add(new FEDirectorBusinessStatistics(feDirector, dateTimeList));
        }

        return businessStatisticsList;
    }

    @RequestMapping(value = "/fedirectors/busiest-storagegroups/by-key", method = RequestMethod.GET)
    public SPMTotalStatistics getBusiestStorageGroupsByKey(@RequestParam("fedirectorkey") Integer fedirectorKey) {
        FEDirector feDirector = feDirectorRepository.findOne(fedirectorKey);
        return getBusiestStorageGroups(feDirector);
    }

    @RequestMapping(value = "/fedirectors/busiest-storagegroups/by-name", method = RequestMethod.GET)
    public SPMTotalStatistics getBusiestStorageGroupsByName(@RequestParam("fedirectorname") String fedirectorName) {
        FEDirector feDirector = feDirectorRepository.findFEDirectorByName(fedirectorName);
        return getBusiestStorageGroups(feDirector);
    }

    private SPMTotalStatistics getBusiestStorageGroups(FEDirector feDirector) {
        OutlierDetector outlierDetector = new OutlierDetector();

        List<DateTime> dateTimeList = dateTimeStatisticsRepository.findFEDirectorBusinessTime(feDirector);
        SPMTotalStatistics totalStatistics = new SPMTotalStatistics(feDirector);

        for (DateTime dateTime : dateTimeList) {
            List<StorageGroupStatistics> storageGroupStatistics =
                    storageGroupStatisticsRepository.findBusiestStorageGroups(dateTime);

            List<StorageGroup> storageGroups = outlierDetector.searchOutliers(storageGroupStatistics);

            totalStatistics.addStorageGroups(storageGroups, dateTime);
        }

        return totalStatistics;
    }
}
