package br.com.pb.routing.persistence.mock;

import br.com.pb.business.core.Destination;

class DestinationDTO {
	
	private final String id;
	private final String alias;
	private final String name;
	private final String address;
	private final String type;
	
	public DestinationDTO (String alias, String id, String name, String address, String type) {
		this.id = id;
		this.alias = alias;
		this.name = name;
		this.address = address;
		this.type = type;
	}

	String getAlias() {
		return alias;
	}

	public String getId() {
		return id;
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
