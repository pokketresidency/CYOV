package com.cyov.marketplace.service.impl.product;

import com.cyov.marketplace.repository.product.ProductReviewRepository;
import com.cyov.marketplace.service.product.IProductReviewService;
import org.springframework.stereotype.Service;

@Service
public class ProductReviewServiceImpl implements IProductReviewService {
    // Implement service methods here
    private final ProductReviewRepository productReviewRepository;

    public ProductReviewServiceImpl(ProductReviewRepository productReviewRepository) {
        this.productReviewRepository = productReviewRepository;
    }
}
