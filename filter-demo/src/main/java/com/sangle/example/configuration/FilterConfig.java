package com.sangle.example.configuration;

import com.sangle.example.filter.StandardFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<StandardFilter> loggingFilter() {
        FilterRegistrationBean<StandardFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new StandardFilter());
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }

}
