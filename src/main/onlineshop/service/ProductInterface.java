package onlineshop.service;

import onlineshop.model.Product;
import org.springframework.stereotype.Service;

public interface ProductInterface {
       Product saveProduct(Product product);

       Product updateProduct(Product product, Long productId);

       void deleteProductId(Long productId);
}
