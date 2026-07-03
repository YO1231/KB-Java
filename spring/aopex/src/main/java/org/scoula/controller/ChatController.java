package org.scoula.controller;

import lombok.extern.log4j.Log4j2;
import org.scoula.domain.ChatMessage;
import org.scoula.domain.ChatRoom;
import org.scoula.service.ChatRoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Log4j2
public class ChatController {
    private final ChatRoomService chatRoomService;
    private final SimpMessagingTemplate messagingTemplate;

    public ChatController(ChatRoomService chatRoomService, SimpMessagingTemplate messagingTemplate) {
        this.chatRoomService = chatRoomService;
        this.messagingTemplate = messagingTemplate;
    }

    @GetMapping("/chat/rooms")
    @ResponseBody
    public List<ChatRoom> getRooms() {
        return chatRoomService.getRooms();
    }

    @PostMapping("/chat/rooms")
    @ResponseBody
    public ResponseEntity<ChatRoom> createRoom(@RequestBody ChatRoom roomRequest) {
        ChatRoom room = chatRoomService.createRoom(roomRequest.getName());
        messagingTemplate.convertAndSend("/topic/rooms", chatRoomService.getRooms());
        return ResponseEntity.status(HttpStatus.CREATED).body(room);
    }

    @MessageMapping("/chat.enter")
    public void enter(ChatMessage message) {
        validateRoom(message.getRoomId());
        log.info("enter room: {}", message);
        messagingTemplate.convertAndSend(roomTopic(message.getRoomId()),
                ChatMessage.system(message.getRoomId(), message.getSender() + "님이 입장했습니다."));
    }

    @MessageMapping("/chat.send")
    public void send(ChatMessage message) {
        validateRoom(message.getRoomId());
        message.setType("CHAT");
        log.info("chat message: {}", message);
        messagingTemplate.convertAndSend(roomTopic(message.getRoomId()), message);
    }

    @MessageMapping("/chat.leave")
    public void leave(ChatMessage message) {
        validateRoom(message.getRoomId());
        log.info("leave room: {}", message);
        messagingTemplate.convertAndSend(roomTopic(message.getRoomId()),
                ChatMessage.system(message.getRoomId(), message.getSender() + "님이 퇴장했습니다."));
    }

    private void validateRoom(String roomId) {
        if (!chatRoomService.exists(roomId)) {
            throw new IllegalArgumentException("존재하지 않는 채팅방입니다: " + roomId);
        }
    }

    private String roomTopic(String roomId) {
        return "/topic/chat/" + roomId;
    }
}
