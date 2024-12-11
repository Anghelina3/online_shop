package usersAPP;

import java.util.List;

public class Category {
       public String getName() {
	      return name;
       }

       public void setName(String name) {
	      this.name = name;
       }


       public List<Product> getProducts() {
	      return products;
       }

       public void setProducts(Product[] products) {
	      this.products = List.of(products);
       }

       private String name;

       private List<Product> products;

       public Category(String name, List<Product> products) {
	      this.name = name;
	      this.products = products;
       }
}
