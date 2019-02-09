package br.com.pb.main.setup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.pb.adapters.rest.RoutingController;
import br.com.pb.business.app.RouteProcessor;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class EndpointConfig {
	
	@Bean
	public RoutingController getRoutingEndpoint (RouteProcessor routeProcessor) {
		return new RoutingController(routeProcessor);
	}
}
