package br.com.pb.routing.persistence.mock;

import java.util.ArrayList;
import java.util.List;

public class SegmentationTableDTO {
	
	private String id;
	private String name;
	private String description;
	private List<String> ruleIds;
	
	SegmentationTableDTO (String id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	String getId() {
		return id;
	}

	String getName() {
		return name;
	}

	String getDescription() {
		return description;
	}

	List<String> getRuleIds() {
		if (ruleIds == null) {
			ruleIds = new ArrayList<>();
		}
		return ruleIds;
	}
	
	public SegmentationTableDTO addRuleId (String id) {
		getRuleIds().add(id);
		return this;
	}
}
