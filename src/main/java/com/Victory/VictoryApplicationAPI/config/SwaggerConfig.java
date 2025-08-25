package com.Victory.VictoryApplicationAPI.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

/**
 * @author kk
 * @description swagger配置类
 * @date 2025-1-17 14:27:10
 */
public class SwaggerConfig {

    @Value("${swagger.enabled}")
    boolean swaggerEnabled;

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .enable(swaggerEnabled)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.Victory.VictoryApplicationAPI.controller"))
                // 指定路径处理，PathSelectors.any()代表不过滤任何路径
                //.paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        /*作者信息*/
        Contact contact = new Contact("kk", "https://xxxxxxx.github.io", "12345678@qq.com");
        return new ApiInfo(
                "维通利API",
                "维通利接口文档",
                "v1.0",
                "https://xxxxxx.github.io",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );
    }


}
