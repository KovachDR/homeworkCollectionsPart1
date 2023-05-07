package pro.sky.homeworkcollectionssets.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.homeworkcollectionssets.model.Employee;
import pro.sky.homeworkcollectionssets.service.EmployeeServiceImp;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class Controller {
    private final EmployeeServiceImp employeeServiceImp;

    public Controller(EmployeeServiceImp employeeServiceImp) {
        this.employeeServiceImp = employeeServiceImp;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName,
                            @RequestParam String lastName)  {
        return employeeServiceImp.addEmployee(firstName,lastName);
    }
    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName,
                                @RequestParam String lastName)  {
        return employeeServiceImp.removeEmployee(firstName,lastName);
    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName,
                                   @RequestParam String lastName)  {
        return employeeServiceImp.findEmployee(firstName,lastName);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return employeeServiceImp.findAll();
    }

}
