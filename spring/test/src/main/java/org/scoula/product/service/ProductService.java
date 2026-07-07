package org.scoula.product.service;

import org.scoula.product.domain.ProductImageVO;
import org.scoula.product.dto.ProductDTO;
import org.scoula.product.dto.ProductFormDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getList();

    ProductDTO getProduct(Long no);

    void createProduct(ProductFormDTO dto);

    void deleteProduct(Long no);

    List<ProductDTO> search(String keyword);
}
