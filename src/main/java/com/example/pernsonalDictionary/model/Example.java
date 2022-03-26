package com.example.pernsonalDictionary.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Example implements Serializable {

    private static final long serialVersionUID = 1L;

    public Example(Long exampleId, Expression expression, String text) {
        this.exampleId = exampleId;
        this.expression = expression;
        this.text = text;
    }

    public Example(){}

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long exampleId;

    @ManyToOne
    @JoinColumn(name = "expressionId")
    private Expression expression;
    private String text;
}
