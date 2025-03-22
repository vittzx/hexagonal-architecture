package cosso.com.example.hexagonal_architecture.infrastructure.adapter.output.handlerexception;

import cosso.com.example.hexagonal_architecture.domain.exceptions.ProductNotFoundException;
import cosso.com.example.hexagonal_architecture.infrastructure.adapter.input.product.ProductRestController;
import cosso.com.example.hexagonal_architecture.infrastructure.adapter.output.handlerexception.data.response.ExceptionResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static cosso.com.example.hexagonal_architecture.application.utils.MessageConstants.INTERNAL_SERVER_ERROR;

@Slf4j
@RestControllerAdvice(assignableTypes = ProductRestController.class)
@Order(Ordered.HIGHEST_PRECEDENCE)
@RequiredArgsConstructor
public class ProductRestControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleGeneralException(final Exception ex, final WebRequest request){
        log.error("Handling Exception {}", ex.getMessage());
        final ExceptionResponse exResponse = new ExceptionResponse(INTERNAL_SERVER_ERROR);
        return ResponseEntity.internalServerError().body(exResponse);
    }

    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<Object> handleProductNotFoundException(final ProductNotFoundException ex, final WebRequest request){
        log.error("Handling ProductNotFoundException {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getErrors());
    }
}
