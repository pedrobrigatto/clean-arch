package br.com.pb.business.app;

import java.util.HashMap;
import java.util.Map;

public class RoutingInputData {
	
	public static final String CUSTOMER_PLAN = "plan";
	public static final String SEGMENTATION_TABLE = "segmentation";
	
	private Map<String, Object> attributes;
	
	public RoutingInputData (String from, String segmentationTableName, String segmentationAttributes) {
		parseSegmentationAttributes(segmentationAttributes);
	}
	
	private void parseSegmentationAttributes(String segmentationAttributes) {
		String [] pairs = segmentationAttributes.split(";");
		String [] tokensOfCurrentPair;
		for (String pair : pairs) {
			tokensOfCurrentPair = pair.split("=");
			getAttributes().put(tokensOfCurrentPair[0], tokensOfCurrentPair[1]);
		}
	}
	
	public RoutingInputData setAttribute(String key, Object value) {
		getAttributes().put(key, value);
		return this;
	}
	
	private Map<String, Object> getAttributes() {
		if (attributes == null) {
			attributes = new HashMap<>();
		}
		return attributes;
	}

	public Object getAttribute(String key) {
		return getAttributes().containsKey(key) ? getAttributes().get(key) : null;
	}
}
