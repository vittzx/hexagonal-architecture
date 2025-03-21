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

    private final ProductOutputPort productOutputPort;

    @Override
    public Product createProduct(Product product) {
        log.debug("[ProductService] Creating product {}", product);
        product = this.productOutputPort.saveProduct(product);
        log.debug("[ProductService] Product created {}", product);
        return product;
    }
}
