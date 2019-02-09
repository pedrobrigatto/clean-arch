package br.com.pb.business.core;

public class SegmentationEngine {
	
	public SegmentationRule applySegmentation(Plan plan, SegmentationTable segmentationTable) {
		for (SegmentationRule rule : segmentationTable.getRules()) {
			if (rule.matches(plan)) {
				return rule;
			}
		}
		return null;
	}
}
