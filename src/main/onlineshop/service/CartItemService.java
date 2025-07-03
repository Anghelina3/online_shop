package onlineshop.service;

import onlineshop.model.CartItem;
import org.springframework.stereotype.Service;

public interface CartItemService {
       CartItem saveCartItem(CartItem item);

       CartItem updateCartItem(CartItem item, Long  cartId);

       void deleteCartItem(Long  cartId);
}
