package fr.efrei.pokemon.services;

import fr.efrei.pokemon.models.City;
import fr.efrei.pokemon.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }

    // SELECT * FROM City
    public List<City> findAll(){
        return cityRepository.findAll();
    }

    // INSERT INTO City
    public void save(City city){
        cityRepository.save(city);
    }

    // SELECT * FROM City WHERE id=id
    public City findById(String id){
        return cityRepository.findById(id).orElse(null);
    }

    // DELETE FROM City WHERE id=id
    public void delete(String id){
        cityRepository.deleteById(id);
    }

    // UPDATE
    public void update(String id, City cityBody){
        City cityAModifier = findById(id);
        cityAModifier.setName(cityBody.getName());
        cityRepository.save(cityAModifier);
    }
}
