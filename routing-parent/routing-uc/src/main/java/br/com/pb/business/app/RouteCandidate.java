package br.com.pb.business.app;

import br.com.pb.business.core.Destination;

public class RouteCandidate {
	
	private final String alias;
	private final String name;
	private final String address;
	private final String type;
	
	public RouteCandidate (String alias, String name, String address, String type) {
		this.alias = alias;
		this.name = name;
		this.address = address;
		this.type = type;
	}

	String getAlias() {
		return alias;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getType() {
		return type;
	}
	
	public Destination toDestination () {
		return new Destination(name, address, type);
	}
}
