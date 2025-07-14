package onlineshop.controller;

import onlineshop.model.User;
import onlineshop.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/user")
public class UserController {


       UserRepository userRepository;

       public UserController(UserRepository userRepository) {
	      this.userRepository = userRepository;
       }

       @GetMapping(value = "/{id}")
       public User getUser(@PathVariable("id") Long userId){
	      Optional<User> user = userRepository.findById(userId);
	      return user.orElse(null);
       }



       @PostMapping
       public User createUser(@RequestBody User user) {
           return userRepository.save(user);
       }


}
