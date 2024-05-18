package kowri.java.emsbackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException resource) {
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("message", resource.getMessage());
        responseMap.put("status", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
    }
}
