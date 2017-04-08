package spm.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by kokoster on 07/04/2017.
 */
public class SPMUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (ExceptionInInitializerError e) {
            System.err.println("Failed to create sessionFactory\n" + e);
            throw e;
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void closeSession() {
        sessionFactory.close();
    }
}
