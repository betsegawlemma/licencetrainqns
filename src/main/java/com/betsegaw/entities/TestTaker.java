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
public class TestTaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Address address;

    @OneToMany(mappedBy = "testTaker",fetch = FetchType.LAZY)
    private Set<AttemptedQuestion> attemptedQuestions = new HashSet<>();

   /* public void addAttemptedQuestion(AttemptedQuestion attemptedQuestion){
        attemptedQuestion.setTestTaker(this);
        this.attemptedQuestions.add(attemptedQuestion);
    }

    public void removeAttemptedQuestion(AttemptedQuestion attemptedQuestion){
        attemptedQuestion.setTestTaker(null);
        this.attemptedQuestions.remove(attemptedQuestion);
    }*/

    public TestTaker() {
    }

    public TestTaker(String firstName, String middleName, String lastName, Address address) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
    }

}
