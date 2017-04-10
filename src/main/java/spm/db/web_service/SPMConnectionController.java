package spm.db.web_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMethod;
import spm.db.db_mappers.FEDirectorMapper;
import spm.db.db_mappers.DateTimeStatisticsMapper;
import spm.db.db_mappers.StorageGroupMapper;
import spm.db.db_mappers.StorageGroupStatisticsMapper;
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
    FEDirectorMapper feDirectorMapper;

    @Autowired
    StorageGroupMapper storageGroupMapper;

    @Autowired
    DateTimeStatisticsMapper dateTimeStatisticsMapper;

    @Autowired
    StorageGroupStatisticsMapper storageGroupStatisticsMapper;

    @RequestMapping(value = "/fedirectors", method = RequestMethod.GET)
    public List<FEDirector> getFEDirectors() {
        return feDirectorMapper.readFEDirectors();
    }

    @RequestMapping(value = "/storagegroups", method = RequestMethod.GET)
    public List<StorageGroup> getStorageGroups() {
        return storageGroupMapper.readStorageGroups();
    }

    @RequestMapping(value = "/fedirectors/business", method = RequestMethod.GET)
    public List<FEDirectorBusinessStatistics> getFEDirectorsBusiness() {
        List<FEDirector> feDirectors = feDirectorMapper.readFEDirectors();

        List<FEDirectorBusinessStatistics> businessStatisticsList =
                new ArrayList<>();
        for (FEDirector feDirector : feDirectors) {
            List<DateTime> dateTimeList = dateTimeStatisticsMapper.findFEDirectorBusinessTime(feDirector);

            businessStatisticsList.add(new FEDirectorBusinessStatistics(feDirector, dateTimeList));
        }

        return businessStatisticsList;
    }

    @RequestMapping(value = "/fedirectors/busiest-storagegroups/by-key", method = RequestMethod.GET)
    public SPMTotalStatistics getBusiestStorageGroupsByKey(@RequestParam("fedirectorkey") Integer fedirectorKey) {
        FEDirector feDirector = feDirectorMapper.findOne(fedirectorKey);
        return getBusiestStorageGroups(feDirector);
    }

    @RequestMapping(value = "/fedirectors/busiest-storagegroups/by-name", method = RequestMethod.GET)
    public SPMTotalStatistics getBusiestStorageGroupsByName(@RequestParam("fedirectorname") String fedirectorName) {
        FEDirector feDirector = feDirectorMapper.findFEDirectorByName(fedirectorName);
        return getBusiestStorageGroups(feDirector);
    }

    private SPMTotalStatistics getBusiestStorageGroups(FEDirector feDirector) {
        OutlierDetector outlierDetector = new OutlierDetector();

        List<DateTime> dateTimeList = dateTimeStatisticsMapper.findFEDirectorBusinessTime(feDirector);
        SPMTotalStatistics totalStatistics = new SPMTotalStatistics(feDirector);

        for (DateTime dateTime : dateTimeList) {
            List<StorageGroupStatistics> storageGroupStatistics =
                    storageGroupStatisticsMapper.findBusiestStorageGroups(dateTime);

            List<StorageGroup> storageGroups = outlierDetector.searchOutliers(storageGroupStatistics);

            totalStatistics.addStorageGroups(storageGroups, dateTime);
        }

        return totalStatistics;
    }
}
