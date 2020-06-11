package com.yj.controller;


import com.yj.entity.Admin;
import com.yj.service.AdminService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 管理员表; InnoDB free: 3072 kB 前端控制器
 * </p>
 *
 * @author zyp
 * @since 2020-06-11
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @ApiOperation("根据姓名模糊查找")
    @PostMapping(value = "selectAllByName")
    public List<Admin> selectAllByName(@ApiParam("管理员姓名") String username){
        return adminService.selectAllByName(username);
    }

    @ApiOperation("添加管理员")
    @PutMapping(value = "insert")
    public Admin insert(@ApiParam("管理员实体") Admin admin){
        adminService.insert(admin);
        return admin;
    }
}

