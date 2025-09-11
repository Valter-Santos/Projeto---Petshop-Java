package br.com.petshop.projeto.models;

import java.util.Objects;

public class Animal {
    private int id;
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private String nomeDono;
    private String telefoneDono;
    private String cpfDono;

    public Animal() {}

    public Animal(int id, String nome, String especie, String raca, int idade, String nomeDono, String telefoneDono, String cpfDono) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.nomeDono = nomeDono;
        this.telefoneDono = telefoneDono;
        this.cpfDono = cpfDono;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public String getRaca() { return raca; }
    public void setRaca(String raca) { this.raca = raca; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getNomeDono() { return nomeDono; }
    public void setNomeDono(String nomeDono) { this.nomeDono = nomeDono; }

    public String getTelefoneDono() { return telefoneDono; }
    public void setTelefoneDono(String telefoneDono) { this.telefoneDono = telefoneDono; }

    public String getCpfDono() { return cpfDono; }
    public void setCpfDono(String cpfDono) { this.cpfDono = cpfDono; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return id == animal.id;
    }


    public int hashCode() { return Objects.hash(id); }


    public String toString() {
        return String.format("[ID:%d] %s (%s - %s) | Idade:%d | Dono:%s | Tel:%s | CPF:%s",
            id, nome, especie, raca, idade, nomeDono, telefoneDono, cpfDono);
    }
}
