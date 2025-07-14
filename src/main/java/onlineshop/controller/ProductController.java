package onlineshop.controller;

import onlineshop.model.Product;
import onlineshop.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

       ProductRepository productRepository;

       public ProductController(ProductRepository productRepository) {
	      this.productRepository = productRepository;
       }

       @GetMapping(value = "/{id}")
       public Product getProduct(@PathVariable("id") Long productId) {
	      Optional<Product> product = productRepository.findById(productId);
	      return product.orElse(null);
       }


       @PostMapping
       public Product createUser(@RequestBody Product product) {
	      return productRepository.save(product);
       }

       @GetMapping
       public List<Product> getAllProducts() {
	      return productRepository.findAll();
       }
}


