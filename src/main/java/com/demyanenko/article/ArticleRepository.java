package com.demyanenko.article;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;

public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {
    @RestResource(rel = "title-contains", path = "containsTitle")
    Page<Article> findByTitleContains(@Param("title") String title, Pageable page);


    /** POST / PUT / DELETE is only for authorized users **/

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(Long id);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void delete(Article article);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    <S extends Article> S save(S entity);
}
