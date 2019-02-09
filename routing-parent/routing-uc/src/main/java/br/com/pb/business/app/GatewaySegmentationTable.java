package br.com.pb.business.app;

import java.util.ArrayList;
import java.util.List;

public class GatewaySegmentationTable {
	
	private String name;
	private String description;
	private List<GatewaySegmentationRule> rules;
	
	public GatewaySegmentationTable (String name, String description) {
		this.name = name;
		this.description = description;
	}

	String getName() {
		return name;
	}

	String getDescription() {
		return description;
	}

	List<GatewaySegmentationRule> getRules() {
		if (rules == null) {
			rules = new ArrayList<>();
		}
		return rules;
	}
	
	public GatewaySegmentationTable addRule (GatewaySegmentationRule rule) {
		getRules().add(rule);
		return this;
	}

	public void setRules(List<GatewaySegmentationRule> rules) {
		this.rules = rules;
	}
}
