package cosso.com.example.hexagonal_architecture.application.port.service;

import cosso.com.example.hexagonal_architecture.application.port.input.CreateProductUseCase;
import cosso.com.example.hexagonal_architecture.application.port.input.GetProductUseCase;
import cosso.com.example.hexagonal_architecture.application.port.output.ProductOutputPort;
import cosso.com.example.hexagonal_architecture.domain.exceptions.ProductNotFoundException;
import cosso.com.example.hexagonal_architecture.domain.model.Product;
import cosso.com.example.hexagonal_architecture.infrastructure.adapter.output.handlerexception.data.response.ExceptionResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static cosso.com.example.hexagonal_architecture.application.utils.MessageConstants.PRODUCT_NOT_FOUND;

@AllArgsConstructor
@Service
@Slf4j
public class ProductService implements CreateProductUseCase, GetProductUseCase {

    private final ProductOutputPort productOutputPort;

    @Override
    public Product createProduct(Product product) {
        log.debug("[ProductService] Creating product {}", product);
        product = this.productOutputPort.saveProduct(product);
        log.debug("[ProductService] Product created {}", product);
        return product;
    }

    @Override
    public Product getProductById(Long id){
        log.debug("[ProductService] Getting product by id: {}", id);
        Product product = this.productOutputPort.getProductById(id).orElseThrow(() -> {
            log.error("Caught error: Product not found by id: {}", id);
            return new ProductNotFoundException(new ExceptionResponse(PRODUCT_NOT_FOUND, id));
        });
        log.debug("[ProductService] Product founded: {}", product);
        return product;
    }
}
