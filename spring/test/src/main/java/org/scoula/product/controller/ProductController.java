package org.scoula.product.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.product.domain.ProductImageVO;
import org.scoula.product.dto.ProductDTO;
import org.scoula.product.dto.ProductFormDTO;
import org.scoula.product.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Controller
@Log4j2
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    final ProductService service;

    // 문제 2 상품 목록 보기 기능을 구현하시오.
    // 2-1) ProductController의 list() 메서드를 정의하시오.
    @GetMapping("/list")
    public void list(Model model) {
        log.info("list");
        model.addAttribute("list", service.getList());
    }

    @GetMapping("/create")
    public void create() {

    }

    // 문제 3 상품 등록 기능을 완성하시오.
    //  3-4) 상품 등록 처리 후 목록 보기 페이지로 리다이렉트 하도록 ProductController의 메서드를 완성하시오.
    @PostMapping("/create")
    public String postCreate(ProductFormDTO product) {
        log.info("create: " + product);

        service.createProduct(product);
        return "redirect:/product/list";
    }

    // 문제 4 상품 상세 보기를 완성하시오.
    // 4-3 상품 상세 보기 요청을 처리하는 ProductController의 get() 메서드를 완성하시오.
    @GetMapping("/get")
    public void get(@RequestParam("no") Long no, Model model) {
        model.addAttribute("product", service.getProduct(no));
    }

    //  문제 5 상품 삭제 기능을 완성하시오.
    //  5-2) 상품 삭제를 위한 ProductController의 delete 메서드를 완성하시오.
    public String delete(@RequestParam("no") Long no) {

        service.deleteProduct(no);
        return "redirect:/product/list";
    }


}
