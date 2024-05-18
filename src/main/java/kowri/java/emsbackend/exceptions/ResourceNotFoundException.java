package kowri.java.emsbackend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String message) {
        super(message);
    }
}

//@ResponseStatus(value = HttpStatus.NOT_FOUND)
//public class IllegalArgumentException extends RuntimeException{
//
//    public IllegalArgumentException(String message) {
//        super(message);
//    }
//}
