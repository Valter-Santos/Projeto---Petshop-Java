package br.com.petshop.projeto.repositories.impl;

import br.com.petshop.projeto.models.Animal;
import br.com.petshop.projeto.repositories.AnimalRepository;
import java.util.*;

public class AnimalRepositoryLista implements AnimalRepository {
    private final List<Animal> storage = new ArrayList<>();
    private int sequence = 1;


    public Animal save(Animal animal) {
        if (animal.getId() == 0) {
            animal.setId(nextId());
            storage.add(animal);
            return animal;
        }
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getId() == animal.getId()) {
                storage.set(i, animal);
                return animal;
            }
        }
        storage.add(animal);
        return animal;
    }


    public Optional<Animal> findById(int id) {
        return storage.stream().filter(a -> a.getId() == id).findFirst();
    }


    public Optional<Animal> findByNome(String nome) {
        return storage.stream().filter(a -> a.getNome().equalsIgnoreCase(nome)).findFirst();
    }


    public List<Animal> findAll() { return new ArrayList<>(storage); }


    public boolean deleteById(int id) { return storage.removeIf(a -> a.getId() == id); }


    public List<Animal> snapshot() { return findAll(); }


    public void replaceAll(List<Animal> animais) {
        storage.clear();
        storage.addAll(animais);
        sequence = animais.stream().mapToInt(Animal::getId).max().orElse(0) + 1;
    }


    public int nextId() { return sequence++; }
}
