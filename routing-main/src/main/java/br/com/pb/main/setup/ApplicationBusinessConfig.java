package br.com.pb.main.setup;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.pb.business.app.MetricsDataGateway;
import br.com.pb.business.app.RouteProcessor;
import br.com.pb.business.app.RoutingUC;
import br.com.pb.business.app.SegmentationDataGateway;

@Configuration
public class ApplicationBusinessConfig {

	@Bean
	public RouteProcessor getRoutingProcessor (
			SegmentationDataGateway segmentationDataGateway, MetricsDataGateway metricsGateway) {
		return new RoutingUC(segmentationDataGateway, metricsGateway);
	}
}
