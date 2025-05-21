package singleton;

import model.Carta;
import model.Jogador;

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
        jogador1.comprarCarta();
        jogador2.comprarCarta();

        if (jogador1.getMao().isEmpty() || jogador2.getMao().isEmpty()) {
            break;
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

    if (!jogador1.temCartas() && !jogador2.temCartas()) {
        System.out.println("\nEmpate! Ambos sem cartas.");
    } else if (!jogador1.temCartas()) {
        System.out.println("\n" + jogador2.getNome() + " venceu a partida!");
    } else {
        System.out.println("\n" + jogador1.getNome() + " venceu a partida!");
    }
}}
