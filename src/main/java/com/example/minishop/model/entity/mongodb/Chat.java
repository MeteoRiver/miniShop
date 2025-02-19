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
@Document(collection = "chats")
public class Chat {
    @Id
    private String id;

    private List<String> users;

    private LocalDateTime createdAt = LocalDateTime.now();
}
