package org.proleesh.sendemail.service;

import org.proleesh.sendemail.ioctest.User;

import java.util.List;

public interface UserService {
    User getUser(Long id);
    User insertUser(User user);
    int deleteUser(Long id);
    List<User> findUsers(String userName, String note);
    User updateUser(User user);
}
