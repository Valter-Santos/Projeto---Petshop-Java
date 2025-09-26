package br.com.petshop.projeto.repositories.impl;

import br.com.petshop.projeto.models.Animal;
import br.com.petshop.projeto.repositories.AnimalRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AnimalRepositoryVetor implements AnimalRepository {
    private Animal[] arr;
    private int size = 0;

    public AnimalRepositoryVetor() { this(10); }
    public AnimalRepositoryVetor(int capacity) { arr = new Animal[capacity]; }

    private void ensureCapacity() {
        if (size >= arr.length) {
            Animal[] n = new Animal[arr.length * 2];
            System.arraycopy(arr, 0, n, 0, arr.length);
            arr = n;
        }
    }

    @Override
    public Animal save(Animal animal) {
        if (animal.getId() != 0) {
            for (int i=0;i<size;i++){
                if (arr[i].getId() == animal.getId()) {
                    arr[i] = animal;
                    return animal;
                }
            }
        }

        ensureCapacity();
        int nextId = 1;
        for (int i=0;i<size;i++) if (arr[i].getId() >= nextId) nextId = arr[i].getId() + 1;
        animal.setId(nextId);
        arr[size++] = animal;
        return animal;
    }

    @Override
    public List<Animal> findAll() {
        List<Animal> res = new ArrayList<>();
        for (int i=0;i<size;i++) res.add(arr[i]);
        return res;
    }

    @Override
    public Optional<Animal> findById(int id) {
        for (int i=0;i<size;i++) if (arr[i].getId() == id) return Optional.of(arr[i]);
        return Optional.empty();
    }

    @Override
    public List<Animal> findByNome(String nome) {
        String lower = nome == null ? "" : nome.toLowerCase();
        List<Animal> res = new ArrayList<>();
        for (int i=0;i<size;i++) {
            if (arr[i].getNome()!=null && arr[i].getNome().toLowerCase().contains(lower)) res.add(arr[i]);
        }
        return res;
    }

    @Override
    public boolean deleteById(int id) {
        for (int i=0;i<size;i++){
            if (arr[i].getId() == id) {
                for (int j=i;j<size-1;j++) arr[j]=arr[j+1];
                arr[--size]=null;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i=0;i<size;i++) arr[i]=null;
        size=0;
    }
}
