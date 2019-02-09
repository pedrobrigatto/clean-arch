package br.com.pb.adapters.rest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "The routing request with all information need to calculate the most available destination")
public class RoutingRequest {
	
	@ApiModelProperty(notes = "The origin of the call")
	private String from;
	@ApiModelProperty(notes = "The name of table that contains the segmentation strategy for incoming calls")
	private String segmentationTableName;
	@ApiModelProperty(notes = "The attributes to be used when matching the best rule to use to handle the incoming call")
	private String segmentationAttributes;
	
	public RoutingRequest() {}
	
	// This is the constructor I'd like to use ... the only one. 
	// We can't do this because of a limitation in the framework/library used to create the RESTful controllers. 
	// Error reported is:
	// Lesson: adding such dependency in inner layers make the business depend on DETAILS!!
	public RoutingRequest (String from, String segmentationTableName, String segmentationAttributes) {
		this.from = from;
		this.segmentationAttributes = segmentationAttributes;
		this.segmentationTableName = segmentationTableName;
	}

	public String getFrom() {
		return from;
	}
	
	public String getSegmentationTableName() {
		return segmentationTableName;
	}

	public String getSegmentationAttributes() {
		return segmentationAttributes;
	}

	void setFrom(String from) {
		this.from = from;
	}

	void setSegmentationTableName(String segmentationTableName) {
		this.segmentationTableName = segmentationTableName;
	}

	void setSegmentationAttributes(String segmentationAttributes) {
		this.segmentationAttributes = segmentationAttributes;
	}
}
