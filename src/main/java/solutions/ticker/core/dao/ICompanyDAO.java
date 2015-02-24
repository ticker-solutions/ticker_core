package solutions.ticker.core.dao;

import java.util.List;

import solutions.ticker.core.db.entities.CompanyEntity;

public interface ICompanyDAO {

	List<CompanyEntity> getCompanies();
}
