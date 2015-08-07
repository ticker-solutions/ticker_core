package solutions.ticker.core.managers;

import solutions.ticker.core.dtos.PersonRequest;
import solutions.ticker.core.dtos.PersonResponse;

public interface IPersonManager {

	PersonResponse signOn(PersonRequest personRequest);
	
	PersonResponse getPeopleByTeam(PersonRequest personRequest);
	
}
