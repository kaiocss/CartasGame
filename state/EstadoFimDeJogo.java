package state;

import model.Jogador;

public class EstadoFimDeJogo implements Iniciar {
    private Jogador jogador1;
    private Jogador jogador2;

    public EstadoFimDeJogo(Jogador jogador1, Jogador jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
    }

    @Override
    public void executar() {
        boolean j1Derrotado = jogador1.getPontosDeVida() <= 0 || !jogador1.temCartas();
        boolean j2Derrotado = jogador2.getPontosDeVida() <= 0 || !jogador2.temCartas();

        if (j1Derrotado && j2Derrotado) {
            System.out.println("\nEmpate! Ambos foram derrotados.");
        } else if (j1Derrotado) {
            System.out.println("\n" + jogador2.getNome() + " venceu a partida!");
        } else {
            System.out.println("\n" + jogador1.getNome() + " venceu a partida!");
        }
    }
}
