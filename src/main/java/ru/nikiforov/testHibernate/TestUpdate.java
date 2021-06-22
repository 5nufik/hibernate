package ru.nikiforov.testHibernate;

import ru.nikiforov.testHibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * todo Document type TestUpdate
 */

public class TestUpdate {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            session.beginTransaction();

//            Employee employee = session.get(Employee.class, 1);
//            employee.setSalary(1500);

            session.createQuery("update Employee set salary = 1000 where name = 'Aleksandr'").executeUpdate();

            session.getTransaction().commit();
        } finally {
            factory.close();
        }

    }
}