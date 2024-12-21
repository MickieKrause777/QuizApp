package service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import entity.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.io.Serializable;

@Named
@ApplicationScoped
public class UserService implements Serializable{
    @PersistenceContext
    private EntityManager em;

    public void register(User user) {
        em.persist(user);
    }

    public boolean authenticate(String username, String password) {
        TypedQuery<User> query = em.createQuery(
            "SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class);
        query.setParameter("username", username);
        query.setParameter("password", password);

        return !query.getResultList().isEmpty();
    }
}
