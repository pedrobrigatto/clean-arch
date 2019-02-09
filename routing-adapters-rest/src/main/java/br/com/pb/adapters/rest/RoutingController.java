package br.com.pb.adapters.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.pb.business.app.RouteProcessor;
import br.com.pb.business.app.RoutingInputData;
import br.com.pb.business.app.RoutingOutputData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api (value = "Routing")
public class RoutingController {
	
	private RouteProcessor routeProcessor;
	
	public RoutingController (RouteProcessor routeProcessor) {
		this.routeProcessor = routeProcessor;
	}

	@ApiOperation("Calculates the best route to the incoming call")
	@PostMapping(value = "/routing", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public RoutingDecision route(@ApiParam("The routing request") @RequestBody RoutingRequest request) {
		RoutingOutputData outcome = routeProcessor.process(new RoutingInputData(
				request.getFrom(), request.getSegmentationTableName(), request.getSegmentationAttributes()));
		return new RoutingDecision(outcome.getAlias(), outcome.getAddress());
	}

	@ApiOperation("Testing connection")
	@GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String test() {
		return "{\"Status\" : \"Server is up and running\"}";
	}
}
