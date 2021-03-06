package com.cg.bmd;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2 // To enable the framework for your springbootapplication

@Configuration  // This annotation indicates that a class declares one or more @Bean methods
                //& may be processed by the Spring container to generate bean definitions and
               // service requests for those beans at runtime.
public class SwaggerConfig {

	@Bean //
	public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("Admin-api").apiInfo(apiInfo()).select()
                .paths(postPaths()).build();
	}
	
	private Predicate<String> postPaths(){
		return or(regex("/admin/.*"), regex("/doctors/.*"), regex("/patients/.*") , regex("/feedback/.*") ,regex("/appointment/.*") ,regex("/user/.*"));
	}
	
    
    private ApiInfo apiInfo() {
    	return new ApiInfoBuilder().title("Admin API").description("Shravika API reference for developers")
    			.termsOfServiceUrl("http://shravika.com").license("Shravika License").licenseUrl("shravikabajjuri98@gmail.com")
    			.version("1.0").build();
    
    }
	
}
