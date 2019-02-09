package br.com.pb.business.app;

import java.util.ArrayList;
import java.util.List;

import br.com.pb.business.core.AliasedDestination;
import br.com.pb.business.core.Plan;
import br.com.pb.business.core.SegmentationRule;

public class GatewaySegmentationRule {
	
	private final String label;
	private final String plan;
	private List<GatewayDestinationModel> destinations;
	
	public GatewaySegmentationRule (String label, String plan) {
		this.label = label;
		this.plan = plan;
	}

	String getLabel() {
		return label;
	}

	String getPlan() {
		return plan;
	}

	List<GatewayDestinationModel> getDestinations() {
		if (destinations == null) {
			destinations = new ArrayList<>();
		}
		return destinations;
	}
	
	public GatewaySegmentationRule addDestination (GatewayDestinationModel destination) {
		getDestinations().add(destination);
		return this;
	}

	public SegmentationRule toDomain() {
		List<AliasedDestination> destinations = new ArrayList<>();
		for (GatewayDestinationModel destination : getDestinations()) {
			destinations.add(destination.toDomain());
		}
		return new SegmentationRule(this.label, Plan.from(this.plan), destinations);
	}
}
