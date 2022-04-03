package com.example.pernsonalDictionary.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Expression implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long expressionId;
    private String text;
    private String translation;

    @OneToMany
    @JoinColumn(name = "exampleId")
    private List<Example> exampleList;

    private Category category;

    public Expression(){};

    public Expression(Long expressionId, String text, String translation) {
        this.expressionId = expressionId;
        this.text = text;
        this.translation = translation;
    }

    public Long getExpressionId() {
        return expressionId;
    }

    public void setExpressionId(Long expressionId) {
        this.expressionId = expressionId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public List<Example> getExampleList() {
        return exampleList;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
