package com.betsegaw.services;


import com.betsegaw.entities.TestTaker;
import com.betsegaw.exception.NotFoundException;
import com.betsegaw.repositories.TestTakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class TestTakerServiceImpl implements TestTakerService{

    private final TestTakerRepository testTakerRepository;

    @Autowired
    public TestTakerServiceImpl(TestTakerRepository testTakerRepository) {
        this.testTakerRepository = testTakerRepository;
    }

    @Override
    public Set<TestTaker> getTestTakers() {
        Set<TestTaker> testTakers = new HashSet<>();
        testTakerRepository.findAll().iterator().forEachRemaining(testTakers::add);
        return testTakers;
    }

    @Override
    public TestTaker findById(Long testTakerId) {
        Optional<TestTaker> testTakerOptional= testTakerRepository.findById(testTakerId);
        if(!testTakerOptional.isPresent()){
            throw new NotFoundException("TastTaker Not Found. For ID value: "+testTakerId.toString());
        }
        return testTakerOptional.get();
    }

    @Override
    public TestTaker findByFirstName(String firstName) {
        Optional<TestTaker> testTakerOptional = testTakerRepository.findByFirstName(firstName);
        if(!testTakerOptional.isPresent()){
            throw new NotFoundException("Test Taker Not Found. For First Name value: "+firstName);
        }
        return testTakerOptional.get();
    }

    @Override
    public TestTaker saveTestTaker(TestTaker testTaker) {
        return testTakerRepository.save(testTaker);
    }

    @Override
    public void deleteById(Long testTakerId) {
         testTakerRepository.deleteById(testTakerId);
    }
}
