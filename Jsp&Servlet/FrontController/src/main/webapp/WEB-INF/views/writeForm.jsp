<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 26. 6. 12.
  Time: 오후 3:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../common/header.jsp" %>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

<div class="container mt-4">
    <h2>글쓰기</h2>
    <form action="write.do" method="post">
        <div class="mb-3">
            <label>제목</label>
            <input type="text" name="title" class="form-control">
        </div>
        <div class="mb-3">
            <label>내용</label>
            <textarea name="content" class="form-control" rows="5"></textarea>
        </div>
        <div class="mb-3">
            <label>작성자</label>
            <input type="text" name="writer" class="form-control">
        </div>
        <button type="submit" class="btn btn-success">등록</button>
    </form>
</div>

<%@ include file="../common/footer.jsp" %>
