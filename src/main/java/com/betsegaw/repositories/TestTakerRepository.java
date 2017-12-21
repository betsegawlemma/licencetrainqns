package com.betsegaw.repositories;

import com.betsegaw.entities.TestTaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TestTakerRepository extends JpaRepository<TestTaker,Long>{
    Optional<TestTaker> findByFirstName(String firstName);
}
