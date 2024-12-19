package com.example.demo.controller;

import com.example.demo.dto.UserRequest;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Получение пользователя по ID из строки запроса (Query Parameter).
     *
     * @param id ID пользователя
     * @return Пользователь, полученный из базы
     */
    @GetMapping
    public ResponseEntity<UserEntity> getUserByQueryParam(@RequestParam int id) {
        UserEntity user = userService.getUser(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody UserRequest userRequest) {
        userService.addUser(userRequest);
        return ResponseEntity.ok("User successfully added!");
    }
}
