package br.com.pb.business.core;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class RoutingEngine {

	public enum Strategy {
		Speedy (Metric.Idle), 
		Standard (Metric.Queue);

		private Metric metric;

		Strategy (Metric metric) {
			this.metric = metric;
		}

		Metric getMetric() {
			return this.metric;
		}
	}

	private Strategy strategy;

	public RoutingEngine (Plan customerPlan) {
		resolveStrategy(customerPlan);
	}

	private void resolveStrategy (Plan customerPlan) {
		switch (customerPlan) {
		case Regular:
			this.strategy = Strategy.Standard;
			break;
		case Premium:
			this.strategy = Strategy.Speedy;
			break;
		default:
			this.strategy = Strategy.Standard;
			break;
		}
	}

	public enum DestinationSelection {
		MostIdle,
		LessOccupied
	}

	public AliasedDestination route(List<AliasedDestination> possibleDestinations) {
		return applyStrategyAndSelect(possibleDestinations);
	}
	
	private AliasedDestination applyStrategyAndSelect(List<AliasedDestination> possibleDestinations) {
		Map<AliasedDestination, Integer> metricPerDestination = new HashMap<>();

		for (AliasedDestination aliasedDestination : possibleDestinations) {
			metricPerDestination.put(aliasedDestination, 
					aliasedDestination.getDestination().getMetricValue(strategy.getMetric()));
		}
		
		Entry<AliasedDestination, Integer> minEntry = Collections.min(metricPerDestination.entrySet(),
				Comparator.comparing(Entry::getValue));
		return minEntry.getKey();
	}
}
