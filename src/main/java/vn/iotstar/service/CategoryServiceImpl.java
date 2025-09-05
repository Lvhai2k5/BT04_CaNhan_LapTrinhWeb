package vn.iotstar.service;

import vn.iotstar.dao.CategoryDao;
import vn.iotstar.dao.CategoryDaoImpl;
import vn.iotstar.model.Category;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao dao = new CategoryDaoImpl();

    @Override public void insert(Category c) { dao.insert(c); }
    @Override public void update(Category c) { dao.update(c); }
    @Override public void delete(int id) { dao.delete(id); }
    @Override public Category findById(int id) { return dao.findById(id); }
    @Override public List<Category> findAll() { return dao.findAll(); }
}
