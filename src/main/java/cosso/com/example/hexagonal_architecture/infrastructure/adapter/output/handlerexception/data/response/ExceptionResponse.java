package cosso.com.example.hexagonal_architecture.infrastructure.adapter.output.handlerexception.data.response;

import cosso.com.example.hexagonal_architecture.infrastructure.adapter.config.MessageConfig;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
public class ExceptionResponse {

    private String time;
    private String status;
    private String message;

    public ExceptionResponse(String status, Object... args){
        this.time = LocalDate.now().toString();
        this.status = status;
        this.message = new MessageConfig().getMessage(status, args);
    }
}
