package onlineshop.service;

import onlineshop.model.Cart;
import org.springframework.stereotype.Service;

@Service
public interface CartService{
       Cart saveCart(Cart cart);

       Cart updateCart(Cart cart, Long cartId);

       void deleteCartId(Long cartId);
}
