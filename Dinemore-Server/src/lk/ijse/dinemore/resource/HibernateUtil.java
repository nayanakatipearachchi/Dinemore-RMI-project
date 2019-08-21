 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.resource;

import java.io.File;
import lk.ijse.dinemore.entity.Orders;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Nayana
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static StandardServiceRegistry registry;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.

            File hibernateProperties = new File("settings/hibernate.properties");
            registry = new StandardServiceRegistryBuilder().loadProperties(hibernateProperties).build();
            sessionFactory = new MetadataSources(registry)
                    .addAnnotatedClass(Orders.class)
                    .buildMetadata().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception.
            System.out.println("SesstionFactory Creation Failed "+ex);
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
