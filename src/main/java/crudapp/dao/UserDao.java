package crudapp.dao;

import crudapp.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    void delete(long id);

    void edit(User user);

    User getById(long id);

    List<User> allUsers();

    void cleanTable();
}
