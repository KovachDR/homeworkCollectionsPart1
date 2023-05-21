package pro.sky.homeworkcollectionssets.service;

import pro.sky.homeworkcollectionssets.model.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName,int department, double salary);

    Employee removeEmployee(String firstName, String lastName,int department, double salary);
    Employee findEmployee(String firstName, String lastName,int department, double salary);

    Collection<Employee> findAll();
}
