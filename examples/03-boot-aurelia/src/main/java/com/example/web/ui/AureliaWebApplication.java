package com.example.web.ui;


import org.slf4j.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.cors.*;
import org.springframework.web.filter.CorsFilter;

import javax.annotation.PostConstruct;
import java.util.*;

@SpringBootApplication
@RestController
//@EnableHystrix
//@EnableEurekaClient
//@EnableCircuitBreaker
//@EnableConfigurationProperties
@RequestMapping(value="/r", produces = "application/json")
public class AureliaWebApplication {
    private static final Logger logger = LoggerFactory.getLogger(AureliaWebApplication.class);

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



    @Value("${info.service.instanceId}")
    private String instanceId;

    @Value("${info.service.version:0.0.1}")
    private String version;

    public static void main(String[] args) {
        SpringApplication.run(AureliaWebApplication.class, args);
    }

    @PostConstruct
    public void init () {
        logger.warn("started AureliaWebApplication version="+version);
    }

    @RequestMapping(value="/hello")
    public String hello() {
    	logger.info("+++ ["+instanceId+"] received /hello request!");
    	return "Hello World !";
    }

    @RequestMapping(value="/version")
    public Map<String,Object> version() {
        logger.info("+++ ["+instanceId+"] received /version request, version="+version);
        Map<String,Object> response = new HashMap<String,Object>();
        response.put("version",version);
        response.put("status","SUCCESS");
        response.put("timestamp",new Date());
        return response;
    }

    @RequestMapping(value="/toUpper/{word}")
    public Map<String,Object> toUpper(@PathVariable("word")String word) {
        logger.info("+++ ["+instanceId+"] received /toUpper request with word="+word+" !");
        String upper = "";
        if (word!=null) {
            upper = word.toUpperCase();
        }
        Map<String,Object> response = new HashMap<String,Object>();
        response.put("word",upper);
        response.put("status","SUCCESS");
        response.put("timestamp",new Date());
        logger.info("+++ ["+instanceId+"] response="+response);
        return response;
    }

}
