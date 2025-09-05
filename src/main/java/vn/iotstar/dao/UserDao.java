package vn.iotstar.dao;

import vn.iotstar.model.User;
import java.util.List;

public interface UserDao {
    void insert(User user);
    void update(User user);
    void delete(int id);
    User findById(int id);
    User findByUsername(String username);
    List<User> findAll();
}
