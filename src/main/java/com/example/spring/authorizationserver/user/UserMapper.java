package com.example.spring.authorizationserver.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
@Service

public class UserMapper implements RowMapper<User> {
    @Autowired
    private  PasswordEncoder passwordEncoder;
    public UserMapper(PasswordEncoder passwordEncoder ) {
        this.passwordEncoder=passwordEncoder;
    }

    @Override
        public User mapRow(ResultSet rs, int i) throws SQLException {
            User user = new User();
            user.setIdentifier( rs.getInt("customer_id"));
            user.setUsername(rs.getString("fname").trim());
            user.setPassword(passwordEncoder.encode(rs.getString("lname").trim()));
            return  user;
        }
    }

