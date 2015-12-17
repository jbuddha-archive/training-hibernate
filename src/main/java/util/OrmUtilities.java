package util;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author buddha
 */
public class OrmUtilities {
	private static final Session session = new Configuration().configure().buildSessionFactory().openSession();
	
	static 
	{
		session.beginTransaction();
	}
	
	public static Session getSession()
	{
		return session;
	}
	
	public static void closeSession()
	{
		if(session.getTransaction() != null)
			session.getTransaction().commit();
		session.close();
	}
}
