package com.example.minishop.service;

import com.example.minishop.model.domain.UserModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    //사용자 등록
    UserModel insert(UserModel userModel);

    //사용자 수정(관리자)
    Object update(Long id, UserModel userModel);

    //비밀번호 변경
    Object updatePassword(Long id, UserModel userModel);

    //사용자 삭제
    boolean remove(Long id);

    //사용자 조회(전체)
    Page<UserModel> findAll(Pageable pageable);

    //사용자 조회(id)
    UserModel findUserById(Long id, Pageable pageable);

}
