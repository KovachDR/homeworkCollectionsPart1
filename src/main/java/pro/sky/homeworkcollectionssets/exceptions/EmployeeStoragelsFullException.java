package pro.sky.homeworkcollectionssets.exceptions;

public class EmployeeStoragelsFullException extends RuntimeException{
    public EmployeeStoragelsFullException() {
    super("Список сотрудников полон");
    }


}
