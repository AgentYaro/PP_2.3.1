package web.service;

import web.dao.UserDao;
import web.dao.UserDaoImp;
import web.model.User;

import java.util.List;

public class UserServiceImp implements UserService{
    UserDao userDao = new UserDaoImp();
    @Override
    public void saveUser(String name, String surname, String patronymic) {
        userDao.saveUser(name,surname,patronymic);
    }

    @Override
    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }
    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void cleanUsersTable() {
        userDao.cleanUsersTable();
    }

    @Override
    public User updateUserById(long id,String name, String surname, String patronymic) {
        return userDao.updateUserById(id,name,surname,patronymic);
    }
}
