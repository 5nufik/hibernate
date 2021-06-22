package ru.nikiforov.testOneToMany;

import ru.nikiforov.testOneToMany.entityUni.Department;
import ru.nikiforov.testOneToMany.entityUni.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * todo Document type TestOneToManyUni
 */

public class TestOneToManyUni {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
            .addAnnotatedClass(Employee.class)
            .addAnnotatedClass(Department.class)
            .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
//
//            Department department = new Department("HR", 500, 1500);
//
//            Employee emp1 = new Employee("Oleg", "Ivanov", 800);
//            Employee emp2 = new Employee("Andrey", "Sidorov", 1000);
//
//            department.addEmployeeToDepartment(emp1);
//            department.addEmployeeToDepartment(emp2);
//
//            session.save(department);

//            Department department = session.get(Department.class, 2);
//
//            System.out.println(department);
//            System.out.println(department.getEmployeeList());

//            Employee employee = session.get(Employee.class, 1);
//
//            System.out.println(employee);

            Employee employee = session.get(Employee.class, 6);
            session.delete(employee);

            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }

    }
}