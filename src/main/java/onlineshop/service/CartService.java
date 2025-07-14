package onlineshop.service;

import onlineshop.model.Cart;
import onlineshop.model.CartItem;
import onlineshop.model.User;

public interface CartService {

       Cart createCart(User user);

       Cart getCart(Long cartId);

       Cart saveCart(Cart cart);

       Cart addItemToCart(CartItem item, Long cartId);

       Cart removeItemFromCart(Long cartId, Long itemId);

       void deleteCartId(Long cartId);

}
