package com.demyanenko.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Comment extends BaseEntity {
    @NotNull
    @Size(min = 2)
    private String text;
    @ManyToOne
    private Article article;
    @ManyToOne
    private User author;

    protected Comment() {    }

    public Comment(String text, Article article, User user) {
        this.text = text;
        this.article = article;
        this.author = user;
    }

    /**  Getters & Setters  **/

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
