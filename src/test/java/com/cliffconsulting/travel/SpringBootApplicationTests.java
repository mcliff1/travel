package com.cliffconsulting.travel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class SpringBootApplicationTests {

    @Autowired
    private Config config;

    //@Test
    //public void contextLoads() {}

    @Configuration
    static class Config {
    }

    //@Autowired
    //private TestRestTemplate restTemplate;

    @Test
    public void contextLoad() {}
}

