package com.example.dao;

import com.example.models.UserC;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Repository
@Transactional
public class userDAOImpl implements IuserDAO{
    @PersistenceContext
    private EntityManager entityManager ;

    @Override
    public List<UserC> listUsers() {
        String query ="FROM UserC";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void userDelete(Long id) {
        UserC user =entityManager.find(UserC.class,id);
        entityManager.remove(user);
    }

    @Override
    public void userRegister(@RequestBody UserC user) {
        entityManager.merge(user);
    }

    @Override
    public void userUpdate(UserC user) {

    }

}
