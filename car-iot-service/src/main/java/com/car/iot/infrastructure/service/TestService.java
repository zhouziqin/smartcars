package com.car.iot.infrastructure.service;

import com.domain.model.Test;
import com.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    TestMapper testMapper;
    public void test(){
        Test t = new Test();
         t.setName("test");
        testMapper.insert(t);
    }
}
