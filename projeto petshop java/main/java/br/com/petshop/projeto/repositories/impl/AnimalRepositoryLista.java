package br.com.petshop.projeto.repositories.impl;

import br.com.petshop.projeto.models.Animal;
import br.com.petshop.projeto.repositories.AnimalRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AnimalRepositoryLista implements AnimalRepository {
    private final List<Animal> data = new ArrayList<>();

    @Override
    public Animal save(Animal animal) {
        // if exists, update
        if (animal.getId() != 0) {
            for (int i=0;i<data.size();i++){
                if (data.get(i).getId() == animal.getId()) {
                    data.set(i, animal);
                    return animal;
                }
            }
        } else {
            // assign id
            int next = data.stream().mapToInt(Animal::getId).max().orElse(0) + 1;
            animal.setId(next);
            data.add(animal);
            return animal;
        }
        // if id provided but not found, treat as new
        int next = data.stream().mapToInt(Animal::getId).max().orElse(0) + 1;
        animal.setId(next);
        data.add(animal);
        return animal;
    }

    @Override
    public List<Animal> findAll() {
        return new ArrayList<>(data);
    }

    @Override
    public Optional<Animal> findById(int id) {
        return data.stream().filter(a -> a.getId() == id).findFirst();
    }

    @Override
    public List<Animal> findByNome(String nome) {
        String lower = nome == null ? "" : nome.toLowerCase();
        return data.stream().filter(a -> a.getNome()!=null && a.getNome().toLowerCase().contains(lower)).collect(Collectors.toList());
    }

    @Override
    public boolean deleteById(int id) {
        return data.removeIf(a -> a.getId() == id);
    }

    @Override
    public void clear() { data.clear(); }
}
