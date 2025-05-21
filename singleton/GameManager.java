package singleton;

import model.Jogador;
import state.EstadoBatalha;
import state.EstadoCompra;
import state.EstadoFimDeJogo;
import state.Iniciar;

public class GameManager {
    private static GameManager instance = null;

    private GameManager() {}

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public void lutarEntreJogadores(Jogador jogador1, Jogador jogador2) {
        while (jogador1.temCartas() && jogador2.temCartas()) {
            // Estado de Compra
            Iniciar compraJogador1 = new EstadoCompra(jogador1);
            Iniciar compraJogador2 = new EstadoCompra(jogador2);

            compraJogador1.executar();
            compraJogador2.executar();

            // Verifica se ambos possuem cartas na mão após a compra
            if (jogador1.getMao().isEmpty() || jogador2.getMao().isEmpty()) {
                break;
            }

            // Estado de Batalha
            Iniciar batalha = new EstadoBatalha(jogador1, jogador2);
            batalha.executar();
        }

        // Estado de Fim de Jogo
        Iniciar fimDeJogo = new EstadoFimDeJogo(jogador1, jogador2);
        fimDeJogo.executar();
    }
}
