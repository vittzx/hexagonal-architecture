package cosso.com.example.hexagonal_architecture.infrastructure.adapter.input.product.rest.data.response;

import cosso.com.example.hexagonal_architecture.domain.enums.REQUEST_STATUS;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseSuccessMessage<T> {
    private String time;
    private REQUEST_STATUS status;
    private T response;

    public ResponseSuccessMessage(T errors) {
        this.time = LocalDateTime.now().toString();
        this.status = REQUEST_STATUS.SUCCESS;
        this.response = errors;
    }


}
