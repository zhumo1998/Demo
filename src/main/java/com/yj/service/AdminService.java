package com.yj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yj.entity.Admin;

import java.util.List;

/**
 * <p>
 * 管理员表; InnoDB free: 3072 kB 服务类
 * </p>
 *
 * @author zyp
 * @since 2020-06-11
 */
public interface AdminService extends IService<Admin> {
    List<Admin> selectAllByName(String username);
    void insert(Admin admin);
}
