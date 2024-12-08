package com.wxy.databaseproject.service;

import com.wxy.databaseproject.model.User;
import com.wxy.databaseproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean register(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            return false;
        }
        if (userRepository.findByUsername(username) != null) {
            return false;
        }
        User user = new User();
        user.setUsername(username);
        user.setMembership("bronze");
        user.setPassword(password); // TODO: hash password
        int rows = userRepository.save(user);
        return rows > 0;
    }

    public boolean login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) return false;
        return user.getPassword().equals(password);
    }
    // Reset user password
    public boolean resetPassword(Integer userid, String oldPassword, String newPassword) {
        User user = userRepository.findByUserID(userid);
        if (user == null) return false;
        if (!user.getPassword().equals(oldPassword)) return false;
        int isSuccess = userRepository.resetPasswordByUserID(userid,newPassword);
        return isSuccess != 0;
    }
    //Reset user name
    public boolean resetUsername(Integer userid, String newUsername) {
        User user = userRepository.findByUserID(userid);
        if (user == null) return false;
        int isSuccess = userRepository.resetUserNameByUserID(userid,newUsername);
        return isSuccess != 0;
    }
    public User getUserById(Integer id) {
        return userRepository.findByUserID(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAllUsers();
    }
}
