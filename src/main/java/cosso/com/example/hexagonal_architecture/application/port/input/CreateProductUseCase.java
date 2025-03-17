package cosso.com.example.hexagonal_architecture.application.port.input;

import cosso.com.example.hexagonal_architecture.domain.model.Product;

public interface CreateProductUseCase {
    Product createProduct(Product product);
}
