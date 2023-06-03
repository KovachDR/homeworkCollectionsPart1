package pro.sky.homeworkcollectionssets.service;

import org.springframework.stereotype.Service;
import pro.sky.homeworkcollectionssets.exceptions.DepartmentNotFoundException;
import pro.sky.homeworkcollectionssets.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homeworkcollectionssets.exceptions.EmployeeNotFoundException;
import pro.sky.homeworkcollectionssets.model.Employee;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.capitalize;

@Service
public class EmployeeServiceImp implements EmployeeService {
    private final EmployeeValidationService employeeValidationService;
    private final Map<String, Employee> employees;

    public EmployeeServiceImp(EmployeeValidationService employeeValidationService) {
        this.employeeValidationService = employeeValidationService;
        this.employees = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int department, double salary) {
        employeeValidationService.validate(firstName,lastName);
        if (department < 1 || department > 5) {
            throw new DepartmentNotFoundException();
        }
        Employee employee = new Employee(capitalize(firstName), capitalize(lastName), department, salary);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, int department, double salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, int department, double salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}