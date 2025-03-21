package cosso.com.example.hexagonal_architecture.infrastructure.adapter.input.product.rest.data.response;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductQueryResponse {

    private Long id;
    private String name;
    private String description;

}
