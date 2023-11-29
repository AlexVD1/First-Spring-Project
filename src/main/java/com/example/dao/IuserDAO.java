package com.example.dao;

import com.example.models.UserC;
import org.apache.catalina.User;

import java.util.List;

public interface IuserDAO {
    List<UserC> listUsers();

    void userDelete(Long id);

    void userRegister(UserC user);

    void userUpdate(UserC user);

    UserC getUser(Long id);

    boolean checkCredentials(UserC user);
/*    UserC getUser();
    UserC updateUser();
    UserC deleteUser();
*/
}
