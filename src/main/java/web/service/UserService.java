package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    void add(User user);
    void edit(User user);
    void delete(User user);
    User getUserById(Long id);
}
