package com.fly.service;

import com.fly.po.User;

import java.util.List;

public interface UserService {
    //新增用户
    public void add(User user);

    //修改用户
    public void update(Long id,User user);

    //删除
    public void delete(Long id);

    //查询全部
    public List<User> findAll();

    //根据id获取用户信息
    public User findOne(Long id);
}
