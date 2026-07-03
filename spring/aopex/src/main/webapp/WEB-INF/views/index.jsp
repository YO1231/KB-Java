<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>STOMP Chat Room</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@stomp/stompjs@7.0.0/bundles/stomp.umd.min.js"></script>
    <style>
        body {
            padding-top: 20px;
        }

        .panel-body.room-list {
            max-height: 280px;
            overflow-y: auto;
        }

        .room-item {
            display: flex;
            justify-content: space-between;
            align-items: center;
            gap: 10px;
            margin-bottom: 10px;
        }

        .room-item:last-child {
            margin-bottom: 0;
        }

        .chat-log {
            height: 320px;
            overflow-y: auto;
            border: 1px solid #ddd;
            border-radius: 4px;
            padding: 12px;
            background: #fafafa;
        }

        .chat-entry {
            margin-bottom: 10px;
        }

        .chat-entry.system {
            color: #777;
        }

        .current-room {
            margin-bottom: 15px;
            font-weight: bold;
        }
    </style>
</head>
<body>
<script>
    window.appContext = '${pageContext.request.contextPath}';
</script>
<script src="${pageContext.request.contextPath}/resources/js/stomp.js"></script>
<div id="main-content" class="container">
    <h2>STOMP 채팅방</h2>
    <div class="row">
        <div class="col-md-12">
            <form class="form-inline">
                <div class="form-group">
                    <label for="name">이름: </label>
                    <input type="text" id="name" class="form-control" placeholder="대화명을 입력하세요.">
                </div>
                <button id="connect" class="btn btn-primary" type="submit">연결</button>
                <button id="disconnect" class="btn btn-default" type="submit" disabled="disabled">연결 종료</button>
            </form>
        </div>
    </div>

    <hr>

    <div class="row">
        <div class="col-md-4">
            <div class="panel panel-default">
                <div class="panel-heading">대화방 관리</div>
                <div class="panel-body">
                    <form id="create-room-form">
                        <div class="form-group">
                            <label for="room-name">새 대화방 이름</label>
                            <input type="text" id="room-name" class="form-control" placeholder="예: 스프링 스터디">
                        </div>
                        <button id="create-room" class="btn btn-success" type="submit" disabled="disabled">대화방 개설</button>
                    </form>
                </div>
                <div class="panel-body room-list">
                    <div id="room-list" class="text-muted">대화방이 없습니다.</div>
                </div>
            </div>
        </div>

        <div class="col-md-8">
            <div class="panel panel-default">
                <div class="panel-heading">대화방 채팅</div>
                <div class="panel-body">
                    <div id="current-room" class="current-room">현재 입장한 대화방: 없음</div>
                    <div id="chat-messages" class="chat-log"></div>
                </div>
                <div class="panel-body">
                    <form id="chat-form" class="form-inline">
                        <div class="form-group" style="width: 70%;">
                            <label class="sr-only" for="content">메시지</label>
                            <input type="text" id="content" class="form-control" style="width: 100%;" placeholder="메시지를 입력하세요..." disabled="disabled">
                        </div>
                        <button id="send" class="btn btn-primary" type="submit" disabled="disabled">전송</button>
                        <button id="leave-room" class="btn btn-warning" type="button" disabled="disabled">방 나가기</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
