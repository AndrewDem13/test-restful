package com.demyanenko.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Article extends BaseEntity {
    @NotNull
    @Size(min = 2, max = 140)
    private String title;
    @NotNull
    @Size(min = 5)
    private String text;
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL) // deleting article with its comments
    private List<Comment> comments;
    @ManyToOne
    private User author;

    protected Article() {    }

    public Article(String title, String text, User author) {
        this.title = title;
        this.text = text;
        this.author = author;
        comments = new ArrayList<>();
    }

    public void addComment(Comment comment) {
        comment.setArticle(this);
        comments.add(comment);
    }

    /**  Getters & Setters  **/

    public List<Comment> getComments() {
        return comments;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public User getAuthor() {
        return author;
    }
}
