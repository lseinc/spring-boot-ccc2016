package com.example.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.services.DemoZuulServer;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoZuulServer.class)
public class DemoZuulServerTests {

	@Test
	public void contextLoads() {
	}

}
