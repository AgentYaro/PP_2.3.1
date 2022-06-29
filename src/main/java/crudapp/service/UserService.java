package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void saveUser(String name, String surname, String patronymic);

    void removeUserById(long id);

    List<User> getAllUsers();
    public User getUserById(long id);

    void cleanUsersTable();

    User updateUserById(long id, String name, String surname, String patronymic);
}
