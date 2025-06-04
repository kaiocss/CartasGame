package factory;

import model.Carta;
import model.TipoCarta;
import strategy.*;

public class CartaFactory {
    private static final Comportamento ATAQUE = new EstrategiaAtaque();
    private static final Comportamento DEFESA = new EstrategiaDefesa();

    public Carta criarCarta(TipoCarta tipo, int valor) {
        if (tipo == TipoCarta.ATAQUE) {
            return new Carta(tipo, valor, ATAQUE);
        } else {
            return new Carta(tipo, valor, DEFESA);
        }
    }
}