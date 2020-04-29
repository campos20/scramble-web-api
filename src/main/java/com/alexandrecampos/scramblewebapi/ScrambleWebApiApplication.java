package com.alexandrecampos.scramblewebapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class ScrambleWebApiApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ScrambleWebApiApplication.class);
		ConfigurableApplicationContext applicationContext = app.run(args);
		Environment env = applicationContext.getEnvironment();
		String serverPort = env.getProperty("server.port");

		String message = String.format("\n----------------------------------------------------------\n\t"
				+ "Access URL: http://localhost:%s/swagger-ui.html"
				+ "\n----------------------------------------------------------", serverPort);
		
		// print until logback is done
		System.out.println(message);
	}

}
