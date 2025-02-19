package com.example.minishop.model.repository;

import com.example.minishop.model.entity.mysql.Order;
import com.example.minishop.model.entity.mysql.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}
