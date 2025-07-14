package onlineshop.service;

import onlineshop.model.User;

public interface UserService {
	      User saveUser(User user);

	      User updateUser(User user, Long userId);

	      void deleteUserId(Long userId);
       }

