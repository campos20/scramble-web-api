package com.alexandrecampos.scramblewebapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScrambleWebApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScrambleWebApiApplication.class, args);

		// This print is just for now, until the configuration of logback
		System.out.println("http://localhost:2020/swagger-ui.html");
	}

}
