package com.gemini.service;




import com.gemini.entity.User;

import java.util.List;

public interface UserService {

    Integer addUser(User user);

    List<User> list();

    void deleteAll();
}
