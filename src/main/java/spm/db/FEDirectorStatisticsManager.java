package spm.db;

import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kokoster on 08/04/2017.
 */
public class FEDirectorStatisticsManager {
    public List searchFEDirectorBusinessTime(FEDirector feDirector) {
        List dateTimeList = new ArrayList<DateTime>();

        try (Session session = SPMUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            dateTimeList = session.createQuery("from DateTime where timeKey in " +
                    "(select id.dateTime from FEDirectorStatistics " +
                    "where id.fedirector = :fedirector and queue7 > 0)")
                    .setParameter("fedirector", feDirector)
                    .getResultList();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            SPMUtil.closeSession();
        }

        return dateTimeList;
    }
}
