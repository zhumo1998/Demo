package com.yj.dao;

import com.yj.entity.Admin;

import java.util.List;

public interface AdminDAO {

    Admin selectOne(Integer id);
    List<Admin> selectAll();
}
