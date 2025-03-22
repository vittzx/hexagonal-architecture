package cosso.com.example.hexagonal_architecture.infrastructure.adapter.output.handlerexception;

import cosso.com.example.hexagonal_architecture.domain.enums.REQUEST_STATUS;
import cosso.com.example.hexagonal_architecture.domain.exceptions.ProductNotFoundException;
import cosso.com.example.hexagonal_architecture.infrastructure.adapter.input.product.ProductRestController;
import cosso.com.example.hexagonal_architecture.infrastructure.adapter.output.handlerexception.data.response.ExceptionResponse;
import cosso.com.example.hexagonal_architecture.infrastructure.adapter.output.handlerexception.data.response.ResponseErrorMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

import static cosso.com.example.hexagonal_architecture.application.utils.MessageConstants.*;

@Slf4j
@RestControllerAdvice(assignableTypes = ProductRestController.class)
@Order(Ordered.HIGHEST_PRECEDENCE)
@RequiredArgsConstructor
public class ProductRestControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleGeneralException(final Exception ex, final WebRequest request){
        log.error("Handling Exception {}", ex.getMessage());
        final ExceptionResponse exResponse = new ExceptionResponse(INTERNAL_SERVER_ERROR);
        return createErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, exResponse);
    }

    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<Object> handleProductNotFoundException(final ProductNotFoundException ex, final WebRequest request){
        log.error("Handling ProductNotFoundException {}", ex.getMessage());
        return createErrorResponse(HttpStatus.NOT_FOUND, ex.getErrors());
    }

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(final MethodArgumentTypeMismatchException ex, final WebRequest request){
        log.error("Handling MethodArgumentTypeMismatchException {}", ex.getMessage());
        return createErrorResponse(HttpStatus.BAD_REQUEST, new ExceptionResponse(FIELD_INVALID , ex.getName()));
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatusCode code, final WebRequest request){
        log.error("Handling MethodArgumentNotValidException {}", ex.getMessage());
        System.out.println(ex.getParameter());
        return createErrorResponse(HttpStatus.BAD_REQUEST, new ExceptionResponse(REQUEST_INVALID));
    }

    private ResponseEntity<Object> createErrorResponse(HttpStatus status, ExceptionResponse body){
        return ResponseEntity.status(status).body(new ResponseErrorMessage(REQUEST_STATUS.FAIL, body));
    }

    private ResponseEntity<Object> createErrorResponse(HttpStatus status, List<ExceptionResponse> body){
        return ResponseEntity.status(status).body(new ResponseErrorMessage(REQUEST_STATUS.FAIL, body));
    }
}
