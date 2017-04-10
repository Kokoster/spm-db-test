package spm.db.web_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestMethod;
import spm.db.db_mappers.FEDirectorMapper;
import spm.db.db_mappers.DateTimeMapper;
import spm.db.db_mappers.StorageGroupMapper;
import spm.db.models.*;

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
    DateTimeMapper feDateTimeMapper;

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
            List<DateTime> dateTimeList = feDateTimeMapper.findFEDirectorBusinessTime(feDirector);

            businessStatisticsList.add(new FEDirectorBusinessStatistics(feDirector, dateTimeList));
        }

        return businessStatisticsList;
    }
}