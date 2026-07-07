package org.scoula.product.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductImageVO {
    Long no;
    Long productNo;
    String fileName;
    String uploadName;
    Long size;
    String contentType;
    private Date regDate;
}
