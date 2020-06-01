package com.hqh.myconfig;

import com.hqh.compent.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer adapter=new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/User").setViewName("login");
                //registry.addViewController("/User/index.html").setViewName("index1");
                registry.addViewController("/User/6").setViewName("6");
                registry.addViewController("/User/6.html").setViewName("6");
                registry.addViewController("/User/schoolData").setViewName("2");
                registry.addViewController("/User/classData").setViewName("3");
                registry.addViewController("/User/classDynamics").setViewName("4");

            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/User","/User/login");
            }
        };
        return adapter;
    }

}

