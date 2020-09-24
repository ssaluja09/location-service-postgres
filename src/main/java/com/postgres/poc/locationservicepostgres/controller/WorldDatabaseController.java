package com.postgres.poc.locationservicepostgres.controller;

import com.postgres.poc.locationservicepostgres.model.City;
import com.postgres.poc.locationservicepostgres.model.CityDTO;
import com.postgres.poc.locationservicepostgres.model.CountryDTO;
import com.postgres.poc.locationservicepostgres.service.WorldDatabaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorldDatabaseController {

    Logger logger = LoggerFactory.getLogger(WorldDatabaseController.class);

    @Autowired
    WorldDatabaseService worldDatabaseService;

    @GetMapping("/api/countries")
    public List<CountryDTO> getCountriesByPopulation(@RequestParam (value = "population", required = true) int population) {
        logger.info("Get All Countries By Pop Called!!");
        return worldDatabaseService.getCountriesByPopulation(population);
    }

    @GetMapping("/api/cities")
    public List<CityDTO> getCitiesByPopulation(@RequestParam (value = "population", required = true) int population) {
        logger.info("Get All Cities By Pop Called!!");
        return worldDatabaseService.getCitiesByPopulation(population);
    }

    /*@GetMapping("/api/cities/mostPopulated")
    public List<City> getMostPopulatedCities(@RequestParam (value = "limit", required = false) Integer limit) {
        logger.info("Get Most Populated Cities Called!!");
        return worldDatabaseService.getMostPopulatedCities(limit);
    }*/

    @PutMapping("/api/cities/{id}")
    public CityDTO updateCityPopulation(@PathVariable Integer id, @RequestBody CityDTO cityDTO) {
        logger.info("Update City By ID Called!!");
        return worldDatabaseService.updateCityPopulation(id, cityDTO.getPopulation());
    }

    @GetMapping("/api/cities/{id}")
    public CityDTO getCityPopulation(@PathVariable int id) {
        logger.info("Get City By ID Called!!");
        return worldDatabaseService.getCityById(id);
    }
}
