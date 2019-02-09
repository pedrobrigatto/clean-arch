package br.com.pb.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan (basePackages = { "br.com.pb.main.setup" })
public class RoutingApplication {
	
	public static void main (String [] args) {
		SpringApplication.run(RoutingApplication.class, args);
	}
}
