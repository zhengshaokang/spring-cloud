package com.zsk.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc  
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
	@Override  
    public void addResourceHandlers(ResourceHandlerRegistry registry) {  
    registry.addResourceHandler("/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/statics/html/");  
    registry.addResourceHandler("/css/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/statics/css/");  
    registry.addResourceHandler("/js/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX+"/statics/js/");  
    super.addResourceHandlers(registry);  
    }  
}
