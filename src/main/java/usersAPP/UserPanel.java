	      package usersAPP;

	      import javafx.application.Application;
	      import javafx.geometry.Insets;
	      import javafx.geometry.Pos;
	      import javafx.scene.Scene;
	      import javafx.scene.control.*;
	      import javafx.scene.layout.*;
	      import javafx.scene.paint.Color;
	      import javafx.stage.Stage;

	      import java.util.ArrayList;
	      import java.util.List;

	      public class UserPanel extends Application {
		     private Stage stage;
		     private List<USer> users = new ArrayList<>();  // Инициализация списка

		     @Override
		     public void start(Stage stage) {
			    this.stage = stage;

			    UserData userData = new UserData();
			    users = userData.getUsers();

			    VBox loginPanel = createLogin_PasswordScene();
			    loginPanel.setBackground(new Background(new BackgroundFill(Color.DODGERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

			    ScrollPane scrollPane = new ScrollPane(loginPanel);
			    scrollPane.setFitToWidth(true);
			    scrollPane.setFitToHeight(true);
			    Scene loginScene = new Scene(scrollPane, 400, 400);

			    stage.setTitle("Product Demo");
			    stage.setScene(loginScene);

			    stage.show();
		     }

			    private VBox createLogin_PasswordScene() {
				   VBox root = new VBox(10);
				   root.setPadding(new Insets(20));
				   root.setAlignment(Pos.CENTER);

				   TextField usernameField = new TextField();
				   usernameField.setPromptText("Username");

				   usernameField.setPrefWidth(200);
				   usernameField.setMaxWidth(300);

				   PasswordField passwordField = new PasswordField();
				   passwordField.setPromptText("Password");
				   passwordField.setPrefWidth(200);
				   passwordField.setMaxWidth(300);

				   Button loginButton = new Button("Login");
				   Button createButton = new Button("Create Account");

				   Label errorLabel = new Label();
				   errorLabel.setTextFill(Color.RED);
				   loginButton.setOnAction(event -> handleLogin(usernameField.getText(), passwordField.getText(), errorLabel));

				   root.getChildren().addAll(usernameField, passwordField, loginButton, errorLabel);
				   return root;
			    }

		     private void handleLogin(String username, String password, Label errorLabel) {
			    for (USer user : users) {
				   if (user.getLogin().equals(username) && user.getPassword().equals(password)) {
					  VBox userPanel = createUserPanel(user);
					  ScrollPane scrollPane = new ScrollPane(userPanel);
					  Scene userScene = new Scene(scrollPane, 400, 400);
					  userScene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
					  stage.setScene(userScene);
					  return;
				   }
			    }
			    errorLabel.setText("Invalid username or password.");
		     }


			    private VBox createUserInfoBox(USer user) {
				   VBox userInfoBox = user.createUserInterface(user);
				   userInfoBox.setAlignment(Pos.CENTER);
				   return userInfoBox;
			    }

			    private HBox createProductBox(USer user) {
				   ProductDisplay productDisplay = new ProductDisplay(user);
				   return productDisplay.getProductDisplay();
			    }

			    private VBox createUserPanel(USer user) {
				   VBox root = new VBox(20);
				   root.setPadding(new Insets(20));
				   root.setAlignment(Pos.CENTER_LEFT);

				   VBox userInfoBox = createUserInfoBox(user);
				   HBox productBox = createProductBox(user);

				   root.getChildren().addAll(userInfoBox, productBox);

				   return root;
		     }



		     public static void main(String[] args) {
			    launch(args);
		     }
	      }
