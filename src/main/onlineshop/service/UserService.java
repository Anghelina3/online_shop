package onlineshop.service;

import onlineshop.model.User;
import org.springframework.stereotype.Service;

public interface UserService {
	      User saveUser(User user);

	      User updateUser(User user, Long userId);

	      void deleteUserId(Long userId);
       }

