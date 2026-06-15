<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 26. 6. 11.
  Time: 오후 3:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Filter 실습</title>

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body class="bg-light">

<div class="container">
    <div class="row justify-content-center align-items-center min-vh-100">
        <div class="col-md-6 col-lg-5">

            <div class="card shadow-sm border-0">
                <div class="card-body p-4">

                    <h2 class="text-center mb-3">Filter 실습</h2>
                    <p class="text-center text-muted mb-4">
                        UTF-8 인코딩 필터 테스트
                    </p>

                    <form action="${pageContext.request.contextPath}/message" method="post">
                        <div class="mb-3">
                            <label for="username" class="form-label">이름</label>
                            <input type="text"
                                   class="form-control"
                                   id="username"
                                   name="username"
                                   placeholder="이름을 입력하세요">
                        </div>

                        <div class="mb-3">
                            <label for="message" class="form-label">메시지</label>
                            <input type="text"
                                   class="form-control"
                                   id="message"
                                   name="message"
                                   placeholder="메시지를 입력하세요">
                        </div>

                        <div class="d-grid">
                            <button type="submit" class="btn btn-primary">
                                전송
                            </button>
                        </div>
                    </form>

                </div>
            </div>

            <p class="text-center text-muted mt-3 small">
                Servlet Filter를 이용한 공통 인코딩 처리 실습
            </p>

        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
