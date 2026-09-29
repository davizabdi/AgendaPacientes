package org.example;

public class Paciente {

    private long cpf;
    private String nomeCompleto;
    private String cartaoSus;
    private String tipoAtendimento;

    private Paciente pai;
    private Paciente esquerda;
    private Paciente direita;

    public Paciente(long cpf, String nomeCompleto, String cartaoSus, String tipoAtendimento) {
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.cartaoSus = cartaoSus;
        this.tipoAtendimento = tipoAtendimento;
        this.pai = null;
        this.esquerda = null;
        this.direita = null;
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

    public Paciente getPai() {
        return pai;
    }

    public void setPai(Paciente pai) {
        this.pai = pai;
    }

    public Paciente getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Paciente esquerda) {
        this.esquerda = esquerda;
    }

    public Paciente getDireita() {
        return direita;
    }

    public void setDireita(Paciente direita) {
        this.direita = direita;
    }

    public void exibirDados() {
        System.out.println("CPF: " + cpf);
        System.out.println("Nome: " + nomeCompleto);
        System.out.println("Cartão SUS: " + cartaoSus);
        System.out.println("Tipo de atendimento: " + tipoAtendimento);
    }
}