package com.example.dao;

import com.example.models.UserC;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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

    @Override
    public UserC getUser(Long id) {
        return entityManager.find(UserC.class,id);
    }

    @Override
    public UserC checkCredentials(UserC user) {
        String query ="FROM UserC where email = :email";
        Argon2 arg2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        List <UserC> lista = entityManager.createQuery(query)
                .setParameter("email",user.getEmail())
                .getResultList();

        if (lista.isEmpty()){
            return null;
        }
        if (arg2.verify(lista.get(0).getPassword(),user.getPassword()))
        {
            return lista.get(0);
        }
        return null;
    }

}
