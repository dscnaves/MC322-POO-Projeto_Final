# MC322-POO-Projeto_Final
Este repositório é composto do projeto final realizado na matéria de Programação Orientada à Objeto do Instituto de Computação da Faculdade Estadual de Campinas no primeiro semestre de 2025

# Sistema de Treinos Físicos

Este projeto é um sistema de gerenciamento de treinos físicos com funcionalidades para alunos e professores. Professores podem criar e atribuir treinos, acompanhar o progresso e responder aos comentários dos alunos. Alunos podem registrar progresso, comentar sobre os treinos e visualizar seu histórico de atividades.

## Diagrama de Classes (UML)

```mermaid
classDiagram
    class Usuario {
        - String nome
        - String email
        - String senha
        + String getNome()
        + String getEmail()
        + String getSenha()
        + void mostrarMenuPrincipal()
    }

    class Professor {
        - List~Aluno~ alunos
        - List~Treino~ treinosCriados
        + void criarTreino()
        + void atribuirTreino(Aluno, Treino)
        + void verComentarios()
        + void responderComentario()
        + void mostrarMenuPrincipal()
    }

    class Aluno {
        - List~Treino~ treinosRecebidos
        - List~ProgressoTreino~ progresso
        + void registrarProgresso(ProgressoTreino)
        + void comentarTreino(Treino, String)
        + void visualizarHistorico()
        + void mostrarMenuPrincipal()
    }

    class Treino {
        - String nome
        - List~Exercicio~ exercicios
        - EnumDificuldade dificuldade
        + void adicionarExercicio(Exercicio)
        + String toString()
    }

    class Exercicio {
        - String nome
        - int repeticoes
        - int series
        - int duracaoSegundos
    }

    class ProgressoTreino {
        - Treino treino
        - boolean concluido
        - double percentualConcluido
        - String observacoes
        + Treino getTreino()
    }

    class Comentario {
        - Usuario autor
        - String texto
        - Date data
    }

    class Sistema {
        + static List~Usuario~ usuarios
        + void login(String, String)
        + void salvarDados()
        + void carregarDados()
    }

    class EnumDificuldade {
        FACIL
        MEDIO
        DIFICIL
    }

    Usuario <|-- Professor
    Usuario <|-- Aluno
    Professor --> Treino : creates
    Professor --> Aluno : teaches
    Aluno --> Treino : assigned
    Aluno --> ProgressoTreino : has progress
    ProgressoTreino --> Treino : refers to
    Treino --> Exercicio : composed of
    Treino --> Comentario : has
    Comentario --> Usuario : author
    Treino --> EnumDificuldade : difficulty
```

