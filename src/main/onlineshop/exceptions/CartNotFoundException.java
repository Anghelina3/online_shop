package onlineshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // Автоматически вернет 404

public class CartNotFoundException extends RuntimeException{
       public CartNotFoundException(Long cartId){
	      super("Cart not found with ID: " + cartId);
       }

       public CartNotFoundException(String message) {
	      super(message);
       }

}
