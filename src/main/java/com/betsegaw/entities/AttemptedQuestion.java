package com.betsegaw.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@ToString
@Entity
public class AttemptedQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date testDate;
    @OneToOne
    @JoinColumn(name = "question_id")
    private Question question;
    private Choice attemptedAnswer;

    @ManyToOne(cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
    private TestTaker testTaker;

    public AttemptedQuestion() {
    }

    public AttemptedQuestion(Date testDate, Question question, Choice attemptedAnswer, TestTaker testTaker) {
        this.testDate = testDate;
        this.question = question;
        this.attemptedAnswer = attemptedAnswer;
        this.testTaker = testTaker;
    }
}
