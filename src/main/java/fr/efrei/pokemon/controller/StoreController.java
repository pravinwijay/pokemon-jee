package fr.efrei.pokemon.controller;

import fr.efrei.pokemon.models.Store;
import fr.efrei.pokemon.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreController {

    private final StoreService service;

    @Autowired
    public StoreController(StoreService service){
        this.service = service;
    }

    // GET all stores
    @GetMapping
    public ResponseEntity<List<Store>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    // POST
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Store store){
        service.save(store);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // GET By id
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id){
        Store store = service.findById(id);
        if(store==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(service.findById(id),HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        Store store = service.findById(id);
        if(store==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody Store store){
        Store storeAModifier = service.findById(id);
        if(store == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.update(id, store);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
