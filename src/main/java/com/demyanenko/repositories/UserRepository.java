package com.demyanenko.repositories;

import com.demyanenko.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/* This line below is commented so Admin get full and direct access to UserRepository ("/users")
* @RepositoryRestResource(exported = false)
*/
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
