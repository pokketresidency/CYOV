package com.cyov.marketplace.service.product;

import com.cyov.marketplace.model.dto.ApiResponse;
import com.cyov.marketplace.model.dto.ProductResponseDTO;
import com.cyov.marketplace.model.dto.Response;
import com.cyov.marketplace.model.dto.product.ProductDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public interface IProductService {
    ApiResponse<ProductDTO> getByProductId(Long productId);
}
