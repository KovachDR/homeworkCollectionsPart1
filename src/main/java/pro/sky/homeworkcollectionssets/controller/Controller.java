package pro.sky.homeworkcollectionssets.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.homeworkcollectionssets.exceptions.DepartmentNotFoundException;
import pro.sky.homeworkcollectionssets.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homeworkcollectionssets.exceptions.EmployeeNotFoundException;
import pro.sky.homeworkcollectionssets.model.Employee;
import pro.sky.homeworkcollectionssets.service.EmployeeServiceImp;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class Controller {
    private final EmployeeServiceImp employeeServiceImp;

    public Controller(EmployeeServiceImp employeeServiceImp) {
        this.employeeServiceImp = employeeServiceImp;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName,
                                @RequestParam String lastName,
                                @RequestParam int department,
                                @RequestParam double salary) {
        return employeeServiceImp.addEmployee(firstName, lastName, department, salary);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName,
                                   @RequestParam String lastName,
                                   @RequestParam int department,
                                   @RequestParam double salary) {
        return employeeServiceImp.removeEmployee(firstName, lastName, department, salary);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName,
                                 @RequestParam String lastName,
                                 @RequestParam int department,
                                 @RequestParam double salary) {
        return employeeServiceImp.findEmployee(firstName, lastName, department, salary);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return employeeServiceImp.findAll();
    }

    ///////////////////////////////////////////////////////
    @GetMapping("/departmentId")
    public List<Employee> findAllEmployeesInDepartment(@RequestParam int departmentId) {
        return employeeServiceImp.findEmployeesInDepartment(departmentId);
    }

    @GetMapping("/department")
    public String findAllEmployeesWithNumberDepartment() {
        return employeeServiceImp.findAllEmployeesWithDepartmentNumbers();
    }

    @GetMapping("/min-salary")
    public Optional<Employee> findMinSalaryInDepartment(@RequestParam int departmentId) {
        return employeeServiceImp.findMinSalaryInDepartment(departmentId);
    }

    @GetMapping("/max-salary")
    public Optional<Employee> findMaxSalaryInDepartment(@RequestParam int departmentId) {
        return employeeServiceImp.findMaxSalaryInDepartment(departmentId);
    }

}
