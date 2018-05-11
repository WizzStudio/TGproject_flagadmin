package com.ctg.flagadmin.config;

import com.ctg.flagadmin.web.interceptor.AuthenticationInterceptor;
import com.ctg.flagadmin.web.interceptor.CouncilAuthorityInterceptor;
import com.ctg.flagadmin.web.interceptor.PostMessageInterceptor;
import com.ctg.flagadmin.web.interceptor.SpaceApplyAuthorityInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorWebConfigurer implements WebMvcConfigurer {
    private AuthenticationInterceptor authenticationInterceptor;
    private PostMessageInterceptor postMessageInterceptor;
    private CouncilAuthorityInterceptor councilAuthorityInterceptor;
    private SpaceApplyAuthorityInterceptor spaceApplyAuthorityInterceptor;

    public InterceptorWebConfigurer(AuthenticationInterceptor authenticationInterceptor,
                                    PostMessageInterceptor postMessageInterceptor, CouncilAuthorityInterceptor councilAuthorityInterceptor, SpaceApplyAuthorityInterceptor spaceApplyAuthorityInterceptor) {
        this.authenticationInterceptor = authenticationInterceptor;
        this.postMessageInterceptor = postMessageInterceptor;
        this.councilAuthorityInterceptor = councilAuthorityInterceptor;
        this.spaceApplyAuthorityInterceptor = spaceApplyAuthorityInterceptor;
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
        registry.addInterceptor(postMessageInterceptor).addPathPatterns("/message/**");
        registry.addInterceptor(spaceApplyAuthorityInterceptor).addPathPatterns("/spaceApply/**");
        registry.addInterceptor(councilAuthorityInterceptor).addPathPatterns("/councilOrder/**", "/place/council");
    }
}
