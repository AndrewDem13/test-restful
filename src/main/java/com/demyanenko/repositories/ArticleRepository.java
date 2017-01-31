package com.demyanenko.repositories;

import com.demyanenko.entities.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {

    @RestResource(rel = "title-contains", path = "containsTitle")
    Page<Article> findByTitleContains(@Param("title") String title, Pageable page);
}
