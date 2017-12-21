package com.betsegaw.services;


import com.betsegaw.entities.TestTaker;

import java.util.Set;

public interface TestTakerService {
    public Set<TestTaker> getTestTakers();
    public TestTaker findById(Long testTakerId);
    public TestTaker findByFirstName(String firstName);
    public TestTaker saveTestTaker(TestTaker testTaker);
    public void deleteById(Long testTakerId);
}
