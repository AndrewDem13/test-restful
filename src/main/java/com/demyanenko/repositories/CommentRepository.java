package com.demyanenko.repositories;

import com.demyanenko.entities.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {

    /** POST / PUT / DELETE is only for authorized users **/

    /*
       POST is only for authorized as Admin or regular User
       PUT is is only for Admin and author of original comment
    */
    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or" +
            "(hasRole('ROLE_USER') and #entity.author?.username == authentication.name)")
    <S extends Comment> S save(@Param("entity") S entity);

    //   DELETE is only for Admin
    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(Long id);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(Comment comment);
}
