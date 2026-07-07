<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="./layouts/header.jsp" %>

<%-- 개별 페이지 --%>
<h1>구현 목록</h1>

<div>
  <a href="/product/list">
    <button style="background: blue; color: white; font-size: 20px;">상품 관리 페이지로 이동</button> <br></a>
  <br>

  <hr >

  <a href="api/product">
    <button style="background: blue; color: white; font-size: 20px;">상품 목록(rest)</button> <br></a>
  <br>
  <a href="api/product/4">
    <button style="background: blue; color: white; font-size: 20px;">상품번호 번호4번 상세 검색(rest)</button> <br>
  </a>
  <br>
  <a href="api/product/search/여름">
    <button style="background: blue; color: white; font-size: 20px;">키워드(여름) 검색(rest)</button> <br>
  </a>
</div>

<%@ include file="./layouts/footer.jsp" %>
