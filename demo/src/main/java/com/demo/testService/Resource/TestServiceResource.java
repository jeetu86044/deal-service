package com.demo.testService.Resource;

import com.demo.testService.entity.Test;
import com.demo.testService.impl.TestServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("test")
public class TestServiceResource {

    private final TestServiceImp testServiceImp;

    public TestServiceResource(TestServiceImp testServiceImp) {
        this.testServiceImp = testServiceImp;
    }

    @GetMapping(path = "/{rollNumber}")
    public Test getTest(@PathVariable String rollNumber){
        return testServiceImp.getTest(rollNumber);
    }

    @PostMapping()
    public Test createUser(@RequestBody Test test){
        return testServiceImp.createTest(test);
    }

}
