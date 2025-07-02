package onlineshop.service;

import onlineshop.model.Cart;
import onlineshop.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CartServiceImpl implements CartService{
       @Autowired
       private CartRepository cartRepository;
       @Override
       public Cart saveCart(Cart cart) {
	      return cartRepository.save(cart);
       }

       @Override
       public Cart updateCart(Cart cart, Long cartId) {
	      return cart; // нужно подумать над методом
       }

       @Override
       public void deleteCartId(Long cartId) {
            cartRepository.deleteById(cartId);
       }

}
