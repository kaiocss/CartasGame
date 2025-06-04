package model;

import strategy.Comportamento;

public class Carta {
    private String nome;
    private TipoCarta tipo;
    private int valor;
    private Comportamento comportamento;

    public Carta(String nome, TipoCarta tipo, int valor, Comportamento comportamento) {
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
        this.comportamento = comportamento;
    }

    public String getNome() {
        return nome;
    }

    public TipoCarta getTipo() {
        return tipo;
    }

    public Comportamento getComportamento() {
        return comportamento;
    }

    public int getValor() {
        return valor;
    }

    public String executar(Carta outra) {
        return comportamento.executar(this, outra);
    }
}