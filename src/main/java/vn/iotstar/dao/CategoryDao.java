package vn.iotstar.dao;

import vn.iotstar.model.Category;
import java.util.List;

public interface CategoryDao {
    void insert(Category c);
    void update(Category c);
    void delete(int id);
    Category findById(int id);
    List<Category> findAll();
}
