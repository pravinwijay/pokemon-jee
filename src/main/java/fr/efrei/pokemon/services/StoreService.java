package fr.efrei.pokemon.services;

import fr.efrei.pokemon.repositories.StoreRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.efrei.pokemon.models.Store;

import java.util.List;

@Service
public class StoreService {

    private final StoreRepository storeRepository;

    @Autowired
    public StoreService(StoreRepository storeRepository){
        this.storeRepository = storeRepository;
    }

    // SELECT * FROM Store
    public List<Store> findAll(){
        return storeRepository.findAll();
    }

    // INSERT INTO Store
    public void save(Store store){
        storeRepository.save(store);
    }

    // SELECT * FROM Store WHERE id=id
    public Store findById(String id){
        return storeRepository.findById(id).orElse(null);
    }

    // DELETE
    public void delete(String id){
        storeRepository.deleteById(id);
    }

    // UPDATE
    @Transactional
    public void update(String id, Store storeBody){
        Store storeAModifier = findById(id);
        storeAModifier.setName(storeBody.getName());
        storeAModifier.setCityName(storeBody.getCityName());
        storeRepository.save(storeAModifier);
    }
}
