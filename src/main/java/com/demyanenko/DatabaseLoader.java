package com.demyanenko;

import com.demyanenko.entities.Article;
import com.demyanenko.entities.Comment;
import com.demyanenko.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class DatabaseLoader  implements ApplicationRunner{
    private final ArticleRepository articles;

    @Autowired
    public DatabaseLoader(ArticleRepository articles) {
        this.articles = articles;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        IntStream.range(0, 10).forEach(i -> {
            Article article = new Article("Title"+i, "Here's text!");
            for (int q = 0; q < 5; q++)
                article.addComment(new Comment("comment"+q, article));
            articles.save(article);
        });

    }
}
