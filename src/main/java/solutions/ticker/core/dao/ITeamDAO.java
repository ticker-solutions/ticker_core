package solutions.ticker.core.dao;

import java.util.List;

import solutions.ticker.core.db.entities.TeamEntity;

public interface ITeamDAO {

	List<TeamEntity> getTeams();
	
}
