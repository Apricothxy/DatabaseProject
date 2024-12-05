package com.wxy.databaseproject.repository;

import com.wxy.databaseproject.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<User> userRowMapper = (rs, rowNum) -> {
        User user = new User();
        user.setId(rs.getInt("user_id"));
        user.setPassword(rs.getString("password"));
        user.setUsername(rs.getString("user_name"));
        return user;
    };

    public int save(User user) {
        String sql = "INSERT INTO users (password, user_name) VALUES (?, ?)";
        return jdbcTemplate.update(sql,
                user.getPassword(),
                user.getUsername());
    }


    public User findByUsername(String userName) {
        String sql = "SELECT user_id, password, user_name FROM users WHERE user_name = ?";
        return jdbcTemplate.query(sql, new Object[]{userName}, userRowMapper)
                .stream()
                .findFirst()
                .orElse(null);
    }
}
