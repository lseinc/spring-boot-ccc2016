package com.example.services;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableAutoConfiguration
@EnableHystrix
@EnableDiscoveryClient
@EnableEurekaServer
@EnableCircuitBreaker
@EnableConfigurationProperties
public class DemoEurekaServer {

	public static void main(String[] args) {
		SpringApplication.run(DemoEurekaServer.class, args);
	}
}
