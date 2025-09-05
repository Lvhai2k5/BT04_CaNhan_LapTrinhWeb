package vn.iotstar.service;

import vn.iotstar.model.Category;
import java.util.List;

public interface CategoryService {
    void insert(Category c);
    void update(Category c);
    void delete(int id);
    Category findById(int id);
    List<Category> findAll();
}
