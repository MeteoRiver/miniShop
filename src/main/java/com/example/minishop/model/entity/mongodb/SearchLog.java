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
@Document(collection = "search_logs")
public class SearchLog {
    @Id
    private String id;

    private String userId;
    private String keyword;

    private LocalDateTime searchedAt = LocalDateTime.now();
}
