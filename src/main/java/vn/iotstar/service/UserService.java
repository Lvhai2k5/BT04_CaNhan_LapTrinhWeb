package vn.iotstar.service;

import vn.iotstar.model.User;

public interface UserService
{
    User login(String username, String password);
    boolean register(User user);
    User findByUsername(String username);
}
