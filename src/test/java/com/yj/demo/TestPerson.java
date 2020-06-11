package com.yj.demo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yj.mapper.PersonMapper;
import com.yj.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
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
    @Test
    public void test2(){
        Person p = new Person();
        p.setName("赵耀鹏");
        p.setAge(22);
        p.setEmail("zyp@163.com");
        p.setTelephone("2313123");
        p.setSex(1);
       personMapper.insert(p);
    }
    @Test
    public void testUpdate(){
        Person p = new Person();
        p.setId(10L);
        p.setName("赵耀鹏");
        p.setAge(22);
        p.setEmail("zyp@163.com");
        p.setTelephone("2313123");
        p.setSex(1);
        personMapper.updateById(p);
    }
    //测试乐观锁成功
    @Test
    public void test3(){
       //查询用户信息
        Person person = personMapper.selectById(1L);
        //修改用户信息
        person.setEmail("123@qq.com");
        //执行更新操作
        personMapper.updateById(person);
    }
    //测试乐观锁失败 多线程情况下
    @Test
    public void test4(){
        //查询用户信息
        Person person = personMapper.selectById(2L);
        //修改用户信息
        person.setEmail("111@qq.com");
        //模拟多线程另外一个用户执行了 插队操作
        //查询用户信息
        Person person2 = personMapper.selectById(2L);
        //修改用户信息
        person2.setEmail("222@qq.com");

        //执行更新操作
        personMapper.updateById(person2);
        //执行更新操作
        personMapper.updateById(person);//如果没有乐观锁，会覆盖插队线程的值
    }
    @Test
    public void test5(){
        //根据id批量多个
        List<Person> people = personMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        people.forEach(System.out::println);
    }
    @Test
    public void test6(){
        //多条件查询之一 map
        Map<String,Object> map = new HashMap<>();
        //查询年龄为20的对象
        map.put("age",20);
        //查询姓名为zyp的对象;
        map.put("name","zyp");
        List<Person> people = personMapper.selectByMap(map);
        people.forEach(System.out::println);
    }
    @Test
    public void test7(){
        //分页查询
        //参数current:当前页
        //参数size:每页多少条
        Page<Person> page = new Page<>(1,5);
        personMapper.selectPage(page,null);
        //getRecords:获得查询结果
        page.getRecords().forEach(System.out::println);
    }
    @Test
    public void test8(){
        //根据id删除
        personMapper.deleteById(2L);
    }
    @Test
    public void test9(){
        //根据id批量删除
        personMapper.deleteBatchIds(Arrays.asList(7,8));
    }
    @Test
    public void test10(){
        //根据条件map删除
        Map<String,Object> map = new HashMap<>();
        map.put("name","赵耀鹏");
        personMapper.deleteByMap(map);
    }
}
