package HeapMax;

import java.util.ArrayList;

public class Heap {

    private ArrayList<Paciente> pacientes;

    public Heap() {
        pacientes = new ArrayList<>();
    }

    // Inserção de paciente no Max-Heap
    public void cadastrar_atendimento_dia(
            long cpf,
            String nome,
            String cartaoSus,
            String tipoAtendimento,
            int idade) {

        Paciente novo = new Paciente(
                cpf, nome, cartaoSus, tipoAtendimento, idade
        );

        pacientes.add(novo);

        int indice = pacientes.size() - 1;

        // Subida no Heap
        while (indice > 0) {
            int pai = (indice - 1) / 2;

            if (pacientes.get(indice).getIdade() >
                    pacientes.get(pai).getIdade()) {

                trocar(indice, pai);
                indice = pai;

            } else {
                break;
            }
        }

        System.out.println("Paciente cadastrado com sucesso!");
    }

    // Consulta ao paciente prioritário
    public Paciente quem_eh_o_proximo() {

        if (pacientes.isEmpty()) {
            System.out.println("Agenda vazia!");
            return null;
        }

        return pacientes.get(0);
    }

    // Remoção do paciente prioritário
    public Paciente remover_paciente_prioritario() {

        if (pacientes.isEmpty()) {
            System.out.println("Agenda vazia!");
            return null;
        }

        Paciente prioritario = pacientes.get(0);

        Paciente ultimo = pacientes.remove(
                pacientes.size() - 1
        );

        if (!pacientes.isEmpty()) {
            pacientes.set(0, ultimo);
            descer(0);
        }

        System.out.println("Paciente removido da agenda!");

        return prioritario;
    }

    // Descida no Heap
    private void descer(int indice) {

        int tamanho = pacientes.size();

        while (true) {

            int esquerda = 2 * indice + 1;
            int direita = 2 * indice + 2;
            int maior = indice;

            if (esquerda < tamanho &&
                    pacientes.get(esquerda).getIdade() >
                            pacientes.get(maior).getIdade()) {

                maior = esquerda;
            }

            if (direita < tamanho &&
                    pacientes.get(direita).getIdade() >
                            pacientes.get(maior).getIdade()) {

                maior = direita;
            }

            if (maior == indice) {
                break;
            }

            trocar(indice, maior);
            indice = maior;
        }
    }

    // Troca dois elementos de posição
    private void trocar(int i, int j) {

        Paciente temp = pacientes.get(i);

        pacientes.set(i, pacientes.get(j));
        pacientes.set(j, temp);
    }

    public boolean estaVazio() {
        return pacientes.isEmpty();
    }
}
