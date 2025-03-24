package cosso.com.example.hexagonal_architecture.infrastructure.adapter.output.persistence;

import cosso.com.example.hexagonal_architecture.application.port.output.ProductOutputPort;
import cosso.com.example.hexagonal_architecture.domain.model.Product;
import cosso.com.example.hexagonal_architecture.infrastructure.adapter.output.persistence.entity.ProductEntity;
import cosso.com.example.hexagonal_architecture.infrastructure.adapter.output.persistence.mapper.ProductEntityMapper;
import cosso.com.example.hexagonal_architecture.infrastructure.adapter.output.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductPersistenceAdapter implements ProductOutputPort {

    private final ProductRepository productRepository;
    private final ProductEntityMapper productEntityMapper;


    @Override
    public Product saveProduct(Product product) {
        log.debug("[ProductPersistenceAdapter] Persisting product");
        ProductEntity productToPersist = productEntityMapper.toProductEntity(product);
        productToPersist = productRepository.save(productToPersist);
        log.debug("[ProductPersistenceAdapter] Product persisted");
        return this.productEntityMapper.toProduct(productToPersist);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        log.debug("[ProductPersistenceAdapter] Finding product by id {}", id);
        final Optional<ProductEntity> productFoundedById = productRepository.findById(id);
        log.debug("[ProductPersistenceAdapter] Returning product searched");
        return productFoundedById.isPresent() ? Optional.of(productEntityMapper.toProduct(productFoundedById.get())) : Optional.empty();
    }
}
