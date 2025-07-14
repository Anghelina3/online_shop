package onlineshop.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carts")
@Data // Авто геттеры/сеттеры/toString/hashCode/equals
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;

       @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
       private List<CartItem> items = new ArrayList<>();

       @OneToOne(mappedBy = "cart")
       private User user;

       private String status;
       private double totalPrice;

}
