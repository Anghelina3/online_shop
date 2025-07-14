package onlineshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // Автоматически вернет 404
public class ItemNotFoundException extends RuntimeException{
       public ItemNotFoundException(Long itemId){
	      super("Item with id: " + itemId + " wasn't found.");
       }

       public ItemNotFoundException(String message){
	      super(message);
       }
}
