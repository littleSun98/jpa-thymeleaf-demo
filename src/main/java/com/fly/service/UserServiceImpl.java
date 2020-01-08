package com.fly.service;

import com.fly.dao.UserDao;
import com.fly.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public void add(User user) {
        userDao.save(user);
    }

    @Override
    public void update(Long id, User user) {
        user.setId(id);
        userDao.saveAndFlush(user);
    }

    @Override
    public void delete(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findOne(Long id) {
        return userDao.findById(id).get();
    }
}
