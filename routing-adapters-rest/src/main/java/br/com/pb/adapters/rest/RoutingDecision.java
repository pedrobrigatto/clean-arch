package br.com.pb.adapters.rest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "The routing decision")
public class RoutingDecision {
	
	@ApiModelProperty(notes = "")
	private String alias;
	@ApiModelProperty(notes = "")
	private String address;
	
	public RoutingDecision() {}
	
	public RoutingDecision (String alias, String address) {
		this.alias = alias;
		this.address = address;
	}

	public String getAlias() {
		return alias;
	}

	void setAlias(String alias) {
		this.alias = alias;
	}

	public String getAddress() {
		return address;
	}

	void setAddress(String address) {
		this.address = address;
	}
}
