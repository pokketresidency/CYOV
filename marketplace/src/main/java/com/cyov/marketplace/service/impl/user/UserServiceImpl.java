package com.cyov.marketplace.service.impl.user;

import com.cyov.marketplace.model.entity.user.User;
import com.cyov.marketplace.repository.user.UserRepository;
import com.cyov.marketplace.service.user.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    // Implement service methods here
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long userId) {
        // Implement the logic to retrieve a user by ID from the repository
        return userRepository.findById(userId).orElse(null);
    }
}