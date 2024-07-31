package org.proleesh.sendemail.service.impl;

import org.proleesh.sendemail.ioctest.User;
import org.proleesh.sendemail.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(Long id) {
        return null;
    }

    @Override
    public User insertUser(User user) {
        return null;
    }

    @Override
    public int deleteUser(Long id) {
        return 0;
    }

    @Override
    public List<User> findUsers(String userName, String note) {
        return List.of();
    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
