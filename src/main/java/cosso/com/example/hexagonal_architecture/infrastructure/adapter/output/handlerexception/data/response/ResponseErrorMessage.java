package cosso.com.example.hexagonal_architecture.infrastructure.adapter.output.handlerexception.data.response;

import cosso.com.example.hexagonal_architecture.domain.enums.REQUEST_STATUS;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseErrorMessage {
    private String time;
    private REQUEST_STATUS status;
    private List<ExceptionResponse> errors;

    public ResponseErrorMessage(REQUEST_STATUS status, List<ExceptionResponse> errors) {
        this.time = LocalDateTime.now().toString();
        this.status = status;
        this.errors = errors;
    }

    public ResponseErrorMessage(REQUEST_STATUS status, ExceptionResponse error) {
        this.time = LocalDateTime.now().toString();
        this.status = status;
        this.errors = List.of(error);
    }
}
