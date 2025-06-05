package observer;

import model.Jogador;

public class ConsoleVidaObserver implements VidaObserver {
    @Override
    public void atualizar(Jogador jogador) {
        System.out.println(jogador.getNome() + " agora tem " + jogador.getPontosDeVida() + " pontos de vida.");
    }
}
