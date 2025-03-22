package cosso.com.example.hexagonal_architecture.infrastructure.adapter.input.product;

import cosso.com.example.hexagonal_architecture.application.port.input.CreateProductUseCase;
import cosso.com.example.hexagonal_architecture.application.port.input.GetProductUseCase;
import cosso.com.example.hexagonal_architecture.domain.model.Product;
import cosso.com.example.hexagonal_architecture.infrastructure.adapter.input.product.rest.data.request.ProductCreateRequest;
import cosso.com.example.hexagonal_architecture.infrastructure.adapter.input.product.rest.data.response.ProductCreateResponse;
import cosso.com.example.hexagonal_architecture.infrastructure.adapter.input.product.rest.data.response.ProductQueryResponse;
import cosso.com.example.hexagonal_architecture.infrastructure.adapter.input.product.rest.data.response.ResponseSuccessMessage;
import cosso.com.example.hexagonal_architecture.infrastructure.adapter.input.product.rest.mapper.ProductRestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("v1/products")
@RestController
@Slf4j
@RequiredArgsConstructor
public class ProductRestController {

    private final CreateProductUseCase createProductUseCase;
    private final GetProductUseCase getProductUseCase;

    private final ProductRestMapper productRestMapper;

    @PostMapping
    public ResponseEntity<ResponseSuccessMessage<ProductCreateResponse>> createProduct(@RequestBody @Valid ProductCreateRequest productCreateRequestBody){
        log.debug("STARTED POST v1/products: {}", productCreateRequestBody);
        Product product = productRestMapper.toProduct(productCreateRequestBody);
        product = this.createProductUseCase.createProduct(product);
        ProductCreateResponse response = productRestMapper.toProductCreateResponse(product);
        log.debug("FINISHED POST v1/products: {}", productCreateRequestBody);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ResponseSuccessMessage<>(response)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseSuccessMessage<ProductQueryResponse>> getProductById(@PathVariable final Long id){
        log.debug("STARTED GET v1/products/{}", id);
        Product productFound = this.getProductUseCase.getProductById(id);
        log.debug("FINISHED GET v1/products/{}", id);
        ProductQueryResponse response = this.productRestMapper.toProductQueryResponse(productFound);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseSuccessMessage<>(response)
        );
    }




}
