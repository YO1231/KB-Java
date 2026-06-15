<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 26. 6. 12.
  Time: 오후 3:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../common/header.jsp" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

<div class="container mt-4">
  <h2>게시판 목록</h2>

  <form action="search.do" method="get" class="mb-3 d-flex gap-2">
    <input type="text" name="keyword" placeholder="검색어 입력" class="form-control w-25">
    <button type="submit" class="btn btn-secondary">검색</button>
  </form>

  <a class="btn btn-primary mb-3" href="writeForm.do">글쓰기</a>
  <table class="table table-bordered">
    <thead><tr><th>ID</th><th>제목</th><th>작성자</th><th>날짜</th></tr></thead>
    <tbody>
    <c:forEach var="row" items="${list}">
      <tr>
        <td>${row.id}</td>
        <td><a href="view.do?id=${row.id}">${row.title}</a></td>
        <td>${row.writer}</td>
        <td>${row.regdate}</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>

<%@ include file="../common/footer.jsp" %>
