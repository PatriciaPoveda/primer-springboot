package com.formacionjava.springboot.apirest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.Contact;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


//Le pasamos nuestra configuracion a swagger para que nos devuelva nuestras APIs REST documentadas. 
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.formacionjava.springboot.apirest.controllers"))
				.paths(PathSelectors.any())
				.build();
	}
//	private ApiInfo metaInfo() {
//
//        return new ApiInfo(
//            "Spring Boot Swagger2 Example API",
//            null,
//            "1.0",
//            "Terms of Service",
//            new Contact("Your Name or Team", "https://www.google.com/",
//                "ppb@gmail.com"),
//            "Apache License Version 2.0",
//            "https://www.apache.org/licenses/"
//        )

        
 //   }
}
