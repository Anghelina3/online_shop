package onlineshop.service;

import onlineshop.model.CartItem;

public interface CartItemService {
       CartItem saveCartItem(CartItem item);

       CartItem updateCartItem(CartItem item, Long cartId);

       void deleteCartItem(Long cartId);
}
