package com.cabBooking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo metaData(){
        return new ApiInfoBuilder()
                .title("Cab Booking Application REST Api")
                .description("Swagger Configuration For Application")
                .version("1.0")
                .contact(new Contact("Protyush Banerjee", "https://protyush-portfolio.vercel.app/", "protyush03@gmail.com"))
                .build();
    }

    //For Swagger api doc generation
    //http:localhost:8091/v2/api-docs
}
