package fr.efrei.pokemon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.efrei.pokemon.models.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, String> {
}
