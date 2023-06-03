package pro.sky.homeworkcollectionssets.service;

import pro.sky.homeworkcollectionssets.model.Employee;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class ConstansForTest {
    public static final String FIRST_NAME = "Maxim";
    public static final String LAST_NAME = "Maximov";
    public static final String FIRST_NAME2 = "Alex";
    public static final String LAST_NAME2 = "Alexeev";
    public static final int SALARY = 1000;
    public static final int MAX_SALARY = 1_000_000;
    public static final int DEPARTMENT_ID = 1;
    public static final int DEPARTMENT_ID_2 = 2;

    public static final Employee MAX_SALARY_EMPLOYEE = new Employee(FIRST_NAME, LAST_NAME, DEPARTMENT_ID, MAX_SALARY);
    public static final Employee MIN_SALARY_EMPLOYEE = new Employee(FIRST_NAME2, LAST_NAME2, DEPARTMENT_ID, SALARY);
    public static final Employee DIFFERENT_DEPARTMENT_EMPLOYEE = new Employee(FIRST_NAME2, LAST_NAME2, DEPARTMENT_ID_2, SALARY);
    public static final List<Employee> EMPLOYEES = List.of(MAX_SALARY_EMPLOYEE, MIN_SALARY_EMPLOYEE);
    public static final List<Employee> DIFFERENT_DEPARTMENT_EMPLOYEES = List.of(MAX_SALARY_EMPLOYEE, DIFFERENT_DEPARTMENT_EMPLOYEE);

    public static final Map<Integer,List<Employee>> EMPLOYEES_BY_DEPARTMENT_MAP = DIFFERENT_DEPARTMENT_EMPLOYEES.stream()
            .collect(groupingBy(Employee :: getDepartment));
}
