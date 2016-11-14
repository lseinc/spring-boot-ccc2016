package com.example.jpa;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JPAConfig {
	
	@Autowired
	private AccountDao dao;
	
	@PostConstruct 
	public void postConstruct() {
		try {
			System.out.println("loading accounts...");
			Account checking = new Account();
			checking.setAccountNumber("1234567890");
			checking.setAccountType("CHECKING");
			checking.setBalance(1000.0);
			dao.save(checking);
			
			Account savings = new Account();
			savings.setAccountNumber("9876543210");
			savings.setAccountType("SAVINGS");
			savings.setBalance(100000.0);
			dao.save(savings);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
