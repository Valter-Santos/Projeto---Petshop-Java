package br.com.petshop.projeto;

import br.com.petshop.projeto.repositories.impl.AnimalRepositoryLista;
import br.com.petshop.projeto.services.AnimalService;
import br.com.petshop.projeto.views.Menu;

public class Main {
    public static void main(String[] args) {
        br.com.petshop.projeto.AnimalService service = new AnimalService(new AnimalRepositoryLista());
        new Menu(service).loop();
    }
}
