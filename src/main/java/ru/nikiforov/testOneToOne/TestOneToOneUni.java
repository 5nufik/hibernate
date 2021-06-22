package ru.nikiforov.testOneToOne;

import ru.nikiforov.testOneToOne.entity.Employee;
import ru.nikiforov.testOneToOne.entity.Detail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * todo Document type TestOneToOneUni
 */

public class TestOneToOneUni {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                                    .addAnnotatedClass(Employee.class)
                                                    .addAnnotatedClass(Detail.class)
                                                    .buildSessionFactory();

        Session session = null;
        try {
//            Session session = factory.getCurrentSession();
//
//            Employee employee = new Employee("Max", "Ivanov", "IT", 500);
//
//            Detail detail = new Detail("Baku", "942342342", "max@gmail.com");
//
//            employee.setEmpDetail(detail);
//
//            session.beginTransaction();
//
//            session.save(employee);
//
//            session.getTransaction().commit();

//            Session session = factory.getCurrentSession();
//
//            Employee employee = new Employee("Oleg", "Olegovich", "Sales", 700);
//
//            Detail detail = new Detail("Moscow", "432423141241", "olegoleg@gmail.ru");
//
//            employee.setEmpDetail(detail);
//
//            session.beginTransaction();
//
//            session.save(employee);
//
//            session.getTransaction().commit();

            session = factory.getCurrentSession();

            session.beginTransaction();

            Detail detail = session.get(Detail.class, 2);

            session.delete(detail);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }

    }
}