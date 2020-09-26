package com.irisa.obiee.backforfront;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.spi.DocumentationType;

@SpringBootApplication
@EnableSwagger2
public class BackforfrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackforfrontApplication.class, args);

		//IrisaObieeConfiguration irisaObieeConfiguration = IrisaObieeConfiguration.getInstance();
		//UserProfileServiceImpl userProfileService = new UserProfileServiceImpl();
		//userProfileService.getByUserName("a");

	}

	@Bean
	public Docket productApi(){
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage(BackforfrontApplication.class.getPackage().getName())).build();
	}

}
