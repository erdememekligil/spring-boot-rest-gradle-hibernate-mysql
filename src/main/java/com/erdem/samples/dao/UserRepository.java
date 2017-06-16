package com.erdem.samples.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by bilginc_user on 15.06.2017.
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    public List<User> findBySurname(String surname);
}
