package com.demyanenko.repositories;


import com.demyanenko.entities.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {
    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or commentRepository.findOne(#id)?.commentator?.username = authentication.name")
    void delete(@Param("id") Long aLong);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN') or #comment.commentator?.username == authentication.name")
    void delete(@Param("comment") Comment entity);
}
