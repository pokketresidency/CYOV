package com.cyov.marketplace.service.impl.product;

import com.cyov.marketplace.model.dto.ApiResponse;
import com.cyov.marketplace.model.dto.LoginResponseDTO;
import com.cyov.marketplace.model.dto.ProductResponseDTO;
import com.cyov.marketplace.model.dto.Response;
import com.cyov.marketplace.model.dto.product.*;
import com.cyov.marketplace.model.entity.product.*;
import com.cyov.marketplace.repository.product.ProductRepository;
import com.cyov.marketplace.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ApiResponse<ProductDTO> getByProductId(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);

        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            ProductDTO responseDTO = mapToProductDTO(product);
            return new ApiResponse<>(responseDTO, "Success", null, "Product found");
        }
            return new ApiResponse<>(null, "Error", "PRODUCT_NOT_FOUND", "Product not found");
    }

    private ProductDTO mapToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getProductId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setManufacturer(product.getManufacturer());
        productDTO.setWeight(product.getWeight());
        productDTO.setDimensions(product.getDimensions());
        productDTO.setCategory(mapToCategoryDTO(product.getCategory()));
        return productDTO;

    }

    private CategoryDTO mapToCategoryDTO(Category category) {
        if (category == null) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryId(category.getCategoryId());
        categoryDTO.setName(category.getName());
        categoryDTO.setParentCategory(mapToCategoryDTO(category.getParentCategory()));
        return categoryDTO;
    }
    private ProductOptionDTO mapToProductOptionDTO(ProductOption productOption) {
        ProductOptionDTO productOptionDTO = new ProductOptionDTO();
        productOptionDTO.setId(productOption.getId());
        productOptionDTO.setOptionType(productOption.getOptionType());
        productOptionDTO.setOptionValue(productOption.getOptionValue());
        return productOptionDTO;
    }
}
