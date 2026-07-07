package org.scoula.product.mapper;

import org.scoula.product.domain.ProductVO;
import org.scoula.product.domain.ProductImageVO;

import java.util.List;

public interface ProductMapper {
    List<ProductVO> getList();

    List<ProductVO> search(String keyword);

    ProductVO getProduct(Long no);

    void insertProduct(ProductVO productVO);

    void deleteProduct(Long no);

    List<ProductImageVO> getImages(Long bno);
}
