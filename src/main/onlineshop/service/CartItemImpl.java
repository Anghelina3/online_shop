package onlineshop.service;

import onlineshop.exceptions.ItemNotFoundException;
import onlineshop.model.CartItem;
import onlineshop.repository.CartItemRepository;
import org.springframework.stereotype.Service;

@Service
public class CartItemImpl implements CartItemService{

       private final CartItemRepository cartItemRepository;

       public CartItemImpl(CartItemRepository cartItemRepository){
	      this.cartItemRepository = cartItemRepository;
       }
       @Override
       public CartItem saveCartItem(CartItem item) {
	      return cartItemRepository.save(item);
       }

       @Override
       public CartItem updateCartItem(CartItem item, Long cartId) {
	      CartItem cartItem = cartItemRepository.findById(cartId).orElseThrow(() -> new ItemNotFoundException(cartId));


	      if(item.getQuantity() != 0){
                  cartItem.setQuantity(item.getQuantity());
	      }


	      return cartItemRepository.save(cartItem);
       }

       @Override
       public void deleteCartItem(Long cartItemId) {
	      cartItemRepository.deleteById(cartItemId);
       }
}
