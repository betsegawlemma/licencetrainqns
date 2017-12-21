package com.betsegaw.entities;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @OneToMany(mappedBy = "category",cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Question> questions = new HashSet<>();

    /*public void addQuestion(Question question){
        question.setCategory(this);
        this.questions.add(question);
    }

    public void removeQuestion(Question question){
        question.setCategory(null);
        this.questions.remove(question);
    }*/

    public Category() {
    }

    public Category(String description) {
        this.description = description;
    }
}
