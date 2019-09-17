package ch.nyp.noa.config.error;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@ControllerAdvice
public class CustomGlobalExceptionHandler  {

    @Value("${constraint-info-message}")
    private String constraintInfoMessage;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionTemplate> generalException(Exception e) {
        ExceptionTemplate template = new ExceptionTemplate();
        template.put("message", "This is a general error");

        return new ResponseEntity<>(template, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ExceptionTemplate> noSuchElementException(NoSuchElementException e) {
        ExceptionTemplate template = new ExceptionTemplate();
        template.put("message", e.getMessage());

        return new ResponseEntity<>(template, HttpStatus.NOT_FOUND);
    }

    // error handle for @Valid / custom Annotations
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionTemplate> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

        ExceptionTemplate body = new ExceptionTemplate();

        // Put all fields which have violated constraints
        List<ViolatedField> constraintViolations = new ArrayList<>();

        ex.getBindingResult().getFieldErrors().forEach((fieldError) -> constraintViolations.add(new ViolatedField(fieldError.getField(), fieldError.getRejectedValue())));

        body.put("violated_fields", constraintViolations);

        // Put more information with link to swagger
        body.put("message", constraintInfoMessage);

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

}