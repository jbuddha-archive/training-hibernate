/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sandbox;

import data.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author buddha
 */
public class HibernateDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Session session = null;
        try{
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

            session = sessionFactory.openSession();
            session.beginTransaction();

            User user = new User();
            user.setName("kishore4");
            user.setPassword("garuda");

            session.save(user);     
			
			User u = (User)session.get(User.class, 15);
			u.setPassword("newPass");
        }
        finally {
            session.getTransaction().commit();
            session.close();
            System.exit(0);
        }
        
        
    }
    
}
