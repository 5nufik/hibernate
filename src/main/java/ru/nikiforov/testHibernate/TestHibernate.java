package ru.nikiforov.testHibernate;

import ru.nikiforov.testHibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * todo Document type TestHibernate
 */

public class TestHibernate {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            Employee employee = new Employee("Elena", "Petrova", "Sales", 750);

            session.beginTransaction();

            session.save(employee);

            int myId = employee.getId();

            session.get(Employee.class, myId);

            session.getTransaction().commit();
        } finally {
            factory.close();
        }

    }
}