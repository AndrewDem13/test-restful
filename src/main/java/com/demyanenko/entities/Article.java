package com.demyanenko.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Article extends BaseEntity{
    @NotNull
    @Size(min = 2, max = 140)
    private String title;
    @NotNull
    @Size(min = 5)
    private String text;
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<Comment> comments;

    protected Article() {
        super();
        comments = new ArrayList<>();
    }

    public Article(String tittle, String text) {
        this();
        this.title = tittle;
        this.text = text;
    }

    public void addComment(Comment comment) {
        comment.setArticle(this);
        comments.add(comment);
    }

    public List<Comment> getComments() {
        return comments;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
