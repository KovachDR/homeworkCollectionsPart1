package pro.sky.homeworkcollectionssets.service;

import org.springframework.stereotype.Service;
import pro.sky.homeworkcollectionssets.exceptions.DepartmentNotFoundException;
import pro.sky.homeworkcollectionssets.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homeworkcollectionssets.exceptions.EmployeeNotFoundException;
import pro.sky.homeworkcollectionssets.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImp implements EmployeeService {
    private final Map<String, Employee> employees;

    public EmployeeServiceImp() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int department, double salary) {
        if (department < 1 || department > 5) {
            throw new DepartmentNotFoundException();
        }
        Employee employee = new Employee(firstName, lastName, department, salary);
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

    @Override
    public List<Employee> findEmployeesInDepartment(int numberDepartment) {
        if (numberDepartment < 1 || numberDepartment > 5) {
            throw new DepartmentNotFoundException();
        }
        return employees.values().stream()
                .filter(employee -> employee.getDepartment() == numberDepartment)
                .collect(Collectors.toList());
    }

    @Override
    public String findAllEmployeesWithDepartmentNumbers() {
        List<Employee> employeeList1 = employees.values().stream()
                .filter(employee -> employee.getDepartment() == 1)
                .toList();
        List<Employee> employeeList2 = employees.values().stream()
                .filter(employee -> employee.getDepartment() == 2)
                .toList();
        List<Employee> employeeList3 = employees.values().stream()
                .filter(employee -> employee.getDepartment() == 3)
                .toList();
        List<Employee> employeeList4 = employees.values().stream()
                .filter(employee -> employee.getDepartment() == 4)
                .toList();
        List<Employee> employeeList5 = employees.values().stream()
                .filter(employee -> employee.getDepartment() == 5)
                .toList();
        return "В отделе №1 работают " + employeeList1 +
                "В отделе №2 работают " + employeeList2 +
                "В отделе №3 работают " + employeeList3 +
                "В отделе №4 работают " + employeeList4 +
                "В отделе №5 работают " + employeeList5;
    }

    @Override
    public Optional<Employee> findMinSalaryInDepartment(int numberDepartment) {
        if (numberDepartment < 1 || numberDepartment > 5) {
            throw new DepartmentNotFoundException();
        }
        return employees.values().stream()
                .filter(e -> e.getDepartment() == numberDepartment)
                .min(Comparator.comparing(Employee::getSalary));
    }

    @Override
    public Optional<Employee> findMaxSalaryInDepartment(int numberDepartment) {
        if (numberDepartment < 1 || numberDepartment > 5) {
            throw new DepartmentNotFoundException();
        }
        return employees.values().stream()
                .filter(e -> e.getDepartment() == numberDepartment)
                .max(Comparator.comparing(Employee::getSalary));
    }
}