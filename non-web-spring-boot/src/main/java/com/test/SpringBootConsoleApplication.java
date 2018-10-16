package com.test;

import com.test.service.HelloMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

	@Autowired
	private HelloMessageService helloService;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootConsoleApplication.class, args);
	}

	public void run(String... args) throws Exception {
		System.out.println("args -> " + args[0]);
		if (args[0].equalsIgnoreCase("1")) {
			System.out.println(helloService.getMessage(args[0]));
		} else {
			System.out.println(helloService.getMessage());
		}
	}
}
