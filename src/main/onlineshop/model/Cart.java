package onlineshop.model;

import jakarta.persistence.*;
import lombok.*;

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

       @ManyToMany
       @JoinColumn(name = "product_id")
       private List<Product> products;

       @OneToOne
       @JoinColumn(name = "user_id")
       private User user;

}
