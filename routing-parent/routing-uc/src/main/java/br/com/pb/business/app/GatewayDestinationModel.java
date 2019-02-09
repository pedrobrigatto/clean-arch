package br.com.pb.business.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import br.com.pb.business.core.AliasedDestination;
import br.com.pb.business.core.Destination;
import br.com.pb.business.core.Metric;

public class GatewayDestinationModel {
	
	private final String id;
	private final String alias;
	private final String address;
	private final String name;
	private final String type;
	private Map<String, Integer> metrics;
	
	public GatewayDestinationModel (String id, String alias, String address, String name, String type) {
		this.id = id;
		this.alias = alias;
		this.address = address;
		this.name = name;
		this.type = type;
	}

	String getAlias() {
		return alias;
	}

	String getAddress() {
		return address;
	}
	
	GatewayDestinationModel fromDomain (AliasedDestination domainModel) {
		return null;
	}

	void setMetrics(Map<String, Integer> metrics) {
		this.metrics = metrics;
	}

	String getId() {
		return id;
	}

	String getName() {
		return name;
	}

	String getType() {
		return type;
	}
	
	public GatewayDestinationModel addMetric(String name, Integer value) {
		if (Metric.isValid(name)) {
			getMetrics().put(name, value);
		}
		return this;
	}

	private Map<String, Integer> getMetrics() {
		if (metrics == null) {
			metrics = new HashMap<>();
		}
		return metrics;
	}
	
	public AliasedDestination toDomain() {
		Destination destination = new Destination(this.name, this.address, this.type); 
		AliasedDestination aliasedDestination = new AliasedDestination(this.alias, destination);
		return addMetricsToDestination(aliasedDestination);
	}

	private AliasedDestination addMetricsToDestination(AliasedDestination aliasedDestination) {
		for (Entry<String, Integer> entry : getMetrics().entrySet()) {
			aliasedDestination.getDestination().setMetric(Metric.from(entry.getKey()), entry.getValue());
		}
		return aliasedDestination;
	}
}
