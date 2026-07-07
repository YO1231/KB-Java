<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<%@include file="../layouts/header.jsp"%>

<h1 class="page-header my-4"><i class="fas fa-list"></i> 상품 목록</h1>

<table class="table table-hover">
    <thead>
    <tr>
        <th style="width: 60px">No</th>
        <th> 카테고리</th>
        <th>상품명</th>
        <th style="width: 200px">등록일</th>
    </tr>
    </thead>
    <tbody>

<%--    문제 2 상품 목록 보기 기능을 구현하시오.--%>
<%--    2-2) 상품 목록 보기 list.jsp 파일을 완성하시오.--%>
        <c:forEach var="product" items="${list}">
            <tr>
                <td>${product.no}</td>
                <td>${product.category}</td>
                <td>
                    <a href="get?no=${product.no}">${product.title}</a>
                </td>
                <td>
                    <fmt:formatDate pattern="yyyy-MM-dd" value="${product.regDate}"/>
                </td>
            </tr>
        </c:forEach>
    </tbody>

</table>

<div class="text-right">
    <a href="create" class="btn btn-primary">
        <i class="far fa-edit"></i>
        상품 등록
    </a>
</div>

<%@include file="../layouts/footer.jsp"%>
