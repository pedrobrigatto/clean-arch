package br.com.pb.business.core;

import java.util.List;

public class SegmentationRule {
	
	private String name;
	private Plan plan;
	private List<AliasedDestination> destinations;
	
	public SegmentationRule (String name, Plan plan, List<AliasedDestination> destinations) {
		this.name = name;
		this.plan = plan;
		this.destinations = destinations;
	}

	public String getName() {
		return name;
	}

	public List<AliasedDestination> getDestinations() {
		return destinations;
	}

	public boolean matches(Plan plan) {
		return this.plan == plan;
	}
}
