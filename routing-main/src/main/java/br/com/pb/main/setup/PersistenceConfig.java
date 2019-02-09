package br.com.pb.main.setup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.pb.business.app.MetricsDataGateway;
import br.com.pb.business.app.SegmentationDataGateway;
import br.com.pb.routing.persistence.mock.MetricsDataGatewayImpl;
import br.com.pb.routing.persistence.mock.SegmentationDataGatewayImpl;

@Configuration
public class PersistenceConfig {
	
	@Bean
	public SegmentationDataGateway getSegmentationDataGateway() {
		return new SegmentationDataGatewayImpl();
	}
	
	@Bean
	public MetricsDataGateway getMetricsDataGateway() {
		return new MetricsDataGatewayImpl();
	}
}
