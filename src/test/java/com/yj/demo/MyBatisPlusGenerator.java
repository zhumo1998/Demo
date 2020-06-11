package com.yj.demo;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.Properties;

public class MyBatisPlusGenerator {
    public static void main(String[] args) {
        //构建一个代码生成器对象
        AutoGenerator mpg = new AutoGenerator();
        //配置策略
        //1.全局配置
        GlobalConfig gc = new GlobalConfig();
        //获取当前项目路径
        String projectPath = System.getProperty("user.dir");
        //设置要输出的目录位置
        gc.setOutputDir(projectPath+"/src/main/java");
        //设置作者
        gc.setAuthor("zyp");
        //是否打开文件管理器
        gc.setOpen(false);
        //是否覆盖原来生成的
        gc.setFileOverride(false);
        //去Service的I前缀
        gc.setServiceName("%sService");
        //设置主键生成策略
        gc.setIdType(IdType.AUTO);
        //设置时间类型
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        //2.设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/zyp?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");
        //设置数据库驱动
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        //3.配置包
        PackageConfig config = new PackageConfig();
        //设置模块名
        config.setModuleName("blog");
        //设置放置在哪个包下
        config.setParent("com.yj");
        //设置实体类包名
        config.setEntity("entity");
        //设置mapper包名
        config.setMapper("mapper");
        //设置Service包名
        config.setService("service");
        //设置Controller包名
        config.setController("controller");
        mpg.setPackageInfo(config);
        //4.策略配置
        StrategyConfig strategy = new StrategyConfig();
        //需要映射的表名
        strategy.setInclude("admin");
        //将表名转换成驼峰命名法
        strategy.setNaming(NamingStrategy.underline_to_camel);
        //将列名转换成驼峰命名法
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //是否使用lombok开启注解
        strategy.setEntityLombokModel(true);
        //设置逻辑删除字段
        strategy.setLogicDeleteFieldName("deleted");
        //设置自动填充配置
        TableFill gmtCreate = new TableFill("gmt_create", FieldFill.INSERT);
        TableFill gmtModified = new TableFill("gmt_modified", FieldFill.INSERT);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
        //将填充策略配置
        strategy.setTableFillList(tableFills);
        //乐观锁配置
        strategy.setVersionFieldName("version");
        //是否启动RestFul命名风格
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        //执行
        mpg.execute();
    }
}
