package com.cyov.marketplace.service.impl.product;

import com.cyov.marketplace.repository.product.ProductInventoryRepository;
import com.cyov.marketplace.service.product.IProductInventoryService;
import org.springframework.stereotype.Service;

@Service
public class ProductInventoryServiceImpl implements IProductInventoryService {
    // Implement service methods here
    private final ProductInventoryRepository productInventoryRepository;

    public ProductInventoryServiceImpl(ProductInventoryRepository productInventoryRepository) {
        this.productInventoryRepository = productInventoryRepository;
    }
}
