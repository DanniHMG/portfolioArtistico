package com.tuportfolio.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tuportfolio.portfolio.services.FileService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class PortfolioApplication {
	@Autowired
	private FileService fileService;

	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}

	@PostConstruct
	public void init() {
		fileService.init();
	}
}