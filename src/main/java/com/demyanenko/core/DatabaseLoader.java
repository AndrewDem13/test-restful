package com.demyanenko.core;

import com.demyanenko.article.Article;
import com.demyanenko.comment.Comment;
import com.demyanenko.article.ArticleRepository;
import com.demyanenko.user.UserRepository;
import com.demyanenko.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class DatabaseLoader  implements ApplicationRunner{
    private final ArticleRepository articles;
    private final UserRepository users;

    @Autowired
    public DatabaseLoader(ArticleRepository articles, UserRepository users) {
        this.articles = articles;
        this.users = users;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        users.save(new User("Super", "User", "admin", "admin", new String[]{"ROLE_ADMIN"}));
        users.save(new User("Regular", "User", "user", "user", new String[]{"ROLE_USER"}));

        // This one is emulating unauthorized user for testing
        users.save(new User("Anonymous", "User", "anon", "anon", new String[]{"ROLE_ANONYMOUS"}));


        //  Previous testing for REST API without Security: fills DB with 10 articles with 5 comments for each
        /*
        IntStream.range(0, 10).forEach(i -> {
            Article article = new Article("Title"+i, "Here's text!");
            for (int q = 0; q < 5; q++) {
                Comment comment = new Comment("comment" + q, article);
                article.addComment(comment);
            }
            articles.save(article);
        });
        */
    }
}

