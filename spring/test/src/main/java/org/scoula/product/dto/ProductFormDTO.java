package org.scoula.product.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.scoula.product.domain.ProductVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@NoArgsConstructor
@Data
public class ProductFormDTO {
    Long no;
    String category;
    String title;
    String description;
    Long price;

    List<MultipartFile> files;

    public ProductVO toVO() {
        return ProductVO.builder()
                .no(no)
                .category(category)
                .title(title)
                .description(description)
                .price(price)
                .build();
    }
}
