package cosso.com.example.hexagonal_architecture.infrastructure.adapter.output.persistence.repository;

import cosso.com.example.hexagonal_architecture.infrastructure.adapter.output.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
