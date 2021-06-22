package ru.nikiforov.testHibernate;

import ru.nikiforov.testHibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * todo Document type TestDelete
 */

public class TestDelete {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            session.beginTransaction();

//            Employee employee = session.get(Employee.class, 1);
//            session.delete(employee);

            session.createQuery("delete Employee where name = 'Aleksandr'").executeUpdate();

            session.getTransaction().commit();
        } finally {
            factory.close();
        }

    }
}