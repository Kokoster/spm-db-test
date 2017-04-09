package spm.db;

import org.hibernate.Session;
import spm.db.models.DateTime;
import spm.db.models.FEDirector;

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
                    "where id.feDirector = :feDirector and queue7 + queue8 + queue9 >= 1)")
                    .setParameter("feDirector", feDirector)
                    .getResultList();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            SPMUtil.closeSession();
        }

        return dateTimeList;
    }
}
