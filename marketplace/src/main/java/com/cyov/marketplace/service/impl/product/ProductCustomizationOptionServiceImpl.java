package com.cyov.marketplace.service.impl.product;

import com.cyov.marketplace.repository.product.ProductCustomizationOptionRepository;
import com.cyov.marketplace.service.product.IProductCustomizationOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductCustomizationOptionServiceImpl implements IProductCustomizationOptionService {
    // Implement service methods here
    private final ProductCustomizationOptionRepository productCustomizationOptionRepository;

    @Autowired
    public ProductCustomizationOptionServiceImpl(ProductCustomizationOptionRepository productCustomizationOptionRepository){
        this.productCustomizationOptionRepository = productCustomizationOptionRepository;
    }
}
