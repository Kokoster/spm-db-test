//package spm.db.db_mappers;
//
//import org.hibernate.Session;
//import spm.db.SPMUtil;
//import spm.db.models.DateTime;
//import spm.db.models.StorageGroup;
//import spm.db.models.StorageGroupStatistics;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by kokoster on 09/04/2017.
// */
//public class StorageGroupStatisticsManager {
//    public List<StorageGroup> searchBusiestStorageGroups(DateTime dateTime) {
//        List storageGroupStatistics = new ArrayList<StorageGroupStatistics>();
//
//        try (Session session = SPMUtil.getSessionFactory().openSession()) {
//            session.beginTransaction();
//
//            storageGroupStatistics = session.createQuery("from StorageGroupStatistics " +
//                    "where id.dateTime = :dateTime " +
//                    "order by queriesCount")
//                    .setParameter("dateTime", dateTime)
//                    .getResultList();
//
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            SPMUtil.closeSession();
//        }
//
//        return searchOutliers(storageGroupStatistics);
//    }
//
//    private List<StorageGroup> searchOutliers(List storageGroupStatistics) {
//        int size = storageGroupStatistics.size();
//
//        float lowerQuartile = findMedianValue(storageGroupStatistics, 0, (size - 1) / 2);
//
//        int upperStartIndex = (size - 1) / 2 + 1;
//        if (size % 2 != 0) {
//            upperStartIndex = size / 2 + 1;
//        }
//
//        float upperQuartile = findMedianValue(storageGroupStatistics, upperStartIndex, (size - 1) / 2);
//
//        float interQuartile = upperQuartile - lowerQuartile;
//        float upperOuterFence = upperQuartile + 3 * interQuartile;
//
//        List<StorageGroup> storageGroups = new ArrayList<>();
//        for (Object statistics : storageGroupStatistics) {
//            if (((StorageGroupStatistics) statistics).getQueriesCount() > upperOuterFence) {
//                storageGroups.add(((StorageGroupStatistics) statistics).getStorageGroup());
//            }
//        }
//
//        return storageGroups;
//    }
//
//    private float findMedianValue(List storageGroupStatistics, int startIndex, int size) {
//        float median = ((StorageGroupStatistics) storageGroupStatistics.get(startIndex + (size - 1) / 2))
//                .getQueriesCount();
//
//        if (size % 2 != 0) {
//            float median2 = ((StorageGroupStatistics) storageGroupStatistics.get(startIndex + size / 2))
//                    .getQueriesCount();
//
//            median = (median + median2) / 2;
//        }
//
//        return median;
//    }
//}
