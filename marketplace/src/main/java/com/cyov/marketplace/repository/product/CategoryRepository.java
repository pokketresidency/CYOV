package com.cyov.marketplace.repository.product;

import com.cyov.marketplace.model.entity.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
