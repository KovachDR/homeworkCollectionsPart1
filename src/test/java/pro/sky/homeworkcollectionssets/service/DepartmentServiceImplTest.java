package pro.sky.homeworkcollectionssets.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.homeworkcollectionssets.exceptions.EmployeeNotFoundException;

import static java.util.Collections.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static pro.sky.homeworkcollectionssets.service.ConstansForTest.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @Test
    public void shouldReturnEmployeeWithMaxSalaryByDepartmentID() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);

        assertEquals(MAX_SALARY_EMPLOYEE, departmentService.findEmployeeWithMaxSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindEmployeeWithMaxSalaryByDepartmentId() {
        when(employeeService.findAll()).thenReturn(emptyList());

        assertThrows(EmployeeNotFoundException.class,
                () -> departmentService.findEmployeeWithMaxSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldReturnEmployeeWithMaxSalaryByOtherDepartmentID() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);

        assertThrows(EmployeeNotFoundException.class,
                () -> departmentService.findEmployeeWithMaxSalary(DEPARTMENT_ID_2));
    }

    @Test
    public void shouldReturnEmployeeWithMinSalaryByDepartmentID() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);

        assertEquals(MIN_SALARY_EMPLOYEE, departmentService.findEmployeeWithMinSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenFindEmployeeWithMinSalaryByDepartmentId() {
        when(employeeService.findAll()).thenReturn(emptyList());

        assertThrows(EmployeeNotFoundException.class,
                () -> departmentService.findEmployeeWithMinSalary(DEPARTMENT_ID));
    }

    @Test
    public void shouldReturnEmployeeWithMinSalaryByOtherDepartmentID() {
        when(employeeService.findAll()).thenReturn(EMPLOYEES);

        assertThrows(EmployeeNotFoundException.class,
                () -> departmentService.findEmployeeWithMinSalary(DEPARTMENT_ID_2));
    }

    @Test
    public void shouldFindEmployeeByDepartmentId() {
        when(employeeService.findAll()).thenReturn(DIFFERENT_DEPARTMENT_EMPLOYEES);

        assertEquals(singletonList(MAX_SALARY_EMPLOYEE),departmentService.findEmployeesByDepartment(DEPARTMENT_ID));
        assertEquals(singletonList(DIFFERENT_DEPARTMENT_EMPLOYEE),departmentService.findEmployeesByDepartment(DEPARTMENT_ID_2));
    }

    @Test
    public void shouldReturnEmptyEmployeesMapByDepartment() {
        when(employeeService.findAll()).thenReturn(emptyList());

        assertEquals(emptyMap(), departmentService.findEmployeesByDepartment());
    }
    @Test
    public void shouldReturnNotEmptyEmployeesMapByDepartment() {
        when(employeeService.findAll()).thenReturn(DIFFERENT_DEPARTMENT_EMPLOYEES);

        assertEquals(EMPLOYEES_BY_DEPARTMENT_MAP, departmentService.findEmployeesByDepartment());
    }
}