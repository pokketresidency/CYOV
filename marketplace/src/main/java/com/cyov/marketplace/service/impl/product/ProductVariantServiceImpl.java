package com.cyov.marketplace.service.impl.product;

import com.cyov.marketplace.repository.product.ProductVariantRepository;
import com.cyov.marketplace.service.product.IProductVariantService;
import org.springframework.stereotype.Service;

@Service
public class ProductVariantServiceImpl implements IProductVariantService {
    // Implement service methods here
    private final ProductVariantRepository productVariantRepository;

    public ProductVariantServiceImpl(ProductVariantRepository productVariantRepository) {
        this.productVariantRepository = productVariantRepository;
    }
}
