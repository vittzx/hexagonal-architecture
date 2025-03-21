package cosso.com.example.hexagonal_architecture.service;

import cosso.com.example.hexagonal_architecture.application.port.output.ProductOutputPort;
import cosso.com.example.hexagonal_architecture.application.port.service.ProductService;
import cosso.com.example.hexagonal_architecture.domain.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {


    @Mock
    private ProductOutputPort outputPort;
    private Product p;
    private Product finalProduct;
    @InjectMocks
    private ProductService service;

    @BeforeEach
    void setUp(){
        p = Product
                .builder()
                .name("Apple watch")
                .description("Series S")
                .build();

        finalProduct = Product
                .builder()
                .id(Long.valueOf("1"))
                .name("Apple watch")
                .description("Series S")
                .build();
    }


    @Test
    void shouldReturnSuccessfully(){
        when(outputPort.saveProduct(p)).thenReturn(finalProduct);
        Product finalProductTeste = service.createProduct(p);
        assertEquals(finalProduct, finalProductTeste);
        assertNotNull(finalProductTeste);
    }



}
