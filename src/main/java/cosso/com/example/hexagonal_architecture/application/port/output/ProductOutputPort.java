package cosso.com.example.hexagonal_architecture.application.port.output;

import cosso.com.example.hexagonal_architecture.domain.model.Product;

import java.util.Optional;

public interface ProductOutputPort {

    Product saveProduct(Product product);

    Optional<Product> getProductById(Long id);
}
