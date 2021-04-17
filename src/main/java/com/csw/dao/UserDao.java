package com.csw.dao;

import com.csw.entity.User;

public interface UserDao {

    User query(String username, String password);

    void addUsers(User uu);

    void changePassword(String newPass1, String username);

    void updateBy(User uu);

}
