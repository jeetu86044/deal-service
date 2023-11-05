package com.demo.testService.impl;

import com.demo.testService.entity.Test;
import com.demo.testService.respository.TestRepository;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImp {

    private final TestRepository testRepository;

    public TestServiceImp(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public Test getTest(String rollNumber){
        return testRepository.findById(1L).get();
    }

    public Test createTest(Test test){
        return testRepository.save(test);
    }
}
