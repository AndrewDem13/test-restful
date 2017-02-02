package com.demyanenko.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(exported = false)  Commented this line for testing only
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

    /*
    This is not safe!
    Everyone has access to /users and can change it.
    Made it only for testing: to declare user from /users
    in the new Comment entity when creating.
    It could be made better and absolutely safe on the client side.
     */
}
