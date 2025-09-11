package br.com.petshop.projeto.views;

import br.com.petshop.projeto.models.Animal;
import br.com.petshop.projeto.repositories.impl.AnimalRepositoryLista;
import br.com.petshop.projeto.repositories.impl.AnimalRepositoryVetor;
import br.com.petshop.projeto.services.AnimalService;
import br.com.petshop.projeto.utils.Validator;

import java.util.List;
import java.util.Optional;

public class AnimalView {
    private final InputHelper in = new InputHelper();
    private AnimalService service;

    public AnimalView() {
        // default repository: lista
        this.service = new AnimalService(new AnimalRepositoryLista());
    }

    public void setService(AnimalService svc) { this.service = svc; }

    public void create() {
        System.out.println("--- CADASTRAR ANIMAL ---");
        String nome = in.readLine("Nome (obrigatório)");
        if (!Validator.isNotEmpty(nome)) { System.out.println("Erro: Nome é obrigatório."); return; }

        String especie = in.readLine("Espécie (ex: Cachorro)");
        if (!Validator.isNotEmpty(especie)) { System.out.println("Erro: Espécie é obrigatória."); return; }

        String raca = in.readLine("Raça");
        int idade = in.readInt("Idade");
        if (!Validator.isNonNegativeInt(idade)) { System.out.println("Erro: Idade não pode ser negativa."); return; }

        String donoNome = in.readLine("Nome do dono (obrigatório)");
        if (!Validator.isNotEmpty(donoNome)) { System.out.println("Erro: Nome do dono obrigatório."); return; }

        String donoTel = in.readLine("Telefone do dono");
        if (!Validator.isValidPhone(donoTel)) { System.out.println("Erro: Telefone inválido."); return; }

        String donoCpf = in.readLine("CPF do dono (somente números, 11 dígitos)");
        if (!Validator.isValidCpf(donoCpf)) { System.out.println("Erro: CPF inválido."); return; }

        Animal a = new Animal(0, nome, especie, raca, idade, donoNome, donoTel, donoCpf);
        Animal saved = service.create(a);
        System.out.println("Sucesso! Animal cadastrado com ID " + saved.getId());
    }

    public void listAll() {
        System.out.println("--- LISTA DE ANIMAIS (ordenado por nome) ---");
        List<Animal> all = service.listAllSortedByNome();
        if (all.isEmpty()) { System.out.println("Nenhum registro."); return; }
        for (Animal a: all) System.out.println(a);
    }

    public void findById() {
        System.out.println("--- BUSCAR POR ID ---");
        int id = in.readInt("ID");
        Optional<Animal> o = service.findById(id);
        if (o.isPresent()) System.out.println(o.get());
        else System.out.println("Registro não encontrado para ID " + id);
    }

    public void findByNome() {
        System.out.println("--- BUSCAR POR NOME ---");
        String nome = in.readLine("Nome (ou parte do nome)");
        List<Animal> res = service.findByNome(nome);
        if (res.isEmpty()) System.out.println("Nenhum registro encontrado para: " + nome);
        else for (Animal a: res) System.out.println(a);
    }

    public void update() {
        System.out.println("--- ATUALIZAR REGISTRO ---");
        int id = in.readInt("ID do animal a atualizar");
        Optional<Animal> o = service.findById(id);
        if (!o.isPresent()) { System.out.println("Registro não encontrado."); return; }
        Animal a = o.get();
        System.out.println("Atualizando registro: " + a);
        String nome = in.readLine("Nome (" + a.getNome() + ")");
        if (Validator.isNotEmpty(nome)) a.setNome(nome);
        String especie = in.readLine("Espécie (" + a.getEspecie() + ")");
        if (Validator.isNotEmpty(especie)) a.setEspecie(especie);
        String raca = in.readLine("Raça (" + a.getRaca() + ")");
        if (Validator.isNotEmpty(raca)) a.setRaca(raca);
        String idadeStr = in.readLine("Idade (" + a.getIdade() + ")");
        if (Validator.isNotEmpty(idadeStr)) {
            try {
                int idade = Integer.parseInt(idadeStr.trim());
                if (!Validator.isNonNegativeInt(idade)) { System.out.println("Idade inválida."); return; }
                a.setIdade(idade);
            } catch (NumberFormatException e) { System.out.println("Idade inválida."); return; }
        }
        String dono = in.readLine("Nome do dono (" + a.getDonoNome() + ")");
        if (Validator.isNotEmpty(dono)) a.setDonoNome(dono);
        String tel = in.readLine("Telefone do dono (" + a.getDonoTelefone() + ")");
        if (Validator.isNotEmpty(tel)) {
            if (!Validator.isValidPhone(tel)) { System.out.println("Telefone inválido."); return; }
            a.setDonoTelefone(tel);
        }
        String cpf = in.readLine("CPF do dono (" + a.getDonoCPF() + ")");
        if (Validator.isNotEmpty(cpf)) {
            if (!Validator.isValidCpf(cpf)) { System.out.println("CPF inválido."); return; }
            a.setDonoCPF(cpf);
        }
        service.update(a);
        System.out.println("Registro atualizado com sucesso.");
    }

    public void delete() {
        System.out.println("--- REMOVER POR ID ---");
        int id = in.readInt("ID");
        boolean ok = service.delete(id);
        if (ok) System.out.println("Registro removido.");
        else System.out.println("Não encontrado para remoção.");
    }

    public void switchStorage() {
        System.out.println("--- ALTERNAR ARMAZENAMENTO ---");
        System.out.println("1 - Lista (ArrayList)");
        System.out.println("2 - Vetor (array)");
        int opt = in.readInt("Escolha");
        if (opt == 1) {
            service.setRepository(new AnimalRepositoryLista());
            System.out.println("Agora usando Lista. Dados migrados.");
        } else if (opt == 2) {
            service.setRepository(new AnimalRepositoryVetor());
            System.out.println("Agora usando Vetor. Dados migrados.");
        } else {
            System.out.println("Opção inválida.");
        }
    }
}
