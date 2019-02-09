package br.com.pb.routing.persistence.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.pb.business.app.GatewayDestinationModel;
import br.com.pb.business.app.GatewaySegmentationRule;
import br.com.pb.business.app.GatewaySegmentationTable;
import br.com.pb.business.app.SegmentationDataGateway;

public class SegmentationDataGatewayImpl implements SegmentationDataGateway {
	
	public SegmentationDataGatewayImpl () {}

	public List<GatewaySegmentationRule> findRulesBySegmentationTableName(String name) {
		// there should be an association with a DAO responsible for fetching the rules in whatever
		// data store used by the solution (relational DB, data grid, noSQL DB, flat files ...)
		// Here, we're simplifying and putting everything in memory
		return createSampleRules();
	}
	
	public GatewaySegmentationTable findTableByName(String segmentationTableName) {
		GatewaySegmentationTable segmentationTable = new GatewaySegmentationTable("st-01", "st-01");
		segmentationTable.setRules(createSampleRules());
		return segmentationTable;
	}
	
	public List<GatewayDestinationModel> loadCandidateDestinationsByRule(String name) {
		List<DestinationDTO> dtos = DestinationDAO.create().findAll();
		return prepare(dtos);
	}
	
	private List<GatewayDestinationModel> prepare (List<DestinationDTO> dtos) {
		List<GatewayDestinationModel> destinations = new ArrayList<>();
		for (DestinationDTO dto : dtos) {
			destinations.add(new GatewayDestinationModel(dto.getId(), 
					dto.getAlias(), dto.getAddress(), dto.getName(), dto.getType()));
		}
		return destinations;
	}
	
	private List<GatewaySegmentationRule> createSampleRules() {
		GatewayDestinationModel destination1 = new GatewayDestinationModel(
				"123", "default", "123123", "Dest-01", "LIVE_AGENT");
		GatewayDestinationModel destination2 = new GatewayDestinationModel(
				"234", "alt", "345345", "Dest-02", "LIVE_AGENT");
		
		GatewaySegmentationRule rule1 = new GatewaySegmentationRule("r1", "Premium").
				addDestination(destination1).addDestination(destination2);
		GatewaySegmentationRule rule2 = new GatewaySegmentationRule("r2", "Regular").addDestination(destination2);
		return Arrays.asList(rule1, rule2);
	}
}
