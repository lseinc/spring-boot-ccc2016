package com.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@EnableHystrix
@RestController
@EnableEurekaClient
@EnableCircuitBreaker
@EnableConfigurationProperties
@RequestMapping(value="/api")
public class DemoServiceApplication {
	private static final Logger logger = LoggerFactory.getLogger(DemoServiceApplication.class);
	
    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:9090");
        config.addAllowedOrigin("http://localhost:9191");
        config.addAllowedOrigin("http://localhost:8080");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(0);
        return bean;
    }

	@Value("${eureka.instance.instanceId}")
	private String instanceId;

    public static void main(String[] args) {
        SpringApplication.run(DemoServiceApplication.class, args);
    }

    @RequestMapping(value="/hello")
    public String hello() {
    	logger.info("+++ ["+instanceId+"] received /hello request!");
    	return "Hello World !";
    }

    @RequestMapping(value="/toUpper/{word}")
    public String toUpper(@PathVariable("word")String word) {
        logger.info("+++ ["+instanceId+"] received /toUpper request with word="+word+" !");
        String upper = "<null>";
        if (word!=null) {
            upper = word.toUpperCase();
        }
        return upper;
    }

}