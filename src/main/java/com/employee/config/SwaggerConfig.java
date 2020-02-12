package com.employee.config;

import java.util.Collections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final Logger logger = LoggerFactory.getLogger(SwaggerConfig.class);

    /**
     * Configuration for swagger.
     *
     * @return
     */
    @Bean
    public Docket api() {
        logger.info("Start - Rest Service : Swagger API");
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.employee.controller"))
                .paths(regex("/api/v1.*"))
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Employee Jpa Specif",
                "Employee Jpa Specification Example app",
                "1.0",
                "TERMS OF SERVICE URL",
                new Contact("EMPLOYEE-JPA-SPECIFICATION", "http://localhost:8181/api/v1/employee ", "raza.khawaja18@gmail.com"),
                "MIT License",
                "LICENSE URL",
                Collections.emptyList()
        );
    }
}