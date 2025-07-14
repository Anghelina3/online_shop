package onlineshop.service;

import jakarta.transaction.Transactional;
import onlineshop.exceptions.CartNotFoundException;
import onlineshop.exceptions.ItemNotFoundException;
import onlineshop.model.Cart;
import onlineshop.model.CartItem;
import onlineshop.model.User;
import onlineshop.repository.CartItemRepository;
import onlineshop.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CartServiceImpl implements CartService {

       private final CartRepository cartRepository;
       private final CartItemRepository cartItemRepository;

       public CartServiceImpl(CartRepository cartRepository, CartItemRepository cartItemRepository) {
	      this.cartRepository = cartRepository;
	      this.cartItemRepository = cartItemRepository;
       }

       @Transactional
       @Override
       public Cart createCart(User user) {

	      Cart cart = new Cart();
	      cart.setUser(user);
	      cart.setItems(new ArrayList<>());
	      cart.setTotalPrice(0.0);

	      return cartRepository.save(cart);
       }

       @Transactional
       @Override
       public Cart getCart(Long cartId) {
	      return cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException(("Корзина с ID " + cartId + " не найдена")));
       }

       @Transactional
       @Override
       public Cart saveCart(Cart cart) {
	      return cartRepository.save(cart);
       }

       @Transactional
       @Override
       public Cart addItemToCart(CartItem item, Long cartId) {
	      Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new CartNotFoundException(cartId));

	      item.setCart(cart);
	      cartItemRepository.save(item);
	      recalculateTotalPrice(cart);
	      return cart;

       }

       @Transactional
       protected void recalculateTotalPrice(Cart cart) {
	      double total = cart.getItems().stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
	      cart.setTotalPrice(total);
       }

       @Transactional
       @Override
       public Cart removeItemFromCart(Long cartId, Long itemId) {
	      Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new CartNotFoundException(cartId));

	      CartItem itemToRemove = cart.getItems().stream().filter(item -> item.getId().equals(itemId)).findFirst().orElseThrow(() -> new ItemNotFoundException(itemId));
	      cart.getItems().remove(itemToRemove);

	      recalculateTotalPrice(cart);

	      return cartRepository.save(cart);
       }

       @Transactional
       @Override
       public void deleteCartId(Long cartId) {
	      cartRepository.deleteById(cartId);
       }

}
