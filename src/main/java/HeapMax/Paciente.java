package HeapMax;

public class Paciente {
    private long cpf;
    private String nomeCompleto;
    private String cartaoSus;
    private String tipoAtendimento;
    private int idade;

    public Paciente(long cpf, String nomeCompleto,
                    String cartaoSus,
                    String tipoAtendimento, int idade) {
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.cartaoSus = cartaoSus;
        this.tipoAtendimento = tipoAtendimento;
        this.idade = idade;
    }

    public long getCpf() {
        return cpf;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getCartaoSus() {
        return cartaoSus;
    }

    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return "Nome: " + nomeCompleto +
                " | CPF: " + cpf +
                " | Cartão SUS: " + cartaoSus +
                " | Atendimento: " + tipoAtendimento +
                " | Idade: " + idade;
    }
}
