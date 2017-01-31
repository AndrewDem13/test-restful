package com.demyanenko;

import com.demyanenko.entities.Article;
import com.demyanenko.entities.Comment;
import com.demyanenko.repositories.ArticleRepository;
import com.demyanenko.repositories.UserRepository;
import com.demyanenko.users.User;
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
        List<User> usersTest = Arrays.asList(
                new User("Luke", "Skywalker", "masterJedi", "password", new String[]{"ROLE_USER"}),
                new User("Han", "Solo", "spaceGangster", "password", new String[]{"ROLE_USER"}),
                new User("Chewbacca", "Chewbacca", "UaarrrAarr", "password", new String[]{"ROLE_USER"})
        );
        users.save(usersTest);
        users.save(new User("Super", "User", "admin", "admin", new String[]{"ROLE_USER", "ROLE_ADMIN"}));

        IntStream.range(0, 10).forEach(i -> {
            Article article = new Article("Title"+i, "Here's text!");
            for (int q = 0; q < 5; q++) {
                Comment comment = new Comment("comment" + q, article);
                comment.setCommentator(usersTest.get(q % usersTest.size()));
                article.addComment(comment);
            }
            articles.save(article);
        });
    }
}
