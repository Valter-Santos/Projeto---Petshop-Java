package br.com.petshop.projeto.models;

public class Animal {
    private int id;
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private String donoNome;
    private String donoTelefone;
    private String donoCPF;

    public Animal() {}

    public Animal(int id, String nome, String especie, String raca, int idade, String donoNome, String donoTelefone, String donoCPF) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.donoNome = donoNome;
        this.donoTelefone = donoTelefone;
        this.donoCPF = donoCPF;
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

    public String getDonoNome() { return donoNome; }
    public void setDonoNome(String donoNome) { this.donoNome = donoNome; }

    public String getDonoTelefone() { return donoTelefone; }
    public void setDonoTelefone(String donoTelefone) { this.donoTelefone = donoTelefone; }

    public String getDonoCPF() { return donoCPF; }
    public void setDonoCPF(String donoCPF) { this.donoCPF = donoCPF; }


    public String toString() {
        return String.format("ID: %d | Nome: %s | Espécie: %s | Raça: %s | Idade: %d | Dono: %s | Telefone: %s | CPF: %s",
            id, nome, especie, raca, idade, donoNome, donoTelefone, donoCPF);
    }
}
