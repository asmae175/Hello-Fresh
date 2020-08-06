package me.ensah.shopapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import me.ensah.shopapi.api.CartController;
import me.ensah.shopapi.api.CategoryController;
import me.ensah.shopapi.api.OrderController;
import me.ensah.shopapi.api.ProductController;
import me.ensah.shopapi.api.UserController;
import me.ensah.shopapi.repository.*;
import me.ensah.shopapi.service.UserService;
import me.ensah.shopapi.service.impl.UserServiceImpl;

@SpringBootApplication
@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses=me.ensah.shopapi.api.UserController.class)
@ComponentScan(basePackageClasses=me.ensah.shopapi.api.CartController.class)
@ComponentScan(basePackageClasses=me.ensah.shopapi.api.CategoryController.class)
@ComponentScan(basePackageClasses=me.ensah.shopapi.api.OrderController.class)
@ComponentScan(basePackageClasses=me.ensah.shopapi.api.ProductController.class)
@ComponentScan(basePackageClasses=me.ensah.shopapi.repository.UserRepository.class)
@ComponentScan(basePackageClasses=me.ensah.shopapi.service.impl.UserServiceImpl.class)
@ComponentScan(basePackageClasses=me.ensah.shopapi.service.UserService.class)
@ComponentScan({"me.ensah.shopapi.api.CartController","me.ensah.shopapi.api.CategoryController","me.ensah.shopapi.api.OrderController","me.ensah.shopapi.api.ProductController","me.ensah.shopapi.api.UserController" })
public class ShopApiApplication extends WebMvcConfigurerAdapter {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

   
    @SuppressWarnings("deprecation")
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(ShopApiApplication.class, args);
    }

}

