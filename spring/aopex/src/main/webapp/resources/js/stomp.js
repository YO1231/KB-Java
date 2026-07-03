let roomSubscription = null;
let roomListSubscription = null;
let currentRoom = null;

const stompClient = new StompJs.Client({
    brokerURL: `ws://${window.location.host}${window.appContext}/chat-app`
});

stompClient.onWebSocketError = (error) => {
    console.error('WebSocket error', error);
};

stompClient.onStompError = (frame) => {
    console.error('Broker reported error: ' + frame.headers.message);
    console.error('Additional details: ' + frame.body);
};

stompClient.onConnect = () => {
    setConnected(true);
    roomListSubscription = stompClient.subscribe('/topic/rooms', (payload) => {
        renderRoomList(JSON.parse(payload.body));
    });
    loadRooms();
};

stompClient.onDisconnect = () => {
    cleanupCurrentRoom(false);
    setConnected(false);
};

function setConnected(connected) {
    document.getElementById('connect').disabled = connected;
    document.getElementById('disconnect').disabled = !connected;
    document.getElementById('create-room').disabled = !connected;
    refreshChatControls();

    if (!connected) {
        document.getElementById('room-list').innerHTML = '<div class="text-muted">연결 후 대화방 목록을 불러옵니다.</div>';
        document.getElementById('chat-messages').innerHTML = '';
        document.getElementById('current-room').textContent = '현재 입장한 대화방: 없음';
    }
}

function refreshChatControls() {
    const connected = stompClient.connected;
    const inRoom = Boolean(currentRoom);
    document.getElementById('content').disabled = !(connected && inRoom);
    document.getElementById('send').disabled = !(connected && inRoom);
    document.getElementById('leave-room').disabled = !(connected && inRoom);
}

function connect() {
    const sender = getSender();
    if (!sender) {
        alert('대화명을 입력하세요.');
        return;
    }

    if (!stompClient.active) {
        stompClient.activate();
    }
}

function disconnect() {
    if (currentRoom) {
        publishLeave();
    }
    if (roomSubscription) {
        roomSubscription.unsubscribe();
        roomSubscription = null;
    }
    if (roomListSubscription) {
        roomListSubscription.unsubscribe();
        roomListSubscription = null;
    }
    stompClient.deactivate();
}

function getSender() {
    return document.getElementById('name').value.trim();
}

function getContextPath() {
    return window.appContext || '';
}

async function loadRooms() {
    const response = await fetch(`${getContextPath()}/chat/rooms`);
    const rooms = await response.json();
    renderRoomList(rooms);
}

async function createRoom() {
    const roomNameInput = document.getElementById('room-name');
    const name = roomNameInput.value.trim();

    if (!name) {
        alert('대화방 이름을 입력하세요.');
        return;
    }

    const response = await fetch(`${getContextPath()}/chat/rooms`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({name})
    });

    if (!response.ok) {
        alert('대화방 개설에 실패했습니다.');
        return;
    }

    roomNameInput.value = '';
    const room = await response.json();
    joinRoom(room.id, room.name);
}

function renderRoomList(rooms) {
    const roomList = document.getElementById('room-list');
    if (!rooms || rooms.length === 0) {
        roomList.innerHTML = '<div class="text-muted">대화방이 없습니다.</div>';
        return;
    }

    roomList.innerHTML = '';
    rooms.forEach((room) => {
        const wrapper = document.createElement('div');
        wrapper.className = 'room-item';

        const title = document.createElement('span');
        title.textContent = room.name;

        const button = document.createElement('button');
        button.className = 'btn btn-xs btn-info join-room';
        button.textContent = '입장';
        button.addEventListener('click', () => joinRoom(room.id, room.name));

        wrapper.appendChild(title);
        wrapper.appendChild(button);
        roomList.appendChild(wrapper);
    });
}

function joinRoom(roomId, roomName) {
    if (!stompClient.connected) {
        alert('먼저 STOMP 연결을 시작하세요.');
        return;
    }

    if (currentRoom && currentRoom.id === roomId) {
        return;
    }

    if (currentRoom) {
        publishLeave();
        cleanupCurrentRoom(true);
    }

    roomSubscription = stompClient.subscribe(`/topic/chat/${roomId}`, (payload) => {
        showMessage(JSON.parse(payload.body));
    });

    currentRoom = {id: roomId, name: roomName};
    document.getElementById('chat-messages').innerHTML = '';
    document.getElementById('current-room').textContent = `현재 입장한 대화방: ${roomName}`;
    refreshChatControls();

    stompClient.publish({
        destination: '/app/chat.enter',
        body: JSON.stringify({
            roomId,
            sender: getSender()
        })
    });
}

function leaveRoom() {
    if (!currentRoom) {
        return;
    }
    publishLeave();
    cleanupCurrentRoom(true);
}

function publishLeave() {
    stompClient.publish({
        destination: '/app/chat.leave',
        body: JSON.stringify({
            roomId: currentRoom.id,
            sender: getSender()
        })
    });
}

function cleanupCurrentRoom(clearMessages) {
    if (roomSubscription) {
        roomSubscription.unsubscribe();
        roomSubscription = null;
    }
    currentRoom = null;
    if (clearMessages) {
        document.getElementById('chat-messages').innerHTML = '';
    }
    document.getElementById('current-room').textContent = '현재 입장한 대화방: 없음';
    refreshChatControls();
}

function sendMessage() {
    const contentInput = document.getElementById('content');
    const content = contentInput.value.trim();

    if (!currentRoom || !content) {
        return;
    }

    stompClient.publish({
        destination: '/app/chat.send',
        body: JSON.stringify({
            roomId: currentRoom.id,
            sender: getSender(),
            content
        })
    });

    contentInput.value = '';
}

function showMessage(message) {
    const chatMessages = document.getElementById('chat-messages');
    const entry = document.createElement('div');
    entry.className = `chat-entry ${message.type === 'SYSTEM' ? 'system' : 'chat'}`;
    entry.textContent = message.type === 'SYSTEM'
        ? message.content
        : `${message.sender}: ${message.content}`;
    chatMessages.appendChild(entry);
    chatMessages.scrollTop = chatMessages.scrollHeight;
}

function escapeHtml(value) {
    const text = value || '';
    return value
        ? text
        .replaceAll('&', '&amp;')
        .replaceAll('<', '&lt;')
        .replaceAll('>', '&gt;')
        .replaceAll('"', '&quot;')
        .replaceAll("'", '&#39;')
        : '';
}

window.addEventListener('DOMContentLoaded', () => {
    document.querySelectorAll('form').forEach((form) => {
        form.addEventListener('submit', (event) => event.preventDefault());
    });

    document.getElementById('connect').addEventListener('click', connect);
    document.getElementById('disconnect').addEventListener('click', disconnect);
    document.getElementById('create-room-form').addEventListener('submit', createRoom);
    document.getElementById('chat-form').addEventListener('submit', sendMessage);
    document.getElementById('leave-room').addEventListener('click', leaveRoom);

    setConnected(false);
});
