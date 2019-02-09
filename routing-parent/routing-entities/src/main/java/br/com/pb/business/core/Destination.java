package br.com.pb.business.core;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Destination implements Serializable {
	
	private static final long serialVersionUID = 1592404558307958968L;

	public enum Type {
		LIVE_AGENT,
		SELF_SERVICE_APPLICATION;
		
		public static Type from (String label) {
			Type type = LIVE_AGENT;
			if (SELF_SERVICE_APPLICATION.name().contentEquals(label)) {
				type = SELF_SERVICE_APPLICATION;
			}
			return type;
		}
	}
	
	private String id;
	private String name;
	private String url;
	private Type type;
	private Map<Metric, Integer> metrics;
	
	private Map<String, Object> extras;
	
	public Destination (String name, String url, String type) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.url = url;
		this.type = Type.from(type);
	}
	
	public String getId () {
		return this.id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	public Destination addExtra(String key, Object value) {
		getExtras().put(key, value);
		return this;
	}
	
	public Destination removeExtra (String key) {
		getExtras().remove(key);
		return this;
	}
	
	private Map<String, Object> getExtras() {
		if (extras == null) {
			extras = new HashMap<>();
		}
		return extras;
	}
	
	public Destination setMetric (Metric metric, Integer value) {
		getMetrics().put(metric, value);
		return this;
	}
	
	public Integer getMetricValue (Metric metric) {
		Integer value = metric.standardValue();
		if (getMetrics().containsKey(metric)) {
			value = getMetrics().get(metric);
		}
		return value;
	}
	
	private Map<Metric, Integer> getMetrics() {
		if (metrics == null) {
			metrics = new HashMap<>();
		}
		return metrics;
	}
}
