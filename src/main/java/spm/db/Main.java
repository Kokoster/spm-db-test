package spm.db;

import spm.db.models.DateTime;
import spm.db.models.FEDirector;
import spm.db.models.StorageGroupStatistics;

import java.util.List;

/**
 * Created by kokoster on 07/04/2017.
 */
public class Main {
    public static void main(String[] args) {
        FEDirectorManager manager = new FEDirectorManager();
        FEDirectorStatisticsManager statisticsManager = new FEDirectorStatisticsManager();
        StorageGroupStatisticsManager storageGroupStatisticsManager =
                new StorageGroupStatisticsManager();

        List fedirectors = manager.getFEDirectors();
        List businessDateTime = statisticsManager
                .searchFEDirectorBusinessTime((FEDirector) fedirectors.get(0));
        List busiestStorageGroups = storageGroupStatisticsManager
                .getBusiestStorageGroups((DateTime) businessDateTime.get(0));

        for (Object storageGroup : busiestStorageGroups) {
            System.out.println(storageGroup);
        }

        SPMUtil.closeSession();
    }
}
