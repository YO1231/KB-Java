package org.scoula.product.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductVO {
    Long no;
    String category;
    String title;
    String description;
    Long price;
    List<ProductImageVO> images;

    private Date regDate;
    private Date updateDate;
}
