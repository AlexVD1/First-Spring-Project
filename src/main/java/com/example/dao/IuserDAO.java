package com.example.dao;

import com.example.models.UserC;

import java.util.List;

public interface IuserDAO {
    List<UserC> listUsers();

    void userDelete(Long id);

    void userRegister(UserC user);

    void userUpdate(UserC user);

    UserC getUser(Long id);

    UserC checkCredentials(UserC user);
/*    UserC getUser();
    UserC updateUser();
    UserC deleteUser();
*/
}
