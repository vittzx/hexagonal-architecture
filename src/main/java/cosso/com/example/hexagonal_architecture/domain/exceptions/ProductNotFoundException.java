package cosso.com.example.hexagonal_architecture.domain.exceptions;

import cosso.com.example.hexagonal_architecture.infrastructure.adapter.output.handlerexception.data.response.ExceptionResponse;
import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends RestException {

    public ProductNotFoundException(ExceptionResponse ex) {
        super(ex.getStatus(), ex.getMessage());
        }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}
