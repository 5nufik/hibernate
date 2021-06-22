package ru.nikiforov.testHibernate;

import ru.nikiforov.testHibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * todo Document type TestInsert
 */

public class TestInsert {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            Employee employee = new Employee("Aleksandr", "Ivanov", "IT", 800);

            session.beginTransaction();

            session.save(employee);

            session.getTransaction().commit();

            System.out.println(employee);
        } finally {
            factory.close();
        }

    }
}