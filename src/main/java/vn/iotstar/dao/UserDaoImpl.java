package vn.iotstar.dao;

import vn.iotstar.model.User;
import vn.iotstar.utils.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public void insert(User user) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    @Override
    public void update(User user) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    @Override
    public void delete(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            User u = em.find(User.class, id);
            if (u != null) em.remove(u);
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    @Override
    public User findById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try { return em.find(User.class, id); }
        finally { em.close(); }
    }

    @Override
    public User findByUsername(String username) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<User> q = em.createQuery("SELECT u FROM User u WHERE u.username=:u", User.class);
            q.setParameter("u", username);
            return q.getResultStream().findFirst().orElse(null);
        } finally { em.close(); }
    }

    @Override
    public List<User> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT u FROM User u", User.class).getResultList();
        } finally { em.close(); }
    }
}
