package com.salesianostriana.trianasat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrianaSatApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrianaSatApplication.class, args);
	}
	
	
	/*@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins(
						"http://94.247.31.252",
						"http://www.salesianos-triana.com",
						"http://localhost",
						"http://www.trianasat.com"
						);
			}
			
		};
	}*/
	
	
}
