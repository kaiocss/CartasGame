package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Jogador {
    private String nome;
    private List<Carta> deck;
    private List<Carta> mao;

    public Jogador(String nome, List<Carta> deckInicial) {
        this.nome = nome;
        this.deck = new ArrayList<>(deckInicial);
        this.mao = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Carta> getMao() {
        return mao;
    }

    public List<Carta> getDeck() {
        return deck;
    }

    public boolean temCartas() {
        return !deck.isEmpty() || !mao.isEmpty();
    }

    public void comprarCarta() {
        if (!deck.isEmpty()) {
            Carta carta = deck.remove(0);
            mao.add(carta);
            System.out.println(nome + " comprou uma carta: " + carta.getNome() + " - " + carta.getTipo() + " [" + carta.getValor() + "]");
        } else {
            System.out.println(nome + " não tem mais cartas no deck.");
        }
    }

    public Carta jogarCarta(int indice) {
        if (indice >= 0 && indice < mao.size()) {
            return mao.remove(indice);
        }
        throw new IllegalArgumentException("Indice de carta inválido na mão.");
    }

    public void embaralharDeck() {
        Random random = new Random();
        for (int i = 0; i < deck.size(); i++) {
            int j = random.nextInt(deck.size());
            Carta temp = deck.get(i);
            deck.set(i, deck.get(j));
            deck.set(j, temp);
        }
    }
}
