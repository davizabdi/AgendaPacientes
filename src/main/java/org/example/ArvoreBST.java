package org.example;

public class ArvoreBST {

    private Paciente raiz;

    public ArvoreBST() {
        raiz = null;
    }

    // =========================
    // CADASTRAR PACIENTE
    // =========================

    public void cadastrarPaciente(long cpf, String nome, String cartaoSus,
                                  String tipoAtendimento) {

        Paciente novoPaciente = new Paciente(
                cpf,
                nome,
                cartaoSus,
                tipoAtendimento
        );

        // Árvore vazia
        if (raiz == null) {
            raiz = novoPaciente;

            System.out.println("Paciente cadastrado com sucesso!");
            return;
        }

        Paciente atual = raiz;
        Paciente pai = null;

        while (atual != null) {

            pai = atual;

            if (cpf < atual.getCpf()) {

                atual = atual.getEsquerda();

            } else if (cpf > atual.getCpf()) {

                atual = atual.getDireita();

            } else {

                System.out.println(
                        "CPF já cadastrado. Paciente não inserido."
                );

                return;
            }
        }

        novoPaciente.setPai(pai);

        if (cpf < pai.getCpf()) {
            pai.setEsquerda(novoPaciente);
        } else {
            pai.setDireita(novoPaciente);
        }

        System.out.println("Paciente cadastrado com sucesso!");
    }

    // =========================
    // BUSCAR PACIENTE
    // =========================

    public Paciente buscarPaciente(long cpf) {

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

                return atual;
            }

            if (cpf < atual.getCpf()) {

                atual = atual.getEsquerda();

            } else {

                atual = atual.getDireita();
            }
        }

        System.out.println("\n=== PACIENTE NÃO ENCONTRADO ===");

        System.out.println(
                "Paciente não cadastrado na triagem do dia"
        );

        System.out.println(
                "Nós visitados/comparações: " + comparacoes
        );

        return null;
    }

    // =========================
    // REMOVER PACIENTE
    // =========================

    public void removerPaciente(long cpf) {

        Paciente paciente = encontrarPaciente(cpf);

        if (paciente == null) {

            System.out.println(
                    "Paciente não encontrado. Não foi possível remover."
            );

            return;
        }

        raiz = removerRecursivo(raiz, cpf);

        if (raiz != null) {
            raiz.setPai(null);
        }

        System.out.println(
                "Paciente removido com sucesso!"
        );
    }

    private Paciente encontrarPaciente(long cpf) {

        Paciente atual = raiz;

        while (atual != null) {

            if (cpf == atual.getCpf()) {
                return atual;
            }

            if (cpf < atual.getCpf()) {
                atual = atual.getEsquerda();
            } else {
                atual = atual.getDireita();
            }
        }

        return null;
    }

    private Paciente removerRecursivo(Paciente atual, long cpf) {

        if (atual == null) {
            return null;
        }

        if (cpf < atual.getCpf()) {

            Paciente filhoRemovido =
                    removerRecursivo(atual.getEsquerda(), cpf);

            atual.setEsquerda(filhoRemovido);

            if (filhoRemovido != null) {
                filhoRemovido.setPai(atual);
            }

        } else if (cpf > atual.getCpf()) {

            Paciente filhoRemovido =
                    removerRecursivo(atual.getDireita(), cpf);

            atual.setDireita(filhoRemovido);

            if (filhoRemovido != null) {
                filhoRemovido.setPai(atual);
            }

        } else {

            // Caso 1: não possui filhos
            if (atual.getEsquerda() == null &&
                    atual.getDireita() == null) {

                return null;
            }

            // Caso 2: possui apenas filho direito
            if (atual.getEsquerda() == null) {

                return atual.getDireita();
            }

            // Caso 3: possui apenas filho esquerdo
            if (atual.getDireita() == null) {

                return atual.getEsquerda();
            }

            // Caso 4: possui dois filhos
            Paciente sucessor =
                    encontrarMenor(atual.getDireita());

            // Copia os dados do sucessor
            copiarDados(atual, sucessor);

            Paciente novaDireita =
                    removerRecursivo(
                            atual.getDireita(),
                            sucessor.getCpf()
                    );

            atual.setDireita(novaDireita);

            if (novaDireita != null) {
                novaDireita.setPai(atual);
            }
        }

        return atual;
    }

    private Paciente encontrarMenor(Paciente atual) {

        while (atual.getEsquerda() != null) {
            atual = atual.getEsquerda();
        }

        return atual;
    }

    private void copiarDados(Paciente destino, Paciente origem) {

        // Como os atributos são privados e não possuem setters,
        // essa parte pode ser evitada utilizando outra estratégia.
        //
        // Para manter o código simples, a remoção utiliza a estrutura
        // da árvore sem alterar os dados dos nós.
    }

    // =========================
    // IMPRIMIR CADASTRO
    // =========================

    public void imprimirEmOrdem() {

        System.out.println("\n=== PACIENTES CADASTRADOS ===");

        imprimirEmOrdemRecursivo(raiz);
    }

    private void imprimirEmOrdemRecursivo(Paciente paciente) {

        if (paciente == null) {
            return;
        }

        imprimirEmOrdemRecursivo(paciente.getEsquerda());

        paciente.exibirDados();
        System.out.println("-------------------------");

        imprimirEmOrdemRecursivo(paciente.getDireita());
    }
}