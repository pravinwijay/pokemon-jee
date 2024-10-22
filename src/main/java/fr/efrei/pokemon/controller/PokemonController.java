package fr.efrei.pokemon.controller;

import fr.efrei.pokemon.models.Pokemon;
import fr.efrei.pokemon.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    private final PokemonService service;

    @Autowired
    public PokemonController(PokemonService service){
        this.service = service;
    }

    // GET
    @GetMapping
    public ResponseEntity<List<Pokemon>> findAll(){
        return new ResponseEntity<> (service.findAll(), HttpStatus.OK);
    }

    // POST
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Pokemon pokemon){
        service.save(pokemon);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Pokemon pokemon){
        Pokemon pokemonAModifier = service.findById(id);
        if (pokemon == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.update(id, pokemon);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // PATCH
    @PatchMapping("/{id}")
    public ResponseEntity<?> partialUpdate(@PathVariable String id, @RequestBody Pokemon pokemon){
        Pokemon pokemonAModifier = service.findById(id);
        if (pokemon == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.partialUpdate(id, pokemon);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> findById(@PathVariable String id){
        Pokemon pokemon = service.findById(id);
        if (pokemon == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        Pokemon pokemon = service.findById(id);
        if (pokemon == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
