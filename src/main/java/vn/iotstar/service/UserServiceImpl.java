package vn.iotstar.service;

import vn.iotstar.dao.UserDao;
import vn.iotstar.dao.UserDaoImpl;
import vn.iotstar.model.User;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        User u = userDao.findByUsername(username);
        if (u != null && u.getPassword().equals(password)) return u;
        return null;
    }

    @Override
    public boolean register(User user) {
        if (userDao.findByUsername(user.getUsername()) != null) return false;
        userDao.insert(user);
        return true;
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
