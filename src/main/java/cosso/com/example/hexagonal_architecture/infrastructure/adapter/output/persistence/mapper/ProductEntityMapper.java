package cosso.com.example.hexagonal_architecture.infrastructure.adapter.output.persistence.mapper;

import cosso.com.example.hexagonal_architecture.domain.model.Product;
import cosso.com.example.hexagonal_architecture.infrastructure.adapter.output.persistence.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ProductEntityMapper {

    ProductEntity toProductEntity(Product product);

    Product toProduct(ProductEntity productEntity);
}
