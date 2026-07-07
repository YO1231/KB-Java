package org.scoula.product.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.product.domain.ProductVO;
import org.scoula.product.domain.ProductImageVO;
import org.scoula.product.dto.ProductDTO;
import org.scoula.product.dto.ProductFormDTO;
import org.scoula.product.exception.ProductNotFoundException;
import org.scoula.product.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class ProductServiceImpl implements ProductService {
    final ProductMapper mapper;

    @Override
    public List<ProductDTO> getList() {
        return mapper.getList().stream()
                .map(ProductDTO::of)
                .toList();

    }


    //    문제 3 상품 등록 기능을 완성하시오.
    //    3-3) ProductServiceImpl에서 수행하는 상품 등록 기능(트랜잭션 처리 포함)을 완성하시오.
    //    발급받은 Primary Key 값을 DEBUG 로그 레벨로 "등록 상품 NO: XX" 문자열로 출력하시오.
    @Override
    public void createProduct(ProductFormDTO dto) {
        log.debug("등록 상품 NO: " + dto.getNo());

        ProductVO vo = dto.toVO();
        mapper.insertProduct(vo);
        dto.setNo(vo.getNo());
    }

    // 문제 4 상품 상세 보기를 완성하시오.
    // 4-2) 상품 상세를 위한 ProductServiceImpl의 getProduct() 메서드를 완성하시오.
    @Override
    public ProductDTO getProduct(Long no) {
        ProductDTO product = ProductDTO.of(mapper.getProduct(no));
        return Optional.ofNullable(product)
                .orElseThrow(NoSuchElementException::new);
    }

    @Transactional
    @Override
    public void deleteProduct(Long no) {
        mapper.deleteProduct(no);
    }


    //  문제 7 상품 검색 API를 완성하시오.
    //  7-2) 상품 검색을 위한 ProductServiceImpl의 search 메서드를 완성하시오.
    @Override
    public List<ProductDTO> search(String keyword) {
        return mapper.search(keyword).stream()
                .map(ProductDTO::of)
                .toList();
    }
}
