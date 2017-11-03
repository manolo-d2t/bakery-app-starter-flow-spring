package com.vaadin.starter.bakery;

import com.vaadin.starter.bakery.app.security.SecurityConfig;
import com.vaadin.starter.bakery.backend.data.entity.User;
import com.vaadin.starter.bakery.backend.repositories.UserRepository;
import com.vaadin.starter.bakery.backend.service.UserService;
import com.vaadin.starter.bakery.backend.util.LocalDateJpaConverter;
import com.vaadin.starter.bakery.ui.BakeryApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Spring boot web application initializer.
 */

/*
 * To disable web security:
 *
 * @SpringBootApplication(exclude = {
 * org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.
 * class })
 */
@SpringBootApplication(scanBasePackageClasses = { BakeryApp.class, Application.class, UserService.class,
		SecurityConfig.class })
@EnableJpaRepositories(basePackageClasses = { UserRepository.class})
@EntityScan(basePackageClasses={User.class, LocalDateJpaConverter.class})
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}