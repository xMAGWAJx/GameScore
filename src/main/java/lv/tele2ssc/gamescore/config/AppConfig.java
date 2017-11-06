/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv.tele2ssc.gamescore.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * Web application configuration. We need this to add interceptor which will
 * select current logged-in user and put it to the model of every page.
 */
@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Registering interceptor
        //  registry.addInterceptor(currentUserInterceptor);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       registry.addViewController("/").setViewName("index");
       registry.addViewController("/ping-pong").setViewName("ping-pong");
       registry.addViewController("/novus").setViewName("novus");
       registry.addViewController("/football").setViewName("football");
       registry.addViewController("/pull-bar").setViewName("pull-bar");
       registry.addViewController("/press-bar").setViewName("press-bar");
       registry.addViewController("/darts").setViewName("darts");
       registry.addViewController("/computer").setViewName("computer");
    }

    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }

}
