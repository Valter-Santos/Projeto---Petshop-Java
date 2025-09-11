package br.com.petshop.projeto.views;

import br.com.petshop.projeto.services.AnimalService;
import br.com.petshop.projeto.repositories.impl.AnimalRepositoryLista;
import br.com.petshop.projeto.views.InputHelper;

public class Menu {
    private final AnimalView view = new AnimalView();

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\n=== PETSHOP - MENU ===");
            System.out.println("1 - Cadastrar animal");
            System.out.println("2 - Listar todos");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Buscar por Nome");
            System.out.println("5 - Atualizar");
            System.out.println("6 - Remover por ID");
            System.out.println("7 - Alternar armazenamento (Lista ↔ Vetor)");
            System.out.println("0 - Sair");
            InputHelper in = new InputHelper();
            int opt = in.readInt("Escolha");

            switch (opt) {
                case 1: view.create(); break;
                case 2: view.listAll(); break;
                case 3: view.findById(); break;
                case 4: view.findByNome(); break;
                case 5: view.update(); break;
                case 6: view.delete(); break;
                case 7: view.switchStorage(); break;
                case 0: running = false; System.out.println("Saindo..."); break;
                default: System.out.println("Opção inválida.");
            }
        }
    }
}
