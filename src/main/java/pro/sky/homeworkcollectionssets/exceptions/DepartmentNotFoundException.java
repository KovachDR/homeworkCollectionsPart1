package pro.sky.homeworkcollectionssets.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DepartmentNotFoundException extends RuntimeException{
    public DepartmentNotFoundException() {
        super("Такой отдел не найден. Введите значение от 1 до 5");
    }
}
