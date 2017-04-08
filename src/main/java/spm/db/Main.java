package spm.db;

import java.util.List;

/**
 * Created by kokoster on 07/04/2017.
 */
public class Main {
    public static void main(String[] args) {
        FEDirectorManager manager = new FEDirectorManager();
        StorageGroupManager storageGroupManager = new StorageGroupManager();

        List fedirectors = manager.getFEDirectors();

        for (Object fedirector : fedirectors) {
            System.out.println(fedirector);
        }

        List storageGroups = storageGroupManager.getStorageGroups();

        for (Object storageGroup : storageGroups) {
            System.out.println(storageGroup);
        }

        SPMUtil.closeSession();
    }
}
