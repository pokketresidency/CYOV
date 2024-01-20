package com.cyov.marketplace.repository.product;

import com.cyov.marketplace.model.entity.product.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductVariantRepository extends JpaRepository<ProductVariant, Long> {
}
