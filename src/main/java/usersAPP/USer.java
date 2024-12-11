package usersAPP;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.ByteArrayInputStream;
import java.util.List;

public class USer {
       private List<Product> userProducts;


       public USer(String login, String password, String name, double amount, String image) {
	      //  this.basket = basket;
	      this.login = login;
	      this.password = password;
	      this.name = name;
	      this.amount = amount;
	      this.image = image;
	      this.basket = new Basket(); // Инициализация корзины

       }

       public String getName() {
	      return name;
       }

       private final String image;

       private Basket basket;

       ImageView getImage() {
	      ImageView myImageView = new ImageView(image);
	      myImageView.setFitHeight(200);
	      myImageView.setFitWidth(250);

	      // Создаем ImageView для отображения изображения
	      return myImageView;
       }


       private final String name;

       public String getLogin() {
	      return login;
       }

       public void setLogin(String login) {
	      this.login = login;
       }

       public String getPassword() {
	      return password;
       }

       public void setPassword(String password) {
	      this.password = password;
       }

       public Basket getBasket() {
	      return basket;
       }

       public void setBasket(Basket basket) {
	      this.basket = basket;
       }

       private String login;
       private String password;

       public double getAmount() {
	      return amount;
       }

       public void setAmount(double amount) {
	      this.amount = amount;
       }

       double amount;

       private VBox createUserInfoBox(){
	      VBox infoBox = new VBox();

	      Label nameLabel = new Label("Name: " + name);
	      nameLabel.getStyleClass().add("label");

	      Label amountLabel = new Label("Balance: $" + amount);
	      amountLabel.getStyleClass().add("label");

	      ImageView userImageView = getImage(); // Используем ImageView для отображения изображения
	      userImageView.getStyleClass().add("image-view");
	      userImageView.setFitWidth(350);
	      userImageView.setFitHeight(300);
	      infoBox.getChildren().addAll(nameLabel, amountLabel, userImageView);
	      return infoBox;

       }

       public VBox createUserInterface(USer user) {
	      VBox userBox = new VBox(10);
	      userBox.setAlignment(Pos.CENTER); // Выравнивание элементов по центру
	      userBox.getChildren().addAll(createUserInfoBox(), createUserActions(userBox));
         return userBox;



       }


       private HBox createUserActions(VBox userBox){

	      HBox actionBox = new HBox(10);
	      actionBox.setAlignment(Pos.CENTER);
	      ToggleButton viewBasketButton = new ToggleButton();
	      viewBasketButton.getStyleClass().add("button");


	      viewBasketButton.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
	      viewBasketButton.setGraphic(new ImageView(new Image("file:/C:/Users/Anghelina/Downloads/shopping-cart-_1_ 1.png")));
	      // Добавьте обработчик для кнопки
	      viewBasketButton.setOnAction(event -> {
		     if (viewBasketButton.isSelected()) {
			    if (!userBox.getChildren().contains(basket.createBasketInterface())) {
				   userBox.getChildren().add(basket.createBasketInterface());}
	      }
		     else  userBox.getChildren().remove(basket.createBasketInterface());

	      });

	      actionBox.getChildren().add(viewBasketButton);
	      return actionBox;
       }


       public void addUserProducts(Product product) {
            userProducts.add(product);
       }

       public List<Product>  getUserProducts(Product product) {
	     return  userProducts;
       }
}
