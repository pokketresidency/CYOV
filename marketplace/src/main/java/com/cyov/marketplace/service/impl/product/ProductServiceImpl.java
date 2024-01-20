package com.cyov.marketplace.service.impl.product;

import com.cyov.marketplace.repository.product.ProductRepository;
import com.cyov.marketplace.service.product.IProductService;
import org.springframework.stereotype.Service;


@Service
public class ProductServiceImpl implements IProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
