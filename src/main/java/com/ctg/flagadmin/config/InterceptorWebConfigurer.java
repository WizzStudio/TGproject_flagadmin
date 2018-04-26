package com.ctg.flagadmin.config;

import com.ctg.flagadmin.web.interceptor.AuthenticationInterceptor;
import com.ctg.flagadmin.web.interceptor.PostStarMessageInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorWebConfigurer implements WebMvcConfigurer {
    private AuthenticationInterceptor authenticationInterceptor;
    private PostStarMessageInterceptor postStarMessageInterceptor;
    public InterceptorWebConfigurer(AuthenticationInterceptor authenticationInterceptor,
                                    PostStarMessageInterceptor postStarMessageInterceptor) {
        this.authenticationInterceptor = authenticationInterceptor;
        this.postStarMessageInterceptor = postStarMessageInterceptor;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .exposedHeaders("authorization")
                .allowCredentials(false).maxAge(3600);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor).addPathPatterns("/**").excludePathPatterns("/admin/login");
        registry.addInterceptor(postStarMessageInterceptor).addPathPatterns("/message/starSpace");
    }
}
