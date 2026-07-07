package org.scoula.product.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.scoula.product.dto.ProductDTO;
import org.scoula.product.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


//문제 6 상품 목록 API 기능을 완성하시오.
//6-1) RestAPI 요청을 처리하는 ProductApiController의 클래스 레벨 어노테이션을 완성하시오.
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@Slf4j
public class ProductApiController {
    private final ProductService service;

    // 6-2) 상품 목록 요청 처리 메서드를 완성하시오.
    @GetMapping("")
    public ResponseEntity<List<ProductDTO>> getList() {
        return ResponseEntity.ok(service.getList());
    }


    // 문제 7 상품 검색 API를 완성하시오.
    // 7-3) ProductApiController에서 상품 검색 요청 처리 메서드를 완성하시오.
    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<ProductDTO>> search(@PathVariable String keyword) {
        return ResponseEntity.ok(service.search(keyword));
    }


   // 문제 8 ProductApiController 에서 상품 1개를 추출하는 getProduct 메서드를 완성하시오.
    @GetMapping("/{no}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long no) {
        return ResponseEntity.ok(service.getProduct(no));
    }
}
