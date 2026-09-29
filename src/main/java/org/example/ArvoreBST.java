package org.example;

public class ArvoreBST {

    private Paciente raiz;

    public ArvoreBST() {
        raiz = null;
    }

    // Cadastro de paciente na BST
    public void cadastrarPaciente(long cpf, String nome, String cartaoSus,
                                  String tipoAtendimento) {

        Paciente novoPaciente = new Paciente(
                cpf,
                nome,
                cartaoSus,
                tipoAtendimento
        );

        // Primeiro paciente da árvore
        if (raiz == null) {
            raiz = novoPaciente;

            System.out.println("Paciente cadastrado com sucesso!");
            return;
        }

        Paciente atual = raiz;
        Paciente pai = null;

        while (atual != null) {

            pai = atual;

            // CPF menor -> esquerda
            if (cpf < atual.getCpf()) {

                atual = atual.getEsquerda();

                // CPF maior -> direita
            } else if (cpf > atual.getCpf()) {

                atual = atual.getDireita();

                // CPF igual -> duplicado
            } else {

                System.out.println(
                        "CPF já cadastrado. Paciente não inserido."
                );

                return;
            }
        }

        // Define o pai do novo paciente
        novoPaciente.setPai(pai);

        // Decide se será filho esquerdo ou direito
        if (cpf < pai.getCpf()) {
            pai.setEsquerda(novoPaciente);
        } else {
            pai.setDireita(novoPaciente);
        }

        System.out.println("Paciente cadastrado com sucesso!");
    }

    // Busca de paciente pelo CPF
    public void buscarPaciente(long cpf) {

        Paciente atual = raiz;
        int comparacoes = 0;

        while (atual != null) {

            comparacoes++;

            if (cpf == atual.getCpf()) {

                System.out.println("\n=== PACIENTE ENCONTRADO ===");
                atual.exibirDados();

                System.out.println(
                        "Nós visitados/comparações: " + comparacoes
                );

                return;
            }

            // CPF menor -> procura na esquerda
            if (cpf < atual.getCpf()) {
                atual = atual.getEsquerda();

                // CPF maior -> procura na direita
            } else {
                atual = atual.getDireita();
            }
        }

        System.out.println("\n=== PACIENTE NÃO ENCONTRADO ===");
        System.out.println("Paciente não cadastrado na triagem do dia");
        System.out.println(
                "Nós visitados/comparações: " + comparacoes
        );
    }
}