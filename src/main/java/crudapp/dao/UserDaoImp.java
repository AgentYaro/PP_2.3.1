package crudapp.dao;

import crudapp.model.User;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Transactional

    @Override
    public void delete(long id) {
        entityManager.remove(getById(id));
    }

    @Transactional

    @Override
    public void edit(User user) {
        entityManager.merge(user);
    }

    @Transactional

    @Override
    public User getById(long id) {
        return entityManager.find(User.class,id);
    }

    @Transactional

    @Override
    public List<User> allUsers() {
        TypedQuery<User> query = entityManager.createQuery("select user from User user", User.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void cleanTable() {
        entityManager.createQuery("delete from User").executeUpdate();
    }
}
