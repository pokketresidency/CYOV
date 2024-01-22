package com.cyov.marketplace.repository.product;

import com.cyov.marketplace.model.dto.Response;
import com.cyov.marketplace.model.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByProductId(Long id);
}
