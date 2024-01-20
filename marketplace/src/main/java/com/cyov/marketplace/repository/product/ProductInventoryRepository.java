package com.cyov.marketplace.repository.product;

import com.cyov.marketplace.model.entity.product.ProductInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductInventoryRepository extends JpaRepository<ProductInventory, Long> {
}
