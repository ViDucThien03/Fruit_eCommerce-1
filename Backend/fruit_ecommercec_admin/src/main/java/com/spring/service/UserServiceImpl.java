package com.spring.service;

import com.spring.dao.UserDao;
import com.spring.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public List<Users> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public int countUsers() {
        return userDao.countUsers();
    }

    @Override
    public List<Users> paginationUsers(int index) {
        return userDao.paginationUsers(index);
    }

    @Override
    public Users getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<Users> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void addUser(Users user) {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(Users user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
}
