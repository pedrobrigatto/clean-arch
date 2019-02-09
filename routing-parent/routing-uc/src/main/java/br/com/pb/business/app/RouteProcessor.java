package br.com.pb.business.app;

import java.io.Serializable;

import br.com.pb.business.core.AliasedDestination;

/**
 * Entry point of the use case responsible for determining the best {@link AliasedDestination} to 
 * handle an incoming call.
 */
public interface RouteProcessor extends Serializable {
	
	RoutingOutputData process(RoutingInputData request);
}
