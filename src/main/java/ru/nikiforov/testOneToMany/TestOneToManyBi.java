package ru.nikiforov.testOneToMany;

import ru.nikiforov.testOneToMany.entityBi.Department;
import ru.nikiforov.testOneToMany.entityBi.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * todo Document type TestOneToManyBi
 */

public class TestOneToManyBi {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
            .addAnnotatedClass(Employee.class)
            .addAnnotatedClass(Department.class)
            .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

//            Department department = new Department("IT", 300, 1200);
//
//            Employee emp1 = new Employee("Max", "Ivanov", 800);
//            Employee emp2 = new Employee("Elena", "Smirnova", 1000);
//
//            department.addEmployeeToDepartment(emp1);
//            department.addEmployeeToDepartment(emp2);
//
//            session.save(department);

//            Department department = session.get(Department.class, 1);
//
//            System.out.println(department);
//            System.out.println(department.getEmployeeList());

//            Employee employee = session.get(Employee.class, 1);
//
//            System.out.println(employee);
//            System.out.println(employee.getEmpDepartment());


//            Employee employee = session.get(Employee.class, 4);
//            session.delete(employee);

//            Department department = new Department("Sales", 800, 1500);
//
//            Employee emp1 = new Employee("Max", "Ivanov", 800);
//            Employee emp2 = new Employee("Elena", "Smirnova", 1500);
//            Employee emp3 = new Employee("Anton", "Sidorov", 1200);
//
//            department.addEmployeeToDepartment(emp1);
//            department.addEmployeeToDepartment(emp2);
//            department.addEmployeeToDepartment(emp3);
//
//            session.save(department);

            System.out.println("Get department");
            Department department = session.get(Department.class, 4);

            System.out.println("Show department");
            System.out.println(department);

            department.getEmployeeList().get(0);

            session.getTransaction().commit();

            System.out.println("Show employees of the department");
            System.out.println(department.getEmployeeList());
        } finally {
            session.close();
            factory.close();
        }

    }
}