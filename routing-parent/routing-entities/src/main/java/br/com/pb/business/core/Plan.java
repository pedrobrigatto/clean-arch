package br.com.pb.business.core;

public enum Plan {
	
	Regular, 
	Premium,
	Other;

	public static Plan from(String name) {
		Plan plan = Plan.Other;
		if (Regular.name().toLowerCase().contentEquals(name.toLowerCase())) {
			plan = Regular;
		} else if (Premium.name().toLowerCase().contentEquals(name.toLowerCase())) {
			plan = Premium;
		}
		return plan;
	}
}
