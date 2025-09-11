package br.com.petshop.projeto.repositories;

import br.com.petshop.projeto.models.Animal;
import java.util.List;
import java.util.Optional;

public interface AnimalRepository {
    Animal save(Animal animal); // create or update (if id exists)
    List<Animal> findAll(); // unsorted or sorted by service
    Optional<Animal> findById(int id);
    List<Animal> findByNome(String nome);
    boolean deleteById(int id);
    void clear();
}
