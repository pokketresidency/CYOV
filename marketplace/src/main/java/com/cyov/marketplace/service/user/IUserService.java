package com.cyov.marketplace.service.user;

import com.cyov.marketplace.model.entity.user.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    // Define service methods here
    User getUserById(Long userId);
}
