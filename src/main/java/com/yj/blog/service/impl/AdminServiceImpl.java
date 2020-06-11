package com.yj.blog.service.impl;

import com.yj.blog.entity.Admin;
import com.yj.blog.mapper.AdminMapper;
import com.yj.blog.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
