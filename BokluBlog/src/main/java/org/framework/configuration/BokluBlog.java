package org.framework.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages ="org.framework")
@EnableJpaRepositories("org.framework")
@EntityScan("org.framework.model")
public class BokluBlog extends SpringBootServletInitializer {
		
	public static void main(String[] args) {
		SpringApplication.run(BokluBlog.class, args);
	}
}
