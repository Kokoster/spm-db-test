package spm.db;

import org.hibernate.Session;
import spm.db.models.DateTime;
import spm.db.models.StorageGroup;
import spm.db.models.StorageGroupStatistics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kokoster on 09/04/2017.
 */
public class StorageGroupStatisticsManager {
    public List getBusiestStorageGroups(DateTime dateTime) {
        List storageGroups = new ArrayList<StorageGroup>();
        List storageGroupStatistics = new ArrayList<StorageGroupStatistics>();

        try (Session session = SPMUtil.getSessionFactory().openSession()) {
            session.beginTransaction();

            storageGroupStatistics = session.createQuery("from StorageGroupStatistics " +
                    "where id.dateTime = :dateTime")
                    .setParameter("dateTime", dateTime)
                    .getResultList();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            SPMUtil.closeSession();
        }

        return storageGroupStatistics;
    }
}
