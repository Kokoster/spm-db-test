package spm.db;

import org.hibernate.HibernateException;
import org.hibernate.Session;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by kokoster on 07/04/2017.
 */
public class FEDirectorManager {
    public List getFEDirectors() {
        List fedirectors = new ArrayList<FEDirector>();

        try (Session session = SPMUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            fedirectors = session.createQuery("FROM FEDirector").getResultList();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return fedirectors;
    }
}
