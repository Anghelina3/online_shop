package usersAPP;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

public class Basket {
       private final ObservableList<Product> purchasedProducts;
       private final ListView<Product> listView;
       private final Label totalLabel;
       VBox basketBox;

       public Basket() {
	      this.purchasedProducts = FXCollections.observableArrayList();
	      this.listView = new ListView<>(purchasedProducts); // Создаем ListView
	      this.totalLabel = new Label("Total: $0.00"); // Метка для общей суммы
	      configureListView(); // Настраиваем ListView
	      this.basketBox = new VBox(10);
	      basketBox.setSpacing(10);
       }



       private void configureListView() {
	      listView.setCellFactory(param -> new ListCell<>() {
		     @Override
		     protected void updateItem(Product product, boolean empty) {
				   super.updateItem(product, empty);

			    if (empty || product == null) {
				   setText(null);
				   setGraphic(null);
			    } else {
				   // Создаем HBox для ячейки
				   HBox cellContent = new HBox(10);

				   // Добавляем изображение продукта
				   ImageView imageView = new ImageView(product.getImage());
				   imageView.setFitWidth(150);
				   imageView.setFitHeight(150);
				   imageView.setPreserveRatio(true);

				   // Добавляем информацию о продукте
				   Label label = new Label(product.getName() + " - $" + product.getPrice());

				   // Добавляем в контейнер
				   cellContent.getChildren().addAll(imageView, label);

				   setGraphic(cellContent);
			    }
		     }
	      });	

	      purchasedProducts.addListener((ListChangeListener<Product>) change -> updateTotal());


       }

       public VBox createBasketInterface() {
	      basketBox.getChildren().clear();

	      Label titleLabel = new Label("Ваша корзина:");
	      titleLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

	      // Добавляем элементы в VBox
	      basketBox.getChildren().addAll(titleLabel, listView, totalLabel);

	      return basketBox;
       }

       public void addProduct(Product product) {
	      purchasedProducts.add(product);
	      updateTotal();
       }

       private double updateTotal() {
	      double total = purchasedProducts.stream()
		      .mapToDouble(Product::getPrice)
		      .sum();
	      totalLabel.setText(String.format("Total: $%.2f", total));
              return total;
       }
       public List<Product> getPurchasedProducts() {
	      return purchasedProducts;
       }
}
