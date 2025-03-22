package cosso.com.example.hexagonal_architecture.infrastructure.adapter.input.product.rest.mapper;


import cosso.com.example.hexagonal_architecture.domain.model.Product;
import cosso.com.example.hexagonal_architecture.infrastructure.adapter.input.product.rest.data.request.ProductCreateRequest;
import cosso.com.example.hexagonal_architecture.infrastructure.adapter.input.product.rest.data.response.ProductCreateResponse;
import cosso.com.example.hexagonal_architecture.infrastructure.adapter.input.product.rest.data.response.ProductQueryResponse;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public interface ProductRestMapper {

    Product toProduct(ProductCreateRequest productCreateRequest);

    ProductCreateResponse toProductCreateResponse(Product product);

    ProductQueryResponse toProductQueryResponse(Product product);
}
