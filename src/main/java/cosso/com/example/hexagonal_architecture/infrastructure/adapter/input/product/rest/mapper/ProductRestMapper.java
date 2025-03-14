package cosso.com.example.hexagonal_architecture.infrastructure.adapter.input.product.rest.mapper;


import cosso.com.example.hexagonal_architecture.domain.model.Product;
import cosso.com.example.hexagonal_architecture.infrastructure.adapter.input.product.rest.data.request.ProductCreateRequest;
import cosso.com.example.hexagonal_architecture.infrastructure.adapter.input.product.rest.data.response.ProductCreateResponse;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductRestMapper {

    public Product toProduct(ProductCreateRequest productCreateRequest){
        return Product.builder()
                .name(productCreateRequest.getName())
                .description(productCreateRequest.getDescription())
                .build();
    }

    public ProductCreateResponse toProductCreateResponse(Product product){
        return ProductCreateResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .build();
    }

}
