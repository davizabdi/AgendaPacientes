package HeapMax;

public class Main {

    public static void main(String[] args) {

        Heap agenda = new Heap();

        System.out.println("================================");
        System.out.println(" SISTEMA DE ATENDIMENTO - UBS");
        System.out.println("================================");

        // Cadastro dos cinco pacientes

        System.out.println("\n--- CADASTRO DE PACIENTES ---");

        agenda.cadastrar_atendimento_dia(
                12345678901L, "Joao Silva",
                "SUS001", "Consulta Agendada", 72
        );

        agenda.cadastrar_atendimento_dia(
                12345678902L, "Maria Santos",
                "SUS002", "Triagem", 35
        );

        agenda.cadastrar_atendimento_dia(
                12345678903L, "Pedro Oliveira",
                "SUS003", "Vacinação", 65
        );

        agenda.cadastrar_atendimento_dia(
                12345678904L, "Ana Costa",
                "SUS004", "Consulta Agendada", 28
        );

        agenda.cadastrar_atendimento_dia(
                12345678905L, "Carlos Souza",
                "SUS005", "Triagem", 80
        );

        // Consulta ao próximo paciente

        System.out.println("\n--- PROXIMO ATENDIMENTO ---");

        Paciente proximo = agenda.quem_eh_o_proximo();

        if (proximo != null) {
            System.out.println(proximo);
        }

        // Remoção do paciente prioritário

        System.out.println("\n--- CHAMADA DO PACIENTE ---");

        Paciente atendido =
                agenda.remover_paciente_prioritario();

        if (atendido != null) {
            System.out.println("Paciente chamado:");
            System.out.println(atendido);
        }

        // Consulta ao próximo após a remoção

        System.out.println("\n--- PROXIMO DA FILA ---");

        proximo = agenda.quem_eh_o_proximo();

        if (proximo != null) {
            System.out.println(proximo);
        }
    }
}
