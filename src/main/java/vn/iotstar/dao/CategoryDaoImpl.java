package vn.iotstar.dao;

import vn.iotstar.model.Category;
import vn.iotstar.utils.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    @Override
    public void insert(Category c) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    @Override
    public void update(Category c) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    @Override
    public void delete(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Category c = em.find(Category.class, id);
            if (c != null) em.remove(c);
            em.getTransaction().commit();
        } finally { em.close(); }
    }

    @Override
    public Category findById(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try { return em.find(Category.class, id); }
        finally { em.close(); }
    }

    @Override
    public List<Category> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("SELECT c FROM Category c", Category.class).getResultList();
        } finally { em.close(); }
    }
}
