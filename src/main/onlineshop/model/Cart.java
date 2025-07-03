package onlineshop.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data // Авто геттеры/сеттеры/toString/hashCode/equals
@NoArgsConstructor
@AllArgsConstructor

public class Cart {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;

       @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
       @JoinColumn(name = "item_id")
       private List<CartItem> items = new ArrayList<>();

       @OneToOne
       @JoinColumn(name = "user_id")
       private User user;

       private String status;
       private double totalPrice;

}
