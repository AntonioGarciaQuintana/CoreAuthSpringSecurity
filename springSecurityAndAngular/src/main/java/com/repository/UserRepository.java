package com.repository;

import com.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by fagarcia on 04/10/2018.
 */
@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    @Query("SELECT u FROM User u where u.username = :username")
    User getByUserByUserName(@Param("username") String userName);
}
