package com.in28minutes.rest.webservices.restfullwebservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.*;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public static final String[] SET_VALUES = new String[] { "application/json", "application/xml" };
    private static  final Set<String> DEF_PROC_CUNSM = new HashSet<String>(Arrays.asList(SET_VALUES));

    private static  final  Contact ME_CONTACT = new Contact("Tamir", "http://systbs.com", "systbs@systbs.com");

    private static  final  ApiInfo apiInfo = new ApiInfo("Sprint MicroService",
            "Sprint MicroService learn from udemy",
            "1.0.0.1.2",
            "termsOfServiceUrl",
            ME_CONTACT,
            "license",
            "licenseUrl", new ArrayList<>());


    @Bean
    public Docket api() {


        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo)
                .produces(DEF_PROC_CUNSM);
    }
}