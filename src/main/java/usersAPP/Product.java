package usersAPP;

public class Product {
       public int getPrice() {
	      return price;
       }
       public String getName() {
	      return name;
       }

       private String name;
       private int price;

       public javafx.scene.image.Image getImage() {
	      return image;
       }

       private javafx.scene.image.Image image;

       public Product(String name, int price, javafx.scene.image.Image image) {
	      this.name = name;
	      this.price = price;
	      this.image = image;
       }




}
