package state;

import model.Jogador;

public class EstadoCompra implements Iniciar {
    private Jogador jogador;

    public EstadoCompra(Jogador jogador) {
        this.jogador = jogador;
    }

    @Override
    public void executar() {
        jogador.comprarCarta();
    }
}
