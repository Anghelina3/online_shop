package onlineshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {
       public ProductNotFoundException(Long productId){
            super("Product wasn't found with Id " + productId);
       }

       public ProductNotFoundException(String message){
	      super(message);
       }
}
