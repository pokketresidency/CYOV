package com.cyov.marketplace.controller;

import com.cyov.marketplace.model.dto.ApiResponse;
import com.cyov.marketplace.model.dto.ProductResponseDTO;
import com.cyov.marketplace.model.dto.Response;
import com.cyov.marketplace.model.dto.product.ProductDTO;
import com.cyov.marketplace.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.cyov.marketplace.constants.AppConstants.MARKETPLACE_BASE_URL;

@RestController
@RequestMapping(MARKETPLACE_BASE_URL)
public class ProductController {

    private IProductService productService;

    @Autowired
    public ProductController(@Qualifier("productServiceImpl") IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/fetch-product/{productId}")
    public ResponseEntity<Object> fetchProduct(
            @PathVariable Long productId
    ){
        ApiResponse<ProductDTO> response = productService.getByProductId(productId);
        return ResponseEntity.ok(response);
    }
}
