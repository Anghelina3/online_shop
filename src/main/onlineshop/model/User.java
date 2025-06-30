package onlineshop.model;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name="users")
@Data // Авто геттеры/сеттеры/toString/hashCode/equals
@NoArgsConstructor
@AllArgsConstructor

public class User {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;

       private String name;
       private double amount;
       private String image;

       @Column(unique = true, nullable = false)
       private String login;

       @Column(nullable = false)
       private String password;

       @OneToOne(cascade = CascadeType.ALL)
       @JoinColumn(name = "basket_id")
       private Cart cart;

       @Transient
       private boolean isLoogedIn = false; //не должно сохранять в бд
}