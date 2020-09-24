package com.postgres.poc.locationservicepostgres.dao;

import com.postgres.poc.locationservicepostgres.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.cache.Cache;
import java.util.List;

@Repository
public interface CountryRepository extends CrudRepository<Country, String> {

    public List<Country> findByPopulationGreaterThanEqualOrderByPopulationDesc(int population);

}
