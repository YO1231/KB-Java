<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<%@include file="../layouts/header.jsp"%>

<h1 class="page-header my-4">
    <i class="fa-solid fa-cart-plus" style="color: rgb(230, 99, 99);"></i>
    상품 등록
</h1>

<div >

    <!-- 의류, IT 기기, 가전, 가구 -->
<%--    문제 3 상품 등록 기능을 완성하시오.--%>
<%--    3-1) 상품 등록 폼을 출력하는 create.jsp를 완성하시오.--%>
    <form method="post">
        <div>
            <label>카테고리</label>
            <select name="category">
                <optgroup>
                    <option label="의류" />
                    <option label="가전" />
                    <option label="IT 기기" />
                    <option label="가구" />
                </optgroup>
            </select>
        </div>

        <div>
            <label>상품명</label>
            <input name="title" class="form-control">
        </div>

        <div>
            <label>가격</label>
            <input name="price" class="form-control">
        </div>

        <div>
            <label>설명</label>
            <textarea class="form-control" name="description" rows="5"></textarea>
        </div>

        <div class="my-4">
            <button type="submit" class="btn btn-primary"><i class="fas fa-check"></i> 확인</button>
            <button type="reset" class="btn btn-primary"><i class="fas fa-undo"></i> 취소</button>
            <a href="list" class="btn btn-primary"><i class="fas fa-list"></i> 목록</a>
        </div>
    </form>

</div>

<%@include file="../layouts/footer.jsp"%>
