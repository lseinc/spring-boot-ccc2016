package com.example.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoHystrixServer.class)
public class DemoHystrixTests {

	@Test
	public void contextLoads() {
	}

}
