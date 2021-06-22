package ru.nikiforov.testHibernate;

import ru.nikiforov.testHibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * todo Document type TestSelect
 */

public class TestSelect {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();

            session.beginTransaction();

            List<Employee> employeeList = session.createQuery("from Employee where name = 'Aleksandr' ").getResultList();

            for (Employee e : employeeList) {
                System.out.println(e);
            }

            session.getTransaction().commit();
        } finally {
            factory.close();
        }

    }
}