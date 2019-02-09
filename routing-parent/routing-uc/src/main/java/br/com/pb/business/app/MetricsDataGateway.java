package br.com.pb.business.app;

import java.util.Map;

public interface MetricsDataGateway {
	
	Map<String, Integer> loadMetricsToDestination(String destinationName);
}
