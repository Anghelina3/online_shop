package onlineshop.service;

import jakarta.transaction.Transactional;
import onlineshop.exceptions.UserNotFoundException;
import onlineshop.model.User;
import onlineshop.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

       private final UserRepository userRepository;

       public UserServiceImpl(UserRepository userRepository) {
	      this.userRepository = userRepository;
       }


       @Transactional
       @Override
       public User saveUser(User user) {
	      return userRepository.save(user);
       }
       @Transactional
       @Override
       public User updateUser(User user, Long userId) {
	     User existingUser = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
	     if(user.getName()!=null){
		    existingUser.setName(user.getName());
	     }
	      if(user.getAmount()!=null){
		     existingUser.setAmount(user.getAmount());
	      }
	      if(user.getLogin()!=null){
		     existingUser.setLogin(user.getLogin());
	      }
	      if(user.getPassword()!=null){
		     existingUser.setPassword(user.getPassword());
	      }

	      if(user.getImage()!=null){
		     existingUser.setImage(user.getImage());
	      }

	      return userRepository.save(existingUser);

       }
       @Transactional
       @Override
       public void deleteUserId(Long userId) {
	      User userToDelete = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
	      userRepository.delete(userToDelete);
       }
}
