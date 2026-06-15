<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 26. 6. 12.
  Time: 오후 1:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String savedId = (String) request.getAttribute("savedId");

    if (savedId == null) {
        savedId = "";
    }
%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Cookie Login</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body class="bg-light">

<div class="container">
    <div class="row justify-content-center align-items-center" style="min-height:100vh;">
        <div class="col-md-5 col-lg-4">

            <div class="card shadow">
                <div class="card-body p-4">

                    <h3 class="text-center mb-4">Login</h3>

                    <form action="<%= request.getContextPath() %>/login" method="post">

                        <div class="mb-3">
                            <label for="userId" class="form-label">아이디</label>
                            <input type="text"
                                   class="form-control"
                                   id="userId"
                                   name="userId"
                                   value="<%= savedId %>"
                                   placeholder="아이디를 입력하세요"
                                   required>
                        </div>

                        <div class="mb-3">
                            <label for="userPw" class="form-label">비밀번호</label>
                            <input type="password"
                                   class="form-control"
                                   id="userPw"
                                   name="userPw"
                                   placeholder="비밀번호를 입력하세요"
                                   required>
                        </div>

                        <div class="form-check mb-3">
                            <input class="form-check-input"
                                   type="checkbox"
                                   id="rememberId"
                                   name="rememberId"
                                   value="on"
                                <%= "".equals(savedId) ? "" : "checked" %>>

                            <label class="form-check-label" for="rememberId">
                                아이디 저장
                            </label>
                        </div>

                        <button type="submit" class="btn btn-primary w-100">
                            로그인
                        </button>

                    </form>

                    <div class="mt-3 text-center">
                        <small class="text-muted">
                            테스트 계정: admin / 1234
                        </small>
                    </div>

                </div>
            </div>

        </div>
    </div>
</div>

</body>
</html>
