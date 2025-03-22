package cosso.com.example.hexagonal_architecture.domain.exceptions;

import cosso.com.example.hexagonal_architecture.infrastructure.adapter.output.handlerexception.data.response.ExceptionResponse;
import org.springframework.http.HttpStatus;

import java.util.List;

public abstract class RestException extends RuntimeException {

    private String statusCode;
    private List<ExceptionResponse> errors;

    protected RestException(String statuscode, String message,List<ExceptionResponse> errors){
        super(message);
        this.statusCode = statuscode;
        this.errors = errors;
    }

    protected RestException(String statuscode, String message,ExceptionResponse error){
        super(message);
        this.statusCode = statuscode;
        this.errors = List.of(error);
    }

    public List<ExceptionResponse> getErrors() { return errors; }
    public abstract HttpStatus getStatusCode();


}
