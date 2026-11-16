package arvoreBst;

public class ArvoreBST {

    private Paciente raiz;

    public ArvoreBST() {
        raiz = null;
    }

    // =====================================================
    // CADASTRAR PACIENTE
    // =====================================================

    public void cadastrarPaciente(long cpf, String nome, String cartaoSus,
                                  String tipoAtendimento) {

        Paciente novoPaciente = new Paciente(
                cpf,
                nome,
                cartaoSus,
                tipoAtendimento
        );

        // Se a árvore estiver vazia
        if (raiz == null) {

            raiz = novoPaciente;

            System.out.println("Paciente cadastrado com sucesso!");
            return;
        }

        Paciente atual = raiz;
        Paciente pai = null;

        // Percorre a árvore procurando a posição correta
        while (atual != null) {

            pai = atual;

            // CPF menor -> esquerda
            if (cpf < atual.getCpf()) {

                atual = atual.getEsquerda();

                // CPF maior -> direita
            } else if (cpf > atual.getCpf()) {

                atual = atual.getDireita();

                // CPF igual -> não permite duplicação
            } else {

                System.out.println(
                        "CPF já cadastrado. Paciente não inserido."
                );

                return;
            }
        }

        // Define o pai do novo paciente
        novoPaciente.setPai(pai);

        // Define se será filho esquerdo ou direito
        if (cpf < pai.getCpf()) {

            pai.setEsquerda(novoPaciente);

        } else {

            pai.setDireita(novoPaciente);
        }

        System.out.println("Paciente cadastrado com sucesso!");
    }


    // =====================================================
    // BUSCAR PACIENTE
    // =====================================================

    public Paciente buscarPaciente(long cpf) {

        Paciente atual = raiz;

        int comparacoes = 0;

        while (atual != null) {

            comparacoes++;

            // CPF encontrado
            if (cpf == atual.getCpf()) {

                System.out.println("\n=== PACIENTE ENCONTRADO ===");

                atual.exibirDados();

                System.out.println(
                        "Nós visitados/comparações: " + comparacoes
                );

                return atual;
            }

            // CPF menor -> procura na esquerda
            if (cpf < atual.getCpf()) {

                atual = atual.getEsquerda();

                // CPF maior -> procura na direita
            } else {

                atual = atual.getDireita();
            }
        }

        // Chegou em null -> paciente não cadastrado
        System.out.println("\n=== PACIENTE NÃO ENCONTRADO ===");

        System.out.println(
                "Paciente não cadastrado na triagem do dia"
        );

        System.out.println(
                "Nós visitados/comparações: " + comparacoes
        );

        return null;
    }


    // =====================================================
    // BUSCAR SEM EXIBIR MENSAGEM
    // Usado internamente pela remoção
    // =====================================================

    private Paciente buscarSemMensagem(long cpf) {

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


    // =====================================================
    // REMOVER PACIENTE
    // =====================================================

    public void removerPaciente(long cpf) {

        Paciente paciente = buscarSemMensagem(cpf);

        // Paciente não encontrado
        if (paciente == null) {

            System.out.println(
                    "Paciente não encontrado. Não foi possível remover."
            );

            return;
        }

        removerNo(paciente);

        System.out.println(
                "Paciente removido com sucesso!"
        );
    }


    // =====================================================
    // REMOVER NÓ
    // =====================================================

    private void removerNo(Paciente paciente) {

        // -------------------------------------------------
        // CASO 1:
        // Paciente não possui filhos
        // -------------------------------------------------

        if (paciente.getEsquerda() == null &&
                paciente.getDireita() == null) {

            // Se era a raiz
            if (paciente.getPai() == null) {

                raiz = null;

                // Se era filho esquerdo
            } else if (paciente.getPai().getEsquerda() == paciente) {

                paciente.getPai().setEsquerda(null);

                // Se era filho direito
            } else {

                paciente.getPai().setDireita(null);
            }

            return;
        }


        // -------------------------------------------------
        // CASO 2:
        // Possui apenas filho direito
        // -------------------------------------------------

        if (paciente.getEsquerda() == null) {

            substituirNo(
                    paciente,
                    paciente.getDireita()
            );

            return;
        }


        // -------------------------------------------------
        // CASO 3:
        // Possui apenas filho esquerdo
        // -------------------------------------------------

        if (paciente.getDireita() == null) {

            substituirNo(
                    paciente,
                    paciente.getEsquerda()
            );

            return;
        }


        // -------------------------------------------------
        // CASO 4:
        // Possui dois filhos
        // -------------------------------------------------

        /*
         * Nesse caso encontramos o menor elemento
         * da subárvore direita.
         *
         * Esse elemento será o sucessor do paciente
         * que será removido.
         */

        Paciente sucessor =
                menorDaArvore(paciente.getDireita());


        // Copia os dados do sucessor para o paciente atual

        paciente.setCpf(
                sucessor.getCpf()
        );

        paciente.setNomeCompleto(
                sucessor.getNomeCompleto()
        );

        paciente.setCartaoSus(
                sucessor.getCartaoSus()
        );

        paciente.setTipoAtendimento(
                sucessor.getTipoAtendimento()
        );


        /*
         * Agora removemos o sucessor da posição antiga.
         *
         * Como ele é o menor da subárvore direita,
         * ele não possui filho esquerdo.
         */

        removerNo(sucessor);
    }


    // =====================================================
    // SUBSTITUIR UM NÓ POR OUTRO
    // =====================================================

    private void substituirNo(Paciente antigo, Paciente novo) {

        // Se o nó removido era a raiz
        if (antigo.getPai() == null) {

            raiz = novo;

            if (novo != null) {

                novo.setPai(null);
            }

            return;
        }


        // Se o nó antigo era filho esquerdo
        if (antigo.getPai().getEsquerda() == antigo) {

            antigo.getPai().setEsquerda(novo);

            // Se o nó antigo era filho direito
        } else {

            antigo.getPai().setDireita(novo);
        }


        // Atualiza o pai do novo nó
        if (novo != null) {

            novo.setPai(
                    antigo.getPai()
            );
        }
    }


    // =====================================================
    // ENCONTRAR MENOR ELEMENTO
    // =====================================================

    private Paciente menorDaArvore(Paciente paciente) {

        Paciente atual = paciente;

        while (atual.getEsquerda() != null) {

            atual = atual.getEsquerda();
        }

        return atual;
    }


    // =====================================================
    // IMPRIMIR CADASTRO EM ORDEM
    // =====================================================

    public void imprimirEmOrdem() {

        System.out.println(
                "\n=== PACIENTES CADASTRADOS ==="
        );

        imprimirEmOrdemRecursivo(raiz);
    }


    private void imprimirEmOrdemRecursivo(Paciente paciente) {

        if (paciente == null) {
            return;
        }

        // Esquerda
        imprimirEmOrdemRecursivo(
                paciente.getEsquerda()
        );

        // Atual
        paciente.exibirDados();

        System.out.println(
                "-------------------------"
        );

        // Direita
        imprimirEmOrdemRecursivo(
                paciente.getDireita()
        );
    }
}