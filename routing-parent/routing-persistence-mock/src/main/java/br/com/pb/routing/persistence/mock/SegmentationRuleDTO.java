package br.com.pb.routing.persistence.mock;

import java.util.List;

public class SegmentationRuleDTO {
	
	private final String id;
	private final String label;
	private List<String> destinationIds;
	
	SegmentationRuleDTO (String id, String label) {
		this.id = id;
		this.label = label;
	}

	String getId() {
		return id;
	}

	String getLabel() {
		return label;
	}

	List<String> getDestinationIds() {
		return destinationIds;
	}
	
	public SegmentationRuleDTO addDestinationId(String id) {
		getDestinationIds().add(id);
		return this;
	}
}
