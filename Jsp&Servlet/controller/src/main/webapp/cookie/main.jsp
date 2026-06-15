<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 26. 6. 12.
  Time: 오후 2:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String loginId = (String) request.getAttribute("loginId");
  Boolean popupOpen = (Boolean) request.getAttribute("popupOpen");

  if (loginId == null) {
    response.sendRedirect(request.getContextPath() + "/loginPage");
    return;
  }

  if (popupOpen == null) {
    popupOpen = false;
  }
%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>Cookie Main</title>

  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
        rel="stylesheet">


  <script>
    window.onload = function () {
      let popupOpen = <%= popupOpen.booleanValue() %>;

      if (popupOpen) {
        window.open(
                "<%= request.getContextPath() %>/cookie/popup.jsp",
                "popup",
                "width=450,height=500,left=300,top=150"
        );
      }
    };
  </script>
</head>

<body class="bg-light">

<nav class="navbar navbar-dark bg-dark">
  <div class="container">
    <span class="navbar-brand">Cookie Servlet 실습</span>
    <span class="text-white">
            <%= loginId %>님 환영합니다.
        </span>
  </div>
</nav>

<div class="container mt-5">
  <div class="card shadow">
    <div class="card-body p-4">
      <h3>메인 페이지</h3>

      <p class="mt-3">
        로그인 성공 후 들어오는 페이지입니다.
      </p>

      <p>
        아이디 저장 쿠키는 <strong>LoginServlet</strong>에서 생성/삭제합니다.
      </p>

      <p>
        팝업 쿠키 확인은 <strong>MainServlet</strong>에서 처리합니다.
      </p>

      <p>
        JavaScript는 쿠키를 조회하지 않고,
        Servlet이 전달한 값에 따라 팝업창만 엽니다.
      </p>

      <a href="<%= request.getContextPath() %>/loginPage"
         class="btn btn-secondary">
        로그인 페이지로 이동
      </a>
    </div>
  </div>
</div>

</body>
</html>
