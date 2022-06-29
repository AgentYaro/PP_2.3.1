package crudapp.service;

import crudapp.dao.UserDao;
import crudapp.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }



    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

    @Override
    public void edit(User user) {
        userDao.edit(user);
    }

    @Override
    public User getById(long id) {
        return userDao.getById(id);
    }

    @Override
    public List<User> allUsers() {
        return userDao.allUsers();
    }

    @Override
    public void cleanTable() {
        userDao.cleanTable();
    }
}