package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	private static final SessionFactory sessionfactory = createSessionFactory();

	private static SessionFactory createSessionFactory() {
		try {
			StandardServiceRegistry serviceRegisty = new StandardServiceRegistryBuilder().configure().build();
			SessionFactory factory = new MetadataSources(serviceRegisty).buildMetadata().buildSessionFactory();
			return factory;
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionfactory() {
		return sessionfactory;
	}

	public static void closeFactory() {
		if (sessionfactory != null) {
			sessionfactory.close();
		}
	}
}
