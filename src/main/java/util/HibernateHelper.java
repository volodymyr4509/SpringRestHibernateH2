package util;

import dto.Typicode;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Created by volodymyr on 28.06.16.
 */
public class HibernateHelper {

    private static SessionFactory factory = null;
    private static ServiceRegistry registry;
    static {
        try {
            Configuration configuration = new Configuration().configure();
            registry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

            factory = configuration.addPackage("dto").addAnnotatedClass(Typicode.class).buildSessionFactory(registry);
        } catch (HibernateException he) {
            System.err.println("Error creating Session: " + he);
            throw new ExceptionInInitializerError(he);
        }
    }
    public static void destroy(){
        StandardServiceRegistryBuilder.destroy(registry);
    }
    public static SessionFactory getSessionFactory() {
        return factory;
    }
}