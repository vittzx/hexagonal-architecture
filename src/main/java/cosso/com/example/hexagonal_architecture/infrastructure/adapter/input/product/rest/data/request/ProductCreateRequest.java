package cosso.com.example.hexagonal_architecture.infrastructure.adapter.input.product.rest.data.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import static cosso.com.example.hexagonal_architecture.application.utils.MessageConstants.FIELD_REQUIRED;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ProductCreateRequest {

   @NotEmpty(message = FIELD_REQUIRED)
   private String name;

   @NotEmpty(message = FIELD_REQUIRED)
   private String description;
}
