package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        ArvoreBST cadastroUBS = new ArvoreBST();

        // ==========================================
        // 1. CARGA INICIAL
        // Cadastrar seis pacientes
        // ==========================================

        System.out.println("=================================");
        System.out.println("   CARGA INICIAL DA UBS");
        System.out.println("=================================");

        cadastroUBS.cadastrarPaciente(
                50000000000L,
                "João Silva",
                "700000000000001",
                "Vacinação"
        );

        cadastroUBS.cadastrarPaciente(
                30000000000L,
                "Maria Santos",
                "700000000000002",
                "Triagem"
        );

        cadastroUBS.cadastrarPaciente(
                70000000000L,
                "Carlos Oliveira",
                "700000000000003",
                "Consulta Agendada"
        );

        cadastroUBS.cadastrarPaciente(
                20000000000L,
                "Ana Costa",
                "700000000000004",
                "Vacinação"
        );

        cadastroUBS.cadastrarPaciente(
                40000000000L,
                "Pedro Lima",
                "700000000000005",
                "Triagem"
        );

        cadastroUBS.cadastrarPaciente(
                60000000000L,
                "Lucas Souza",
                "700000000000006",
                "Consulta Agendada"
        );


        // ==========================================
        // MOSTRAR CADASTRO
        // ==========================================

        cadastroUBS.imprimirEmOrdem();


        // ==========================================
        // 2. REMOVER PACIENTE
        // Mudou de bairro
        // ==========================================

        System.out.println("\n=================================");
        System.out.println("   REMOÇÃO DE PACIENTE");
        System.out.println("=================================");

        System.out.println(
                "Paciente com CPF 30000000000 mudou de bairro."
        );

        cadastroUBS.removerPaciente(30000000000L);


        // Mostrar cadastro após remoção

        cadastroUBS.imprimirEmOrdem();


        // ==========================================
        // 3. SIMULAÇÃO DA RECEPÇÃO
        // 5 pacientes chegam
        // ==========================================

        System.out.println("\n=================================");
        System.out.println("   RECEPÇÃO DA UBS");
        System.out.println("=================================");

        Queue<Paciente> agendaAtendimentos = new LinkedList<>();


        // -------- PACIENTE 1 --------

        System.out.println("\nPaciente chegou à recepção.");
        System.out.println("CPF informado: 50000000000");

        Paciente paciente = cadastroUBS.buscarPaciente(
                50000000000L
        );

        if (paciente != null) {

            agendaAtendimentos.offer(paciente);

            System.out.println(
                    "Paciente inserido na agenda de atendimentos."
            );
        }


        // -------- PACIENTE 2 --------

        System.out.println("\nPaciente chegou à recepção.");
        System.out.println("CPF informado: 70000000000");

        paciente = cadastroUBS.buscarPaciente(
                70000000000L
        );

        if (paciente != null) {

            agendaAtendimentos.offer(paciente);

            System.out.println(
                    "Paciente inserido na agenda de atendimentos."
            );
        }


        // -------- PACIENTE 3 --------

        System.out.println("\nPaciente chegou à recepção.");
        System.out.println("CPF informado: 20000000000");

        paciente = cadastroUBS.buscarPaciente(
                20000000000L
        );

        if (paciente != null) {

            agendaAtendimentos.offer(paciente);

            System.out.println(
                    "Paciente inserido na agenda de atendimentos."
            );
        }


        // -------- PACIENTE 4 --------

        System.out.println("\nPaciente chegou à recepção.");
        System.out.println("CPF informado: 40000000000");

        paciente = cadastroUBS.buscarPaciente(
                40000000000L
        );

        if (paciente != null) {

            agendaAtendimentos.offer(paciente);

            System.out.println(
                    "Paciente inserido na agenda de atendimentos."
            );
        }


        // -------- PACIENTE 5 --------

        System.out.println("\nPaciente chegou à recepção.");
        System.out.println("CPF informado: 60000000000");

        paciente = cadastroUBS.buscarPaciente(
                60000000000L
        );

        if (paciente != null) {

            agendaAtendimentos.offer(paciente);

            System.out.println(
                    "Paciente inserido na agenda de atendimentos."
            );
        }


        // ==========================================
        // 4. IMPRIMIR AGENDA DO DIA
        // ==========================================

        System.out.println("\n=================================");
        System.out.println("   AGENDA DE ATENDIMENTOS");
        System.out.println("=================================");

        int posicao = 1;

        for (Paciente p : agendaAtendimentos) {

            System.out.println(
                    posicao + "º paciente:"
            );

            System.out.println(
                    "Nome: " + p.getNomeCompleto()
            );

            System.out.println(
                    "CPF: " + p.getCpf()
            );

            System.out.println(
                    "Cartão SUS: " + p.getCartaoSus()
            );

            System.out.println(
                    "Atendimento: " + p.getTipoAtendimento()
            );

            System.out.println("-------------------------");

            posicao++;
        }
    }
}