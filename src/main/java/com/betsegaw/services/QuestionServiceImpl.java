package com.betsegaw.services;


import com.betsegaw.entities.Question;
import com.betsegaw.exception.NotFoundException;
import com.betsegaw.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService{

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Set<Question> getQuestions() {
        Set<Question> questions = new HashSet<>();
        questionRepository.findAll().iterator().forEachRemaining(questions::add);
        return questions;
    }

    @Override
    public Question findById(Long questionId) {
        Optional<Question> questionOptional = questionRepository.findById(questionId);
        if(!questionOptional.isPresent()){
            throw new NotFoundException("Question Not Found. For ID value: "+questionId.toString());
        }
        return questionOptional.get();
    }

    @Override
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public void deleteById(Long id) {
        questionRepository.deleteById(id);
    }
}
