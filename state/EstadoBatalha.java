package state;

import model.Carta;
import model.Jogador;

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

        System.out.println("\n" + jogador1.getNome() + " jogou: " + carta1.getTipo() + " [" + carta1.getValor() + "]");
        System.out.println(jogador2.getNome() + " jogou: " + carta2.getTipo() + " [" + carta2.getValor() + "]");

        String resultado1 = carta1.executar(carta2);
        String resultado2 = carta2.executar(carta1);

        System.out.println("Resultado " + jogador1.getNome() + ": " + resultado1);
        System.out.println("Resultado " + jogador2.getNome() + ": " + resultado2);
    }
}
