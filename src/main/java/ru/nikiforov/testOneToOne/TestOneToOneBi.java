package ru.nikiforov.testOneToOne;

import ru.nikiforov.testOneToOne.entity.Detail;
import ru.nikiforov.testOneToOne.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * todo Document type TestOneToOneBi
 */

public class TestOneToOneBi {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                                    .addAnnotatedClass(Employee.class)
                                                    .addAnnotatedClass(Detail.class)
                                                    .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();

            session.beginTransaction();

//            Employee employee = new Employee("Vasya", "Sidorov", "Sales", 850);
//
//            Detail detail = new Detail("New-York", "312312312312", "vas@gmail.com");
//
//            details.setEmployee(employee);
//            employee.setEmpDetail(detail);
//
//            session.save(employee);

//            Detail detail = session.get(Detail.class, 5);
//
//            detail.getEmployee().setEmpDetail(null);
//            session.delete(detail);

            Detail detail = session.get(Detail.class, 8);

//            Detail detail = employee.getEmpDetail();

//            System.out.println(employee);
            System.out.println(detail);
            System.out.println(detail.getEmployee());

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }

    }
}