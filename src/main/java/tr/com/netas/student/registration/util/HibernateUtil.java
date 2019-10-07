package tr.com.netas.student.registration.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private HibernateUtil() {
        Configuration config = new Configuration();
        sessionFactory = config.configure().buildSessionFactory();
    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}