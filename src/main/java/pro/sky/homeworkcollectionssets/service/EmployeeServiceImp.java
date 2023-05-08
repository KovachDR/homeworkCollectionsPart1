package pro.sky.homeworkcollectionssets.service;

import org.springframework.stereotype.Service;
import pro.sky.homeworkcollectionssets.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homeworkcollectionssets.exceptions.EmployeeNotFoundException;
import pro.sky.homeworkcollectionssets.exceptions.EmployeeStoragelsFullException;
import pro.sky.homeworkcollectionssets.model.Employee;

import java.util.*;

@Service
public class EmployeeServiceImp implements EmployeeService {
    private final Map<String,Employee> employees;

    public EmployeeServiceImp() {
        this.employees = new HashMap<>();
    }
    private final int MAX_EMPLOYEE = 5;
    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())){
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() == MAX_EMPLOYEE){
            throw new EmployeeStoragelsFullException();
        }
            employees.put(employee.getFullName(),employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
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

