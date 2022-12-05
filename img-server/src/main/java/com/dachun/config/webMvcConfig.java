package com.dachun.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @className webMvcConfig
 * @description TODO
 * @date 2022/11/29 18:56
 */
@Configuration
public class webMvcConfig implements WebMvcConfigurer {

    @Value("${web.imageUse}/")
    private String imageUse;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("file:"+imageUse);
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
