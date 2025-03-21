package cosso.com.example.hexagonal_architecture.domain.exceptions;

import org.springframework.http.HttpStatus;

public abstract class RestException extends RuntimeException {

    private String statusCode;

    protected RestException(String statuscode, String message){
        super(message);
        this.statusCode = statuscode;
    }

    public abstract HttpStatus getStatusCode();


}
