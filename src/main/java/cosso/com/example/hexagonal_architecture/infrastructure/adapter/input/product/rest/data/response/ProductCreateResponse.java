package cosso.com.example.hexagonal_architecture.infrastructure.adapter.input.product.rest.data.request;

import lombok.*;

import java.math.BigInteger;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateResponse {

    private BigInteger id;
    private String name;
    private String description;
}
