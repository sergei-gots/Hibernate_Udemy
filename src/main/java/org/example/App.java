package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        System.out.println( "Hello World!" );
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            int id = 2;
            session.beginTransaction();
            Person person = session.get(Person.class, id);
            if (person != null) {
                System.out.println("person.getName() = " + person.getName());
                System.out.println("person.getAge() = " + person.getAge());
            } else {
                System.out.println("Person with id=" + id + " is not found in db");
            }
            session.getTransaction().commit();
        }
        finally {
            session.close();
        }


    }
}
