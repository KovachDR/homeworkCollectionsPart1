package pro.sky.homeworkcollectionssets.service;

import pro.sky.homeworkcollectionssets.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName,int department, double salary);

    Employee removeEmployee(String firstName, String lastName,int department, double salary);
    Employee findEmployee(String firstName, String lastName,int department, double salary);

    Collection<Employee> findAll();

    List<Employee> findEmployeesInDepartment(int numberDepartment);

    String findAllEmployeesWithDepartmentNumbers();

    Optional<Employee> findMinSalaryInDepartment(int numberDepartment);

    Optional<Employee> findMaxSalaryInDepartment(int numberDepartment);
}
