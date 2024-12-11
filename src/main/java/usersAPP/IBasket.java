package usersAPP;

import java.util.List;

public interface IBasket {
       void addProduct(Product product);
       List<Product> getProducts();
       double getTotalPrice();


}
