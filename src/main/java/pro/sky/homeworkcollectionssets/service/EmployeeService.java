package pro.sky.homeworkcollectionssets.service;

import pro.sky.homeworkcollectionssets.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homeworkcollectionssets.exceptions.EmployeeNotFoundException;
import pro.sky.homeworkcollectionssets.exceptions.EmployeeStoragelsFullException;
import pro.sky.homeworkcollectionssets.model.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> findAll();
}
