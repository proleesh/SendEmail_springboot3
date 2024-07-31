package org.proleesh.sendemail.dao;

import org.proleesh.sendemail.valid.User;

import java.util.List;

public interface UserDao {
    User getUser(Long id);

    int insertUser(User user);

    int deleteUser(Long id);

    List<User> findUsers(String userName, String note);

    int updateUser(User user);
}
