package state;

import model.Carta;
import model.Jogador;
import model.TipoCarta;

public class EstadoBatalha implements Iniciar {
    private Jogador jogador1;
    private Jogador jogador2;

    public EstadoBatalha(Jogador jogador1, Jogador jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
    }

    @Override
    public void executar() {
        if (jogador1.getMao().isEmpty() || jogador2.getMao().isEmpty()) {
            System.out.println("Um dos jogadores não tem cartas na mão para batalhar.");
            return;
        }

        Carta carta1 = jogador1.jogarCarta(0);
        Carta carta2 = jogador2.jogarCarta(0);

        System.out.println("\n" + jogador1.getNome() + " jogou: " + carta1.getNome() + " - " + carta1.getTipo() + " [" + carta1.getValor() + "]");
        System.out.println(jogador2.getNome() + " jogou: " + carta2.getNome() + " - " + carta2.getTipo() + " [" + carta2.getValor() + "]");

        String resultado1 = carta1.executar(carta2);
        String resultado2 = carta2.executar(carta1);

        System.out.println("Resultado " + jogador1.getNome() + ": " + resultado1);
        System.out.println("Resultado " + jogador2.getNome() + ": " + resultado2);

        aplicarDano(carta1, carta2);
    }

    private void aplicarDano(Carta carta1, Carta carta2) {
        int danoJogador1 = 0;
        int danoJogador2 = 0;

        if (carta1.getTipo() == TipoCarta.ATAQUE && carta2.getTipo() == TipoCarta.ATAQUE) {
            int diff = carta1.getValor() - carta2.getValor();
            if (diff > 0) {
                danoJogador2 = diff;
            } else if (diff < 0) {
                danoJogador1 = -diff;
            }
        } else if (carta1.getTipo() == TipoCarta.ATAQUE && carta2.getTipo() == TipoCarta.DEFESA) {
            int diff = carta1.getValor() - carta2.getValor();
            if (diff < 0) {
                danoJogador1 = -diff;
            }
        } else if (carta1.getTipo() == TipoCarta.DEFESA && carta2.getTipo() == TipoCarta.ATAQUE) {
            int diff = carta2.getValor() - carta1.getValor();
            if (diff < 0) {
                danoJogador2 = -diff;
            }
        }

        if (danoJogador1 > 0) {
            System.out.println(jogador1.getNome() + " recebeu " + danoJogador1 + " de dano!");
            jogador1.perderVida(danoJogador1);
        }

        if (danoJogador2 > 0) {
            System.out.println(jogador2.getNome() + " recebeu " + danoJogador2 + " de dano!");
            jogador2.perderVida(danoJogador2);
        }
    }
}
