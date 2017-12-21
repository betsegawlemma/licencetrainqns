package com.betsegaw.services;


import com.betsegaw.entities.Question;

import java.util.Set;

public interface QuestionService {
    public Set<Question> getQuestions();
    public Question findById(Long questionId);
    public Question saveQuestion(Question question);
    public void deleteById(Long id);
}
