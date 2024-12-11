       package usersAPP;
       import javafx.scene.image.Image;

       import java.sql.Connection;
       import java.sql.PreparedStatement;
       import java.sql.ResultSet;
       import java.sql.SQLException;
       import java.util.*;

       public class ProductCatalog {
	    private List<Product> products ;
            private conToDataBase conToDataBase ;


	      public ProductCatalog() {
		     this.products = new ArrayList<>();  // Инициализация списка продуктов
		     defaultList();  // Добавляем стандартные продукты
	      }



	      public void defaultList () {
		     conToDataBase = new conToDataBase();
		     String query = "SELECT * FROM products";
		     try (Connection connection = conToDataBase.getConnection()) {
			    PreparedStatement prep = connection.prepareStatement(query);
			    ResultSet rs = prep.executeQuery();
			    while (rs.next()) {
				   String name = rs.getString("product_name");
				   String image = rs.getString("product_image");
				   int price = rs.getInt("price");

				   products.add(new Product(name, price, new Image(image)));

			    }

		     } catch (SQLException e) {
			    throw new RuntimeException(e);
		     }

	      }


	    public List<Product> getProducts() {
		   if (products == null) {
			  products = new ArrayList<>();  // Инициализация списка продуктов, если он еще не инициализирован
		   }
		   return products;
	    }
       }
