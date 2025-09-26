package br.com.petshop.projeto.services;

import br.com.petshop.projeto.models.Animal;
import br.com.petshop.projeto.repositories.AnimalRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class AnimalService {
    private AnimalRepository repository;

    public AnimalService(AnimalRepository repository) {
        this.repository = repository;
    }

    public void setRepository(AnimalRepository repository) {
        List<Animal> current = this.repository.findAll();
        this.repository = repository;
        this.repository.clear();
        for (Animal a: current) {
            a.setId(0);
            this.repository.save(a);
        }
    }

    public Animal create(Animal animal) {
        return repository.save(animal);
    }

    public Optional<Animal> findById(int id) {
        return repository.findById(id);
    }

    public List<Animal> listAllSortedByNome() {
        List<Animal> all = repository.findAll();
        Collections.sort(all, Comparator.comparing(a -> a.getNome() == null ? "" : a.getNome().toLowerCase()));
        return all;
    }

    public List<Animal> findByNome(String nome) {
        return repository.findByNome(nome);
    }

    public boolean delete(int id) {
        return repository.deleteById(id);
    }

    public Animal update(Animal animal) {
        return repository.save(animal);
    }
}
