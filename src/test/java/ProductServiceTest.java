import onlineshop.exceptions.ProductNotFoundException;
import onlineshop.model.Product;
import onlineshop.repository.ProductRepository;
import onlineshop.service.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {
       @Mock
       private ProductRepository productRepository;

       @InjectMocks
       private ProductServiceImpl productServiceImpl;

       @Test
       void saveProduct() {
	      Product product = new Product(1L, "Book", 10.0, "image");
	      when(productRepository.save(product)).thenReturn(product);

	      Product savedProduct = productServiceImpl.saveProduct(product);
	      assertEquals(product, savedProduct);
       }

       @Test
       void updateProduct(){
	      Long productId = 1L;
	      Product existingProduct = new Product(productId, "Book", 10.0, "image");
	      Product productNew = new Product(productId, "Book", 10.0, "imageNew");

	      // Мокаем поведение репозитория
	      when(productRepository.findById(productId)).thenReturn(java.util.Optional.of(existingProduct));
	      when(productRepository.save(existingProduct)).thenReturn(existingProduct);
	      Product result = productServiceImpl.updateProduct(productNew, productId);

	      assertEquals(10.0, result.getPrice());
	      assertEquals("imageNew", result.getImage());
       }

       @Test
       void updateProduct_notFound(){
	      Long productId = 1L;

	      Product productNew = new Product(productId, "Book", 10.0, "imageNew");

	      // Мокаем поведение репозитория
	      when(productRepository.findById(productId)).thenReturn(java.util.Optional.empty());

	      assertThrows(ProductNotFoundException.class, () -> productServiceImpl.updateProduct(productNew, productId));
       }
}