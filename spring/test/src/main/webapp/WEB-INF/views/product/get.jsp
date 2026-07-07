<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<%@include file="../layouts/header.jsp"%>


<%--문제 4 상품 상세 보기를 완성하시오.(계속)--%>
<%--4-4) 상품 상세 보기를 출력하는 jsp를 완성하시오.--%>
<h1 class="page-header my-4">
    <i class="fa-solid fa-cart-shopping" style="color: rgb(230, 99, 99);"></i>
<%--  페이지 제목 출력 --%>
    ${product.category} / ${product.title}
</h1>


<div class="d-flex justify-content-between">
    <div>
        <%--  가격 출력 --%>
        가격: ${product.price} 원
    </div>
    <div>
        <i class="fas fa-clock"></i> 등록일:
        <%--   등록일 출력 --%>
        <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${product.regDate}"/>
    </div>
</div>
<hr>

<div>
<%--    제품 설명 출력 --%>
    ${product.description}
</div>

<%--이미지 목록 출력--%>
<div>
    <c:forEach var="file" items="${product.images}">
        <tr>
            <td>
                ${productImage.no}
            </td>
        </tr>
    </c:forEach>
</div>

<div class="mt-4">
    <a href="list" class="btn btn-primary"><i class="fas fa-list"></i> 목록</a>
    <a href="#" class="btn btn-primary delete"><i class="fas fa-trash-alt"></i> 삭제</a>
</div>

<form action="delete" method="post" id="deleteForm">
    <input type="hidden" name="no" value="${product.no}"/>
</form>

<script src="/resources/js/product.js"></script>
