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

    protected Comment() {
        super();
    }

    public Comment(String text) {
        this();
        this.text = text;
    }

    public Comment(String text, Article article) {
        this();
        this.text = text;
        this.article = article;
    }

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
}
