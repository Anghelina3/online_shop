package onlineshop.service;

import onlineshop.model.Product;

public interface ProductService {
       Product saveProduct(Product product);

       Product updateProduct(Product product, Long productId);

       void deleteProductId(Long productId);
}
