package com.example.minishop.model.repository.Custom;

import com.example.minishop.model.domain.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserRepositoryCustom {

    Page<UserModel> findAllUser(Pageable pageable);

}
