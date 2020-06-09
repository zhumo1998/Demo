package com.yj.demo;

import com.yj.Application;
import com.yj.dao.PersonMapper;
import com.yj.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = Application.class)
public class TestPerson {
    @Autowired
    private PersonMapper personMapper;
    @Test
    public void test1(){
        List<Person> people = personMapper.selectList(null);
        for (Person person : people) {
            System.out.println(person);
        }
    }
}
