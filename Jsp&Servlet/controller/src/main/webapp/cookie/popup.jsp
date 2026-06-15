<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 26. 6. 12.
  Time: 오후 2:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Popup</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body class="bg-light">

<div class="container p-4">

    <div class="card shadow">
        <div class="card-header bg-primary text-white">
            공지사항
        </div>

        <div class="card-body">

            <h5 class="card-title">Servlet Cookie 팝업 실습</h5>

            <p class="card-text">
                이 팝업은 메인 페이지 접속 시 나타나는 공지 팝업입니다.
            </p>

            <p class="card-text">
                아래 체크박스를 선택하고 닫기 버튼을 누르면
                Servlet에서 쿠키를 생성하여 오늘 하루 동안 이 팝업창이 다시 열리지 않습니다.
            </p>

            <div class="alert alert-info">
                공지사항 또는 이벤트 내용을 이곳에 작성합니다.
            </div>

            <form action="<%= request.getContextPath() %>/closePopup" method="post">

                <div class="form-check mt-3">
                    <input class="form-check-input"
                           type="checkbox"
                           id="dontShowToday"
                           name="dontShowToday"
                           value="on">

                    <label class="form-check-label" for="dontShowToday">
                        오늘 하루 이 창을 띄우지 않음
                    </label>
                </div>

                <button type="submit"
                        class="btn btn-dark w-100 mt-3">
                    닫기
                </button>

            </form>

        </div>
    </div>

</div>

</body>
</html>
