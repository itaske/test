package com.example.testinggroudweb.patrick.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    public static final String AUTHORIZATION_HEADER = "Authorization";

    public static final String DEFAULT_INCLUDE_PATTERN = "/api/.*";

    @Bean
    public InternalResourceViewResolver defaultViewResolver() {
        return new InternalResourceViewResolver();
    }


    @Bean
    public Docket swaggerSpringfoxDocket() {

        Contact contact = new Contact(
            "Patrick Udochukwu", "", "udochukwupatric@gmail.com"
        );

        List<VendorExtension> vext = new ArrayList<>();
        ApiInfo apiInfo = new ApiInfo(
            "Hyperion",
            "This is the best thing since sliced bread. ",
            "1.0.0",
            "",
            contact,
            "",
            "",
            vext);

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo)
            .pathMapping("/")
            .apiInfo(ApiInfo.DEFAULT)
            .forCodeGeneration(true)
            .genericModelSubstitutes(ResponseEntity.class)
            .ignoredParameterTypes(Pageable.class)
            .ignoredParameterTypes(java.sql.Date.class)
//            .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
//            .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
//            .directModelSubstitute(java.time.LocalDateTime.class, Date.class)

            .useDefaultResponseMessages(false);

        docket = docket.select()
            .paths(regex(DEFAULT_INCLUDE_PATTERN))
            .build();
        return docket;
    }


    private ApiKey apiKey() {
        return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
    }




}
