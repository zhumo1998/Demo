package com.yj.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yj.entity.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonMapper extends BaseMapper<Person> {
}
