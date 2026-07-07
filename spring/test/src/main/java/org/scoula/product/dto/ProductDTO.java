package org.scoula.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.product.domain.ProductVO;
import org.scoula.product.domain.ProductImageVO;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductDTO {
    Long no;
    String category;
    String title;
    String description;
    Long price;

    List<ProductImageVO> images;

    private Date regDate;
    private Date updateDate;

    public static ProductDTO of(ProductVO productVO) {
        return productVO == null ? null : ProductDTO.builder()
                .no(productVO.getNo())
                .category(productVO.getCategory())
                .title(productVO.getTitle())
                .description(productVO.getDescription())
                .price(productVO.getPrice())
                .images(productVO.getImages())
                .regDate(productVO.getRegDate())
                .updateDate(productVO.getUpdateDate())
                .build();
    }


}
