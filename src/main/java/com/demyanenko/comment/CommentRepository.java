package com.demyanenko.comment;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.access.prepost.PreAuthorize;

public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {

    /** POST / PUT / DELETE is only for authorized users **/

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(Long id);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(Comment comment);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    <S extends Comment> S save(S entity);
}
