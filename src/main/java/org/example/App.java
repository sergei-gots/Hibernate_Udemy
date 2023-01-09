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

            L_48_getPersonById(sessionFactory);
            L_49_savePersons(sessionFactory);
    }

    private static void L_49_savePersons(SessionFactory sessionFactory) {

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            Person person1 = new Person("Test1", 30);
            Person person2 = new Person("Test2", 40);
            Person person3 = new Person("Test3", 50);

            // Hibernate log will be:
            //  Hibernate: insert into Person (age, name) values (?, ?)
            //  Hibernate: insert into Person (age, name) values (?, ?)
            //  Hibernate: insert into Person (age, name) values (?, ?)

            session.save(person1);
            session.save(person2);
            session.save(person3);

        } finally {
            session.close();
        }
    }

    private static void L_48_getPersonById(SessionFactory sessionFactory) {
        int id = 1;

        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            // Hibernate log will be:
            //  select person0_.id as id1_0_0_, person0_.age as age2_0_0_, person0_.name as name3_0_0_
            //  from Person person0_ where person0_.id=?

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
