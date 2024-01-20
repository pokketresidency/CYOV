package com.cyov.marketplace.repository.product;

import com.cyov.marketplace.model.entity.product.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
}
