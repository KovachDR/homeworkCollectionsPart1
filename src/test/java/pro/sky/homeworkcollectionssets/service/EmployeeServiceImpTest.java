package pro.sky.homeworkcollectionssets.service;

import org.junit.jupiter.api.Test;
import pro.sky.homeworkcollectionssets.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homeworkcollectionssets.exceptions.EmployeeNotFoundException;
import pro.sky.homeworkcollectionssets.model.Employee;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.homeworkcollectionssets.service.ConstansForTest.*;

class EmployeeServiceImpTest {
    private final EmployeeValidationServiceImpl employeeValidationService = new EmployeeValidationServiceImpl();
    private final EmployeeServiceImp employeeServiceImp = new EmployeeServiceImp(employeeValidationService);

    @Test
    public void shouldAddEmployee() {
        Employee employee = new Employee(FIRST_NAME, LAST_NAME, DEPARTMENT_ID, SALARY);
        assertFalse(employeeServiceImp.findAll().contains(employee));
        assertEquals(0, employeeServiceImp.findAll().size());

        Employee addedEmployee = employeeServiceImp.addEmployee(FIRST_NAME, LAST_NAME, DEPARTMENT_ID, SALARY);
        assertEquals(employee, addedEmployee);
        assertEquals(1, employeeServiceImp.findAll().size());
        assertTrue(employeeServiceImp.findAll().contains(employee));
    }

    @Test
    public void shouldThrowEmployeeAlreadyAddedException() {
        Employee employee = employeeServiceImp.addEmployee(FIRST_NAME, LAST_NAME, DEPARTMENT_ID, SALARY);
        assertTrue(employeeServiceImp.findAll().contains(employee));
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> employeeServiceImp.addEmployee(FIRST_NAME, LAST_NAME, DEPARTMENT_ID, SALARY));
    }

    @Test
    public void shouldFindExistEmployee() {
        Employee employee = employeeServiceImp.addEmployee(FIRST_NAME, LAST_NAME, DEPARTMENT_ID, SALARY);
        assertEquals(employee, employeeServiceImp.findEmployee(FIRST_NAME, LAST_NAME, DEPARTMENT_ID, SALARY));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindEmployee() {
        assertEquals(0, employeeServiceImp.findAll().size());
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeServiceImp.findEmployee(FIRST_NAME, LAST_NAME, DEPARTMENT_ID, SALARY));
    }

    @Test
    public void shouldRemoveExistEmployee() {
        Employee addedEmployee = employeeServiceImp.addEmployee(FIRST_NAME, LAST_NAME, DEPARTMENT_ID, SALARY);
        assertEquals(1, employeeServiceImp.findAll().size());
        assertTrue(employeeServiceImp.findAll().contains(addedEmployee));

        Employee removedEmployee = employeeServiceImp.removeEmployee(FIRST_NAME, LAST_NAME, DEPARTMENT_ID, SALARY);
        assertEquals(addedEmployee, removedEmployee);
        assertEquals(0, employeeServiceImp.findAll().size());
        assertFalse(employeeServiceImp.findAll().contains(addedEmployee));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenRemoveEmployee() {
        assertEquals(0, employeeServiceImp.findAll().size());
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeServiceImp.removeEmployee(FIRST_NAME, LAST_NAME, DEPARTMENT_ID, SALARY));
    }

    @Test
    public void shouldReturnAllEmployee() {
        Employee employee1 = employeeServiceImp.addEmployee(FIRST_NAME, LAST_NAME, DEPARTMENT_ID, SALARY);
        Employee employee2 = employeeServiceImp.addEmployee(FIRST_NAME2, LAST_NAME2, DEPARTMENT_ID, SALARY);

        Collection<Employee> addedEmployees = employeeServiceImp.findAll();
        assertIterableEquals(List.of(employee1,employee2), addedEmployees);
    }
}