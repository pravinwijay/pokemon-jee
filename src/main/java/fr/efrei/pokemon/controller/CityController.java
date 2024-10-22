package fr.efrei.pokemon.controller;

import fr.efrei.pokemon.models.City;
import fr.efrei.pokemon.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityService service;

    @Autowired
    public CityController(CityService service){
        this.service = service;
    }

    // GET all cities
    @GetMapping
    public ResponseEntity<List<City>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    // POST
    @PostMapping
    public ResponseEntity<?> create(@RequestBody City city){
        service.save(city);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // GET by id
    @GetMapping("/{id}")
    public ResponseEntity<City> findById(@PathVariable String id){
        City city = service.findById(id);
        if(city == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service.findById(id),HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        City city = service.findById(id);
        if(city == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody City city){
        City cityAModifier = service.findById(id);
        if(city == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.update(id, city);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
