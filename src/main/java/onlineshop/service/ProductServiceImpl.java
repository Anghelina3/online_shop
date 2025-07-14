package onlineshop.service;

import jakarta.transaction.Transactional;
import onlineshop.exceptions.ProductNotFoundException;
import onlineshop.model.Product;
import onlineshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository){
       this.productRepository = productRepository;
    }
    
    @Override
    @Transactional
    public Product saveProduct(Product product){
            return productRepository.save(product);
    }
    @Override
    @Transactional
    public Product updateProduct(Product product, Long productId){
          Product existingProduct = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException(productId));
          if(product.getPrice()!= 0.0){
               existingProduct.setPrice(product.getPrice());
          }
          if(product.getImage()!= null){
             existingProduct.setImage(product.getImage());
          }

          return productRepository.save(existingProduct);
    }
    @Override
    @Transactional
    public void deleteProductId(Long productId){
         Product productToDelete = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException(productId));
         productRepository.delete(productToDelete);
    }
}
