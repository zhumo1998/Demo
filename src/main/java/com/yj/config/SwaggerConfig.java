package com.yj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.bind.annotation.PutMapping;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2 //开启Swagger2
public class SwaggerConfig {
    //配置Swagger的Docket的Bean实例
    @Bean
    public Docket docket(Environment environment){
        //获取项目的运行环境

        //设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev");
        //通过 environment.acceptsProfiles(profiles)的返回值来判断是否处在自己所设的环境中
        //开发环境开启Swagger  生产环境关闭Swagger
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //是否启动swagger 默认true  false:不开启swagger
                .enable(flag)
                .groupName("赵耀鹏")
                .select()
                //配置要扫描接口的方式
                //basePackage("com.yj.zyp.controller") 指定包扫描
                //any() 扫描全部
                //none() 全部不扫描
                //withClassAnnotation(Service.class):根据类的注解扫描
                //withMethodAnnotation(ResponseBody.class) 根据方法的注解扫描
                .apis(RequestHandlerSelectors.basePackage("com.yj.controller"))
                //配置过滤什么路径
//                .paths(PathSelectors.ant("/zyp/**"))
                .build();
    }
    //配置Swagger基本信息
    public ApiInfo apiInfo(){
        Contact contact = new Contact("","","");
        return new ApiInfo(
                "朱墨的Swagger日志"
                ,"近朱者赤近墨者黑"
                , "v2.0"
                , ""
                , contact
                , ""
                , ""
                ,new ArrayList<>());
    }

    //配置多个Swagger的分组
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A")
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(PutMapping.class))
                .build();
    }
}
