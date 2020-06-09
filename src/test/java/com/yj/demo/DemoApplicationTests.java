package com.yj.demo;

import com.yj.Application;
import com.yj.dao.AdminDAO;
import com.yj.entity.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = Application.class)
class DemoApplicationTests {
    @Autowired
    private AdminDAO adminDAO;
    @Test
    void test1() {
        Admin admin = adminDAO.selectOne(1);
        System.out.println(admin);
    }
    @Test
    void test2() {
        List<Admin> admins = adminDAO.selectAll();
        for (Admin admin : admins) {
            System.out.println(admin);
        }
    }
}
