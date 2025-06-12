# MC322-POO-Projeto_Final
Este repositório é composto do projeto final realizado na matéria de Programação Orientada à Objeto do Instituto de Computação da Faculdade Estadual de Campinas no primeiro semestre de 2025

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
        - Map~Treino, ProgressoTreino~ progresso
        + void registrarProgresso(Treino, ProgressoTreino)
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
        - boolean concluido
        - double percentualConcluido
        - String observacoes
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
    Aluno --> ProgressoTreino : tracks
    Treino --> Exercicio : composed of
    Treino --> Comentario : has
    Comentario --> Usuario : author
    Treino --> EnumDificuldade : difficulty

