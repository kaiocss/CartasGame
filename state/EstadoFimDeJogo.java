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
        if (!jogador1.temCartas() && !jogador2.temCartas()) {
            System.out.println("\nEmpate! Ambos sem cartas.");
        } else if (!jogador1.temCartas()) {
            System.out.println("\n" + jogador2.getNome() + " venceu a partida!");
            
        } else {
            System.out.println("\n" + jogador1.getNome() + " venceu a partida!");
        }
    }
}
