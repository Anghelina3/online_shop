package onlineshop.controller;

import onlineshop.model.CartItem;
import onlineshop.repository.CartItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/cartItem")
public class CartItemController {

	      CartItemRepository cartItemRepository;

	      public CartItemController(CartItemRepository cartItemRepository) {
		     this.cartItemRepository = cartItemRepository;
	      }

	      @GetMapping(value = "/{id}")
	      public CartItem getCartItem(@PathVariable("id") Long cartItemId){
		     Optional<CartItem> cartItem = cartItemRepository.findById(cartItemId);
		     return cartItem.orElse(null);
	      }



	      @PostMapping
	      public CartItem createCartItem(@RequestBody CartItem cartItem) {
		     return cartItemRepository.save(cartItem);
	      }
       }

