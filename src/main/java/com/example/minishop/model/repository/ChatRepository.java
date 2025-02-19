package com.example.minishop.model.repository;

import com.example.minishop.model.entity.mongodb.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatRepository extends MongoRepository<Chat, String> {
    List<Chat> findByUsersContaining(String userId);
}
