package com.example.minishop.controller;


import com.example.minishop.model.domain.UserModel;
import com.example.minishop.service.Impl.UserServiceImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    //사용자 등록
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody UserModel userModel) {
        return ResponseEntity.ok(userService.insert(userModel));
    }


    //사용자 수정(관리자)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UserModel userModel) {
        return ResponseEntity.ok(userService.update(id, userModel));
    }

    //비밀번호 변경
    @PutMapping("/password/{id}")
    public ResponseEntity<?> updatePassword(@PathVariable Long id, @RequestBody UserModel userModel) {
        return ResponseEntity.ok(userService.update(id, userModel));
    }

    //사용자 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.ok(userService.remove(id));
    }

    //사용자 조회(전체)
    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(userService.findAll(PageRequest.of(page,size)));
    }

    //사용자 조회(id)
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size,
                                      @PathVariable Long id){
        return ResponseEntity.ok(userService.findUserById(id, PageRequest.of(page,size)));
    }
}
