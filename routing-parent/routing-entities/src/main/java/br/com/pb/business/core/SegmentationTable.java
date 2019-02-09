package br.com.pb.business.core;

import java.io.Serializable;
import java.util.List;

public class SegmentationTable implements Serializable {

	private static final long serialVersionUID = 2371892234917005124L;
	
	private String name;
	private String description;
	private List<SegmentationRule> rules;
	
	public SegmentationTable (String name, List<SegmentationRule> rules) {
		this.name = name;
		this.rules = rules;
	}

	List<SegmentationRule> getRules() {
		return this.rules;
	}

	String getName() {
		return name;
	}

	String getDescription() {
		return description;
	}
}
