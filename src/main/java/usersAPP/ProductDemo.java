package usersAPP;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


public class ProductDemo {

       public VBox createProductView(USer user) {
	      VBox productBox = new VBox(10);
	      productBox.setAlignment(Pos.CENTER);
	      productBox.setPadding(new Insets(20)); // Отступы для всего контейнера

	      for (Product product : user.getBasket().getPurchasedProducts()) {
		     VBox productEntry = new VBox(20);
		     productEntry.setAlignment(Pos.CENTER);
		     productEntry.setPadding(new Insets(60)); // Отступы вокруг каждого продукта

		     Label productLabel = new Label(product.getName() + " ($" + product.getPrice() + ")");
		     productLabel.setMinWidth(150); // Минимальная ширина для текста (можно настроить по необходимости)

		     ImageView image = new ImageView(product.getImage());
		     image.setFitWidth(350);

		     image.setPreserveRatio(true);

		     productEntry.getChildren().addAll(productLabel, image);
		     productBox.getChildren().add(productEntry);
	      }

	      return productBox;

       }
}
