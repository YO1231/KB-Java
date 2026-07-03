package org.scoula.service;

import org.scoula.domain.ChatRoom;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ChatRoomService {
    private final Map<String, ChatRoom> rooms = new ConcurrentHashMap<>();

    public ChatRoom createRoom(String name) {
        String trimmedName = name == null ? "" : name.trim();
        if (trimmedName.isEmpty()) {
            throw new IllegalArgumentException("채팅방 이름은 비어 있을 수 없습니다.");
        }

        ChatRoom room = new ChatRoom(UUID.randomUUID().toString(), trimmedName);
        rooms.put(room.getId(), room);
        return room;
    }

    public List<ChatRoom> getRooms() {
        List<ChatRoom> result = new ArrayList<>(rooms.values());
        result.sort(Comparator.comparing(ChatRoom::getName, String.CASE_INSENSITIVE_ORDER));
        return result;
    }

    public boolean exists(String roomId) {
        return rooms.containsKey(roomId);
    }
}
