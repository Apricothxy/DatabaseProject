package com.wxy.databaseproject.controller;

import com.wxy.databaseproject.model.User;
import com.wxy.databaseproject.repository.UserRepository;
import com.wxy.databaseproject.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        boolean success = userService.register(username, password);
        return success ? "Register Success" : "Register Fail, Username exists or illegal";
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String,Object>> login(@RequestParam String username, @RequestParam String password) {
        boolean success = userService.login(username, password);
        Map<String, Object> response = new HashMap<>();
        if (success) {
            User user = userRepository.findByUsername(username);
            response.put("status", "success");
            response.put("userId", user.getId());
            return ResponseEntity.ok(response);
        } else {
            response.put("status", "fail");
            response.put("message", "Username or password incorrect");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    @GetMapping("/user/{userId}")
    public User getUserInfo(@PathVariable Integer userId) {
        User user = userService.getUserById(userId);
        return user;
    }

}
