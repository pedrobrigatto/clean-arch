package br.com.pb.business.app;

import java.util.ArrayList;
import java.util.List;

import br.com.pb.business.core.AliasedDestination;
import br.com.pb.business.core.Plan;
import br.com.pb.business.core.RoutingEngine;
import br.com.pb.business.core.SegmentationEngine;
import br.com.pb.business.core.SegmentationRule;

/**
 * This is the use case responsible for routing a call based on some inputs provided by either a real
 * customer or another system that makes use of the routing mechanism to better decide the next leg
 * in a Contact Center solution.
 * 
 * Steps for this UC include:
 * 
 * <ol>
 *   <li>Based on the segmentation table name, find it and load its rules</li>
 *   <li>Determine the matching rule</li>
 *   <li>Load the list of candidate destinations for the selected rule</li>
 *   <li>Apply the strategy of the routing engine based on the customer profile</li>
 *   <li>Return the best destination to handle the incoming call</li>
 * </ol>
 */
public class RoutingUC implements RouteProcessor {

	private static final long serialVersionUID = -7572035431043545262L;

	private SegmentationDataGateway segmentationDataGateway;
	private MetricsDataGateway metricsGateway;

	public RoutingUC (SegmentationDataGateway segmentationDataGateway, MetricsDataGateway metricsGateway) {
		this.segmentationDataGateway = segmentationDataGateway;
		this.metricsGateway = metricsGateway;
	}

	@Override
	public RoutingOutputData process(RoutingInputData request) {
		
		Plan customerPlan = Plan.from((String) request.getAttribute(RoutingInputData.CUSTOMER_PLAN));
		
		// Segmenting the call ...
		String segmentationTableName = (String) request.getAttribute(RoutingInputData.SEGMENTATION_TABLE);
		GatewaySegmentationTable segmentationTable = 
				segmentationDataGateway.findTableByName(segmentationTableName);
		
		// Loading live metrics to all destinations associated to the rules ...
		loadLiveMetrics(segmentationTable);
		
		SegmentationEngine segmentationEngine = new SegmentationEngine();
		SegmentationRule segmentationRule = 
				segmentationEngine.applySegmentation(customerPlan, 
						SegmentationTableConverter.convert(segmentationTable));
		
		List<GatewayDestinationModel> candidateDestinations = 
				segmentationDataGateway.loadCandidateDestinationsByRule(segmentationRule.getName());
		
		// Selecting the actual destination to better address the call leg ...
		AliasedDestination selectedDestination = null;
		selectedDestination = candidateDestinations.size() == 1 ?
				candidateDestinations.get(0).toDomain() :
					new RoutingEngine(customerPlan).route(convertToAliasedDestinations(candidateDestinations));
		
		// Finally, return the best destination available at the time of the incoming request.
		return new RoutingOutputData(selectedDestination.getAlias(), selectedDestination.getDestination().getUrl()).
				addContext(RoutingOutputData.DESTINATION_ALIAS, selectedDestination.getAlias());
	}

	private void loadLiveMetrics(GatewaySegmentationTable segmentationTable) {
		for (GatewaySegmentationRule rule : segmentationTable.getRules()) {
			for (GatewayDestinationModel destination : rule.getDestinations()) {
				destination.setMetrics(metricsGateway.loadMetricsToDestination(destination.getName()));
			}
		}
	}

	private List<AliasedDestination> convertToAliasedDestinations(List<GatewayDestinationModel> candidateDestinations) {
		List<AliasedDestination> convertedList = new ArrayList<>(); 
		for (GatewayDestinationModel destination : candidateDestinations) {
			convertedList.add(destination.toDomain());
		}
		return convertedList;
	}
}
