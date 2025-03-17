package cosso.com.example.hexagonal_architecture.application.port.service;

import cosso.com.example.hexagonal_architecture.application.port.input.CreateProductUseCase;
import cosso.com.example.hexagonal_architecture.application.port.output.ProductOutputPort;
import cosso.com.example.hexagonal_architecture.domain.model.Product;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class ProductService implements CreateProductUseCase {

    @Override
    public Product createProduct(Product product) {
        log.debug("[ProductService] Creating product {}", product);
        product.setId(Long.parseLong("1"));
        log.debug("[ProductService] Product created {}", product);
        return product;
    }
}
