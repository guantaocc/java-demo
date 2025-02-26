package com.itranswarp.learnjava.service;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.itranswarp.learnjava.entity.User;
import com.itranswarp.learnjava.mapper.UserMapper;

@Component
@Transactional
public class UserService {
    @Autowired
    UserMapper userMapper;
    
    public void createUser(String username, String password, String email, String createBy, String updateBy) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setCreateBy(createBy);
        user.setUpdateBy(updateBy);
        user.setCreateTime(LocalDateTime.now());
        userMapper.insert(user);
    }

    public List<User> getUserByName(String username) {
        return userMapper.getByUsername(username);
    }

    public User getUserById(long id) {
        return userMapper.getById(id);
    }

    public void updateUser(long id, String newUserName) {
        User user = userMapper.getById(id);
        user.setUsername(newUserName);
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    public void deleteUser(long id) {
        userMapper.deleteById(id);
    }
}
