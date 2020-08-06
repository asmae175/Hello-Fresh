package me.zhulin.shopapi;

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

import me.zhulin.shopapi.api.CartController;
import me.zhulin.shopapi.api.CategoryController;
import me.zhulin.shopapi.api.OrderController;
import me.zhulin.shopapi.api.ProductController;
import me.zhulin.shopapi.api.UserController;
import me.zhulin.shopapi.repository.*;
import me.zhulin.shopapi.service.UserService;
import me.zhulin.shopapi.service.impl.UserServiceImpl;

@SpringBootApplication
@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses=UserController.class)
@ComponentScan(basePackageClasses=CartController.class)
@ComponentScan(basePackageClasses=CategoryController.class)
@ComponentScan(basePackageClasses=OrderController.class)
@ComponentScan(basePackageClasses=ProductController.class)
@ComponentScan(basePackageClasses=UserRepository.class)
@ComponentScan(basePackageClasses=UserServiceImpl.class)
@ComponentScan(basePackageClasses=UserService.class)
@ComponentScan({"me.zhulin.shopapi.api.CartController","me.zhulin.shopapi.api.CategoryController","me.zhulin.shopapi.api.OrderController","me.zhulin.shopapi.api.ProductController","me.zhulin.shopapi.api.UserController" })
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

