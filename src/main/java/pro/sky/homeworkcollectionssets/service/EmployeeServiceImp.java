package pro.sky.homeworkcollectionssets.service;

import org.springframework.stereotype.Service;
import pro.sky.homeworkcollectionssets.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homeworkcollectionssets.exceptions.EmployeeNotFoundException;
import pro.sky.homeworkcollectionssets.exceptions.EmployeeStoragelsFullException;
import pro.sky.homeworkcollectionssets.model.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {
    private final List<Employee> employeeList;

    public EmployeeServiceImp() {
        this.employeeList = new ArrayList<>();
    }
    private final int MAX_EMPLOYEE = 5;
    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)){
            throw new EmployeeAlreadyAddedException();
        }
        if (employeeList.size() == MAX_EMPLOYEE){
            throw new EmployeeStoragelsFullException();
        }
            employeeList.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            employeeList.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employeeList.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(employeeList);
    }
}

