package com.csw.service;

import com.csw.entity.User;

public interface UserService {

    User queryBy(String username, String password);

    void addUsers(User uu);

    void changePassword(String newPass1, String username);

    void updateBy(User uu);

}
