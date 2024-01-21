package com.cyov.marketplace.service.impl.product;

import com.cyov.marketplace.repository.product.ProductImageRepository;
import com.cyov.marketplace.service.product.IProductImageService;
import org.springframework.stereotype.Service;

@Service
public class ProductImageServiceImpl implements IProductImageService {
    // Implement service methods here
    private final ProductImageRepository productImageRepository;

    public ProductImageServiceImpl(ProductImageRepository productImageRepository) {
        this.productImageRepository = productImageRepository;
    }
}
