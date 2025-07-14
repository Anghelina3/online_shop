package onlineshop.controller;

import onlineshop.model.Cart;
import onlineshop.repository.CartRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

	      CartRepository cartRepository;

	      CartController(CartRepository cartRepository) {
		     this.cartRepository = cartRepository;
	      }

	      @GetMapping(value = "/{id}", produces = "application/json")
	      public Cart getCart(@PathVariable("id") Long cartId){
		     Optional<Cart> cart = cartRepository.findById(cartId);
		     return cart.orElse(null);
	      }



	      @PostMapping
	      public Cart createCart(@RequestBody Cart cart) {
		     return cartRepository.save(cart);
	      }
       }


