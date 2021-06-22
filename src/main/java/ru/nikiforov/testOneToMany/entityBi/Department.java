package ru.nikiforov.testOneToMany.entityBi;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * todo Document type Department
 */

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    private String name;

    @Column
    private int minSalary;

    @Column
    private int maxSalary;

    @OneToMany(mappedBy = "empDepartment", cascade = CascadeType.ALL)
    private List<Employee> employeeList;

    public Department() {
    }

    public Department(String name, int minSalary, int maxSalary) {
        this.name = name;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    public int getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public void addEmployeeToDepartment(Employee employee) {
        if (employeeList == null)
            employeeList = new ArrayList<>();
        employeeList.add(employee);
        employee.setEmpDepartment(this);
    }

    @Override
    public String toString() {
        return "Department{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", minSalary=" + minSalary +
            ", maxSalary=" + maxSalary +
            '}';
    }
}