package cosso.com.example.hexagonal_architecture.infrastructure.adapter.output.handlerexception.data.response;

import cosso.com.example.hexagonal_architecture.infrastructure.adapter.config.MessageConfig;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@ToString
public class ExceptionResponse {

    //private LocalDateTime time;
    private String status;
    private String message;

    public ExceptionResponse(String status, Object... args){
        // this.time = LocalDateTime.now();
        this.status = status;
        this.message = new MessageConfig().getMessage(status, args);
    }
}
