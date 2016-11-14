package com.example.services;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
@EnableHystrix
@EnableHystrixDashboard
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableConfigurationProperties
@EnableZuulProxy
@EnableEurekaServer
public class DemoHystrixServer {

	
	@RequestMapping("/")
	public String home() {
		return "forward:/hystrix";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoHystrixServer.class, args);
	}
}
