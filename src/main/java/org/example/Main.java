package org.example;

public class Main {

    public static void main(String[] args) {

        ArvoreBST arvore = new ArvoreBST();

        System.out.println("==========================================");
        System.out.println(" SISTEMA DE TRIAGEM E PRONTUÁRIO DO SUS");
        System.out.println("==========================================");

        // ==========================================
        // 1. CARGA INICIAL DOS PACIENTES
        // ==========================================

        System.out.println("\n=== CARGA INICIAL DE PACIENTES ===");

        arvore.cadastrarPaciente(
                50000000000L,
                "João Silva",
                "700000000000001",
                "Vacinação"
        );

        arvore.cadastrarPaciente(
                30000000000L,
                "Maria Santos",
                "700000000000002",
                "Triagem"
        );

        arvore.cadastrarPaciente(
                70000000000L,
                "Carlos Oliveira",
                "700000000000003",
                "Consulta Agendada"
        );

        arvore.cadastrarPaciente(
                20000000000L,
                "Ana Costa",
                "700000000000004",
                "Vacinação"
        );

        arvore.cadastrarPaciente(
                40000000000L,
                "Pedro Lima",
                "700000000000005",
                "Triagem"
        );

        arvore.cadastrarPaciente(
                60000000000L,
                "Lucas Souza",
                "700000000000006",
                "Consulta Agendada"
        );

        arvore.cadastrarPaciente(
                80000000000L,
                "Julia Alves",
                "700000000000007",
                "Vacinação"
        );


        // ==========================================
        // 2. TENTATIVA DE CPF REPETIDO
        // ==========================================

        System.out.println("\n=== TESTE DE CPF REPETIDO ===");

        arvore.cadastrarPaciente(
                50000000000L,
                "Outro Paciente",
                "700000000000999",
                "Triagem"
        );


        // ==========================================
        // 3. BUSCA DE PACIENTE CADASTRADO
        // ==========================================

        System.out.println("\n=== BUSCA DE PACIENTE CADASTRADO ===");

        arvore.buscarPaciente(40000000000L);


        // ==========================================
        // 4. BUSCA DE PACIENTE NÃO CADASTRADO
        // ==========================================

        System.out.println("\n=== BUSCA DE PACIENTE NÃO CADASTRADO ===");

        arvore.buscarPaciente(45000000000L);
    }
}