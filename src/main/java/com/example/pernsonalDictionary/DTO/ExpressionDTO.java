package com.example.pernsonalDictionary.DTO;

import java.util.List;

public class ExpressionDTO {

    private String text;
    private String translation;
    private String category;
    private Long id;

    private List<String> exampleList;

    public ExpressionDTO(){}

    public ExpressionDTO(String text, String translation, String category, Long id) {
        this.text = text;
        this.translation = translation;
        this.category = category;
        this.id = id;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getExampleList() {
        return exampleList;
    }

    public void setExampleList(List<String> exampleList) {
        this.exampleList = exampleList;
    }
}
