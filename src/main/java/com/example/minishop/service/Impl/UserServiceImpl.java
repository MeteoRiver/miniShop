package com.example.minishop.service.Impl;

import com.example.minishop.model.domain.UserModel;
import com.example.minishop.model.entity.mysql.User;
import com.example.minishop.model.repository.UserRepository;
import com.example.minishop.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
//        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    //사용자 등록
    @Override
    public UserModel insert(UserModel userModel) {
        //이메일 중복체크
        if(userRepository.existsByEmail(userModel.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "중복된 이메일입니다.");
        }
        //핸드폰 중복체크
        if(userRepository.existsByPhone(userModel.getPhone())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "중복된 번호입니다.");
        }
//        String encodedPassword = bCryptPasswordEncoder.encode(userModel.getPassword());
        User saveUser = userRepository.save(User.builder()
                        .name(userModel.getName())
                        .email(userModel.getEmail())
                        .role(userModel.getRole())
                        .password(userModel.getPassword())
                        .phone(userModel.getPhone())
                        .createdAt(userModel.getCreatedAt())
                        .updatedAt(userModel.getUpdatedAt())
                        .build());
        return UserModel.fromEntity(saveUser);
    }

    //사용자 수정(관리자)
    @Override
    public Object update(Long id, UserModel userModel) {
        User updateUser = userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setName(userModel.getName());
                    existingUser.setEmail(userModel.getEmail());
                    existingUser.setPhone(userModel.getPhone());
                    existingUser.setRole(userModel.getRole());
                    existingUser.setPassword(userModel.getPassword());
                    existingUser.setUpdatedAt(userModel.getUpdatedAt());
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "사용자가 존재하지않음"));
        return UserModel.fromEntity(updateUser);
    }

    //비밀번호 변경
    @Override
    public Object updatePassword(Long id, UserModel userModel) {
        User updateUser = userRepository.findById(id)
                .map(existingUser -> {
                    existingUser.setPassword(userModel.getPassword());
                    existingUser.setUpdatedAt(userModel.getUpdatedAt());
                    return userRepository.save(existingUser);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "사용자가 존재하지않음"));
        return UserModel.fromEntity(updateUser);
    }

    //사용자 삭제
    @Override
    public boolean remove(Long id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    //사용자 조회
    @Override
    public Page<UserModel> findAll(Pageable pageable) {
        return userRepository.findAllUser(pageable);
    }

    //사용자 조회(id)
    @Override
    public UserModel findUserById(Long id, Pageable pageable) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "사용자가 존재하지않음"));
        return UserModel.fromEntity(user);
    }

}
