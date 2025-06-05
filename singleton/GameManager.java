package singleton;

import model.Jogador;
import state.EstadoBatalha;
import state.EstadoCompra;
import state.EstadoFimDeJogo;
import state.Iniciar;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        int rodada = 1;

        while (jogador1.temCartas() && jogador2.temCartas() &&
               jogador1.getPontosDeVida() > 0 && jogador2.getPontosDeVida() > 0) {
            System.out.println("\n=== Rodada " + rodada + " - Compra de Cartas ===");

            // Estado de Compra
            Iniciar compraJogador1 = new EstadoCompra(jogador1);
            Iniciar compraJogador2 = new EstadoCompra(jogador2);

            compraJogador1.executar();
            compraJogador2.executar();

            System.out.println("\nPressione Enter para iniciar a batalha...");
            scanner.nextLine();

            // Verifica se ainda tem carta na mao depois da compra
            if (jogador1.getMao().isEmpty() || jogador2.getMao().isEmpty()) {
                break;
            }

            System.out.println("\n=== Rodada " + rodada + " - Batalha ===");
            Iniciar batalha = new EstadoBatalha(jogador1, jogador2);
            batalha.executar();

            if (jogador1.getPontosDeVida() <= 0 || jogador2.getPontosDeVida() <= 0) {
                break;
            }

            System.out.println("\nPressione Enter para prosseguir para a próxima rodada...");
            scanner.nextLine();
            rodada++;
        }

        // Estado de Fim de Jogo
        Iniciar fimDeJogo = new EstadoFimDeJogo(jogador1, jogador2);
        fimDeJogo.executar();
    }
}
