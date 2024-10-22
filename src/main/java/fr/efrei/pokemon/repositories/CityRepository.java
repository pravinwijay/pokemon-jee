package fr.efrei.pokemon.repositories;

import fr.efrei.pokemon.models.City;
import fr.efrei.pokemon.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, String> {
}
