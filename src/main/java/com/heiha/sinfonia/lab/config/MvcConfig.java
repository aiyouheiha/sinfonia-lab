package com.heiha.sinfonia.lab.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * <br>
 * <b>Project:</b> lab<br>
 * <b>Date:</b> 2017/8/30 11:03<br>
 * <b>Author:</b> heiha<br>
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private AuthInterceptor authInterceptor;
    @Autowired
    private TestInterceptor testInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(authInterceptor);
        registry.addInterceptor(testInterceptor);
    }
}
