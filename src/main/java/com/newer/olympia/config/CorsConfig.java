package com.newer.olympia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * 解决跨域
 */
@Configuration
public class CorsConfig {

    private final String [] orgins = {
           "www.baidu.com",
            "127.0.0.1",
            "127.0.0.1:8084",
    };


    @Bean
    public CorsFilter corsFilter(){

        CorsConfiguration corsConfiguration = new CorsConfiguration();
        this.addAllowedOrigin(corsConfiguration);
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.setAllowCredentials(true); // 跨域时进行session共享

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsFilter(source);
    }

    private void addAllowedOrigin(CorsConfiguration corsConfiguration) {
        for(String origin:orgins){
            //跨域时允许的访问源 http://www.baidu.com
            //http：//127.0.0.1
            corsConfiguration.addAllowedOrigin("http://"+origin);
            corsConfiguration.addAllowedOrigin("https://"+origin);
        }
    }


}
