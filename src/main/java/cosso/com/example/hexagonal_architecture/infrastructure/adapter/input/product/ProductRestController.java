package cosso.com.example.hexagonal_architecture.infrastructure.adapter.input.product;

import cosso.com.example.hexagonal_architecture.domain.model.Product;
import cosso.com.example.hexagonal_architecture.infrastructure.adapter.input.product.rest.data.request.ProductCreateRequest;
import cosso.com.example.hexagonal_architecture.infrastructure.adapter.input.product.rest.data.response.ProductCreateResponse;
import cosso.com.example.hexagonal_architecture.infrastructure.adapter.input.product.rest.mapper.ProductRestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("v1/product")
@RestController
@Slf4j
@RequiredArgsConstructor
public class ProductRestController {

    private final ProductRestMapper productRestMapper;

    @PostMapping
    public ResponseEntity<ProductCreateResponse> createProduct(@RequestBody @Valid ProductCreateRequest productCreateRequestBody){
        log.debug("STARTED POST v1/products: {}", productCreateRequestBody);
        Product product = productRestMapper.toProduct(productCreateRequestBody);
        ProductCreateResponse response = productRestMapper.toProductCreateResponse(product);
        log.debug("STARTED POST v1/products: {}", productCreateRequestBody);
        return ResponseEntity.status(201).body(response);
    }




}
