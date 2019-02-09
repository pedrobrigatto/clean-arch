package br.com.pb.routing.persistence.mock;

import java.util.HashMap;
import java.util.Map;

import br.com.pb.business.app.MetricsDataGateway;

/**
 * This is just a mock gateway that returns random numbers to the 2 metrics available in the system.
 */
public class MetricsDataGatewayImpl implements MetricsDataGateway {
	
	private static final int RANDOM_GENERATOR_MULTIPLIER = 1000;

	@Override
	public Map<String, Integer> loadMetricsToDestination(String destinationName) {
		Map<String, Integer> metrics = new HashMap<>();
		metrics.put("Idle", (int) Math.round(Math.random() * RANDOM_GENERATOR_MULTIPLIER));
		metrics.put("Queue", (int) Math.round(Math.random() * RANDOM_GENERATOR_MULTIPLIER));
		return metrics;
	}
}
