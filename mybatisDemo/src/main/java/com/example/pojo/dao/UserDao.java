package com.example.pojo.dao;

import com.example.pojo.User;

import java.util.List;

public interface UserDao {

    public List<User> findAll();

    public User findByCondition(User user);

}
