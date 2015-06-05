package net.mobilebulletin.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/*
 * @author Mazi Muhlari
 * 
 * This is the main entry point of the spring boot application. This project
 * can be run as an executable and without deploying. Refer to the link to see
 * how it works
 * 
 * @see <a href="http://docs.spring.io/spring-boot/docs/current/reference/html/getting-started-first-application.html">Spring Boot Application Tutorial</a>
 * 
 */

@SpringBootApplication
public class Application extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(Application.class);
	}
	
	public static void main(String[] args){
		SpringApplication.run(Application.class, args);
	}

}
