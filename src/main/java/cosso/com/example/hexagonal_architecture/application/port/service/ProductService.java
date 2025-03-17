package cosso.com.example.hexagonal_architecture.application.port.service;

import cosso.com.example.hexagonal_architecture.application.port.input.CreateProductUseCase;
import cosso.com.example.hexagonal_architecture.application.port.output.ProductOutputPort;
import cosso.com.example.hexagonal_architecture.domain.model.Product;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductService implements CreateProductUseCase {

    private final ProductOutputPort productOutputPort;

    @Override
    public Product createProduct(Product product) {
        return productOutputPort.saveProduct(product);
    }
}
