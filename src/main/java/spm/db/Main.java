package spm.db;

import java.util.List;

/**
 * Created by kokoster on 07/04/2017.
 */
public class Main {
    public static void main(String[] args) {
        FEDirectorManager manager = new FEDirectorManager();

        List fedirectors = manager.getFEDirectors();

        for (Object fedirector : fedirectors) {
            System.out.println(fedirector);
        }

        SPMUtil.closeSession();
    }
}
