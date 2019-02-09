package br.com.pb.business.app;

import java.util.ArrayList;
import java.util.List;

import br.com.pb.business.core.SegmentationRule;
import br.com.pb.business.core.SegmentationTable;

public class SegmentationTableConverter {
	
	static SegmentationTable convert(GatewaySegmentationTable applicationTable) {
		List<SegmentationRule> rules = new ArrayList<>();
		for (GatewaySegmentationRule gatewayRule : applicationTable.getRules()) {
			rules.add(gatewayRule.toDomain());
		}
		return new SegmentationTable(applicationTable.getName(), rules);
	}
}
