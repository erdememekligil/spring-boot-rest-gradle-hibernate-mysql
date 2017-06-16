package com.erdem.samples.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bilginc_user on 15.06.2017.
 */
public class UserRepositoryDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryDao.class);

    private final UserRepository userRepository;

    @Autowired
    public UserRepositoryDao(UserRepository userRepository) {
        this.userRepository = userRepository;
        LOGGER.info("Dao created {}", System.identityHashCode(this));
    }

    public List<User> findAll(){
        Iterable<User> all = userRepository.findAll();

        List<User> users = new ArrayList<>();
        all.forEach(users::add);
        return users;
    }

    public User findOne(Integer id){
        return userRepository.findOne(id);
    }

    public boolean save(User user) {
        try{
            User saved = userRepository.save(user);
            LOGGER.info("Saved user: {}", saved);
        }
        catch (Exception e){
            return false;
        }
        return true;
    }
}
