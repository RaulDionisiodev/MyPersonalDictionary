package com.example.pernsonalDictionary.DTO;

import java.util.List;

public class ExpressionDTO {

    private String text;
    private String translation;
    private String category;

    public ExpressionDTO(){}

    public ExpressionDTO(String text, String translation, String category) {
        this.text = text;
        this.translation = translation;
        this.category = category;
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
}
