package cosso.com.example.hexagonal_architecture.infrastructure.adapter.input.product.rest.data.response;


import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCreateResponse {

    private BigInteger id;
    private String name;
    private String description;
}
