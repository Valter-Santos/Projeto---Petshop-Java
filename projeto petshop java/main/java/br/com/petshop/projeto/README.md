# Petshop Console - Projeto Java (MVC)

## Tema
Cadastro de animais de um petshop. Cada animal possui: id, nome, espécie, raça, idade, nome/telefone/CPF do dono.

## Como executar
Compile com `javac` apontando para a raiz do pacote `br.com.petshop.projeto`, por exemplo:

```bash
cd src/main/java
javac br/com/petshop/projeto/**/*.java
java br.com.petshop.projeto.Main
```

Ou use IDE (IntelliJ/Eclipse) importando como projeto Java simples.

## MVC aplicado
- Models: `models/Animal.java`
- Repositories (DAO): `repositories/*` define interface e duas implementações (Lista e Vetor)
- Services: `services/AnimalService.java` contém lógica de negócio (listagem ordenada, migração)
- Views: `views/*` implementam interação via console (Menu, AnimalView, InputHelper)

## Interface para acesso a dados
`AnimalRepository` define operações necessárias. Assim o serviço e a view podem trocar a implementação (vetor ↔ lista) sem alterar lógica de negócio.

## Migração entre implementações
`AnimalService.setRepository(...)` recebe nova implementação e migra registros existentes, reatribuindo ids pela nova implementação.

## Validações e Regras de Negócio
- Campos obrigatórios não podem estar vazios (nome, espécie, dono).
- Idade deve ser inteiro não-negativo.
- CPF: deve conter 11 dígitos numéricos (validação superficial).
- Telefone: verificação simples de formato (mínimo 6 caracteres numéricos/formatados).
- Mensagens claras de erro e sucesso em cada operação.

## Estrutura de pastas
```
projeto-petshop-finished/
└─ src/main/java/br/com/petshop/projeto/
   ├─ Main.java
   ├─ models/
   ├─ repositories/
   ├─ services/
   ├─ views/
   └─ utils/
```

## Observações
- Implementação focada em clareza e em atender aos requisitos da instrução.
- Validação de CPF aqui é básica (apenas formato). Pode-se adicionar algoritmo de validação dos dígitos verificadores se necessário.
