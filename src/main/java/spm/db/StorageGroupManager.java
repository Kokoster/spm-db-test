package spm.db;

import org.hibernate.Session;
import spm.db.models.StorageGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kokoster on 08/04/2017.
 */
public class StorageGroupManager {
    public List getStorageGroups() {
        List storageGroups = new ArrayList<StorageGroup>();

        try (Session session = SPMUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            storageGroups = session.createQuery("FROM StorageGroup").getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            SPMUtil.closeSession();
        }

        return storageGroups;
    }
}
