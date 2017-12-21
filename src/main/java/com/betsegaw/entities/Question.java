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
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String questionDescription;

    @ElementCollection
    private Set<Choice> choices = new HashSet<>();

    public void addChoice(Choice choice){
        this.choices.add(choice);
    }

    public void removeChoice(Choice choice){
        this.choices.remove(choice);
    }
    private Choice answer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @Lob
    private Byte[] questionImage;

    public Question() {
    }

    public Question(String questionDescription, Set<Choice> choices, Choice answer, Category category, Byte[] questionImage) {
        this.questionDescription = questionDescription;
        this.choices = choices;
        this.answer = answer;
        this.category = category;
        this.questionImage = questionImage;
    }
}
