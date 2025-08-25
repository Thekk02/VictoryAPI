package com.Victory.VictoryApplicationAPI;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author kk
 * @description 启动类
 * @date 2024-8-28 13:00:41
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class})
@ServletComponentScan("com.Victory.VictoryApplicationAPI.filter")
//@ComponentScan()
public class VictoryApplicationAPI {
    public static void main(String[] args) {
        SpringApplication.run(VictoryApplicationAPI.class, args);
    }
}
