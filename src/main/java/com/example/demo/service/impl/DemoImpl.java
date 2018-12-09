package com.example.demo.service.impl;

import com.example.demo.component.AsyncTask;
import com.example.demo.service.IDemo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class DemoImpl implements IDemo {

    @Autowired
    AsyncTask asyncTask;

    @Test
    public void select() throws InterruptedException {
       for(int i=0; i<=100; i++){
           asyncTask.doTask1(i);
       }
    }

}
