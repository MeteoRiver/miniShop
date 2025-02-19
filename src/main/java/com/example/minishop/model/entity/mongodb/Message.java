package com.example.minishop.model.entity.mongodb;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "messages")
public class Message {
    @Id
    private String id;

    private String chatId;
    private String senderId;
    private String message;

    private LocalDateTime createdAt = LocalDateTime.now();
}
