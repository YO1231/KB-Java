package org.scoula.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage {
    private String roomId;
    private String sender;
    private String content;

    private String type;

    public static ChatMessage system(String roomId, String content) {
        return new ChatMessage(roomId, "SYSTEM", content, "SYSTEM");
    }
}
