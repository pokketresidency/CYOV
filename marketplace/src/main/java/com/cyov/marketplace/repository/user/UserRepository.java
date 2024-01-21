package com.cyov.marketplace.repository.user;

import com.cyov.marketplace.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
