package spm.db;

import java.util.List;

/**
 * Created by kokoster on 07/04/2017.
 */
public class Main {
    public static void main(String[] args) {
        FEDirectorManager manager = new FEDirectorManager();
        FEDirectorStatisticsManager statisticsManager = new FEDirectorStatisticsManager();

        List fedirectors = manager.getFEDirectors();

        List businessDateTime = statisticsManager
                .searchFEDirectorBusinessTime((FEDirector) fedirectors.get(0));

        System.out.println(fedirectors.get(0));
        for (Object dateTime : businessDateTime) {
            System.out.println(dateTime);
        }

        SPMUtil.closeSession();
    }
}
