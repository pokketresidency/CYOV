package com.cyov.marketplace.repository.product;

import com.cyov.marketplace.model.entity.product.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {
}
