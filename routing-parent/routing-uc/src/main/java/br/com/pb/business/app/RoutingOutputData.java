package br.com.pb.business.app;

import java.util.HashMap;
import java.util.Map;

public class RoutingOutputData {
	
	public static final String DESTINATION_ALIAS = "destination_alias";
	
	private String alias;
	private String address;
	private Map<String, Object> context;
	
	RoutingOutputData(String alias, String address) {
		this.alias = alias;
		this.address = address;
		this.context = new HashMap<>();
	}
	
	public RoutingOutputData addContext(String contextKey, Object data) {
		this.context.put(contextKey, data);
		return this;
	}

	public String getAddress() {
		return address;
	}
	
	public String getAlias() {
		return this.alias;
	}

	Map<String, Object> getContext() {
		if (context == null) {
			context = new HashMap<>();
		}
		return context;
	}
	
	public Object getContextEntry (String key) {
		return getContext().get(key);
	}
}
