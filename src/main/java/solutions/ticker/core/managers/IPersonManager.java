package solutions.ticker.core.managers;

import solutions.ticker.core.dtos.PersonRequestDTO;
import solutions.ticker.core.dtos.PersonResponseDTO;

public interface IPersonManager {

	PersonResponseDTO signOn(PersonRequestDTO personDTO);
	
}
