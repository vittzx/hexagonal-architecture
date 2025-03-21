package cosso.com.example.hexagonal_architecture.application.port.input;

import cosso.com.example.hexagonal_architecture.domain.model.Product;

public interface GetProductUseCase {

    Product getProductById(Long id);

}
