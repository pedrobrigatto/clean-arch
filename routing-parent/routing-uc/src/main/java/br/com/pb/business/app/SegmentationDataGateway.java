package br.com.pb.business.app;

import java.util.List;

public interface SegmentationDataGateway {
	
	GatewaySegmentationTable findTableByName(String segmentationTableName);

	List<GatewayDestinationModel> loadCandidateDestinationsByRule(String name);
}
