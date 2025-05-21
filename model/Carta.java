package model;

import strategy.Comportamento;

public class Carta {
    private TipoCarta tipo;
    private int valor;
    private Comportamento comportamento;

    public Carta(TipoCarta tipo, int valor, Comportamento comportamento) {
        this.tipo = tipo;
        this.valor = valor;
        this.comportamento = comportamento;
    }

    public TipoCarta getTipo() {
        return tipo;
    }

    public int getValor() {
        return valor;
    }

    public String executar(Carta outra) {
        return comportamento.executar(this, outra);
    }
}