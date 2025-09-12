package br.com.petshop.projeto.repositories;

import br.com.petshop.projeto.models.Animal;
import java.util.List;
import java.util.Optional;

public interface AnimalRepository {
    Animal save(Animal animal);
    Optional<Animal> findById(int id);
    Optional<Animal> findByNome(String nome);
    List<Animal> findAll();
    boolean deleteById(int id);
    List<Animal> snapshot();
    void replaceAll(List<Animal> animais);
    int nextId();
}
