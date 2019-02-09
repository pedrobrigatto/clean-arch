package br.com.pb.routing.persistence.mock;

import java.util.Arrays;
import java.util.List;

class DestinationDAO {
	
	static DestinationDAO create() {
		return new DestinationDAO();
	}
	
	public List<DestinationDTO> findAll() {
		return Arrays.asList(
				new DestinationDTO("main", "1", "D1", "3444-4444", "LIVE_AGENT"),
				new DestinationDTO("alternative", "1", "D1", "3444-4445", "LIVE_AGENT"),
				new DestinationDTO("alternative", "1", "D1", "3444-4446", "LIVE_AGENT"),
				new DestinationDTO("alternative", "1", "D1", "3444-4447", "LIVE_AGENT"));
	}
}
