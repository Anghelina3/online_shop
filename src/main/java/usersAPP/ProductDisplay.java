package usersAPP;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.util.List;

public class ProductDisplay{
       private ProductCatalog productCatalog;
       private HBox productDisplay;
       private USer currentUser; // Ссылка на текущего пользователя



       public ProductDisplay(USer user) {
	      this.currentUser = user; // Инициализация пользователя
	      this.productCatalog = new ProductCatalog();  // Инициализация productCatalog
	      this.productDisplay = new HBox(20);
       }

       public HBox getProductDisplay() {
	      List<Product> products = productCatalog.getProducts(); // Теперь можно безопасно вызвать

	      for (Product product : products) {
		     Label name = new Label(product.getName());
		     Button button = new Button();
		     ImageView imageView = new ImageView(product.getImage());
		     imageView.setFitHeight(150);
		     imageView.setFitWidth(150);

		     button.setText("Купить");
		     button.setStyle("-fx-text-fill: white");
		     button.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
		     button.setOnAction(e -> {
			    currentUser.getBasket().addProduct(product);
		     });

		     productDisplay.getChildren().add(name);
		     productDisplay.getChildren().add(button);
		     productDisplay.getChildren().add(imageView);


	      }

	      return productDisplay;
       }

}