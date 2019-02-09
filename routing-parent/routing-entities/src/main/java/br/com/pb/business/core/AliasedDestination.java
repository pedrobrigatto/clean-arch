package br.com.pb.business.core;

public class AliasedDestination {
	
	private final String alias;
	private final Destination destination;
	
	public AliasedDestination (String alias, Destination destination) {
		this.alias = alias;
		this.destination = destination;
	}

	public String getAlias() {
		return alias;
	}

	public Destination getDestination() {
		return destination;
	}
}
