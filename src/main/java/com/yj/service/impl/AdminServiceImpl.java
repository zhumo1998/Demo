package com.yj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yj.entity.Admin;
import com.yj.mapper.AdminMapper;
import com.yj.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 管理员表; InnoDB free: 3072 kB 服务实现类
 * </p>
 *
 * @author zyp
 * @since 2020-06-11
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public List<Admin> selectAllByName(String username) {
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.like("username",username);
        return adminMapper.selectList(wrapper);
    }

    @Override
    public void insert(Admin admin) {
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        adminMapper.insert(admin);
    }

}
