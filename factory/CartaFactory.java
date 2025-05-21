package factory;

import model.Carta;
import model.TipoCarta;
import strategy.*;

public class CartaFactory {
    public Carta criarCarta(TipoCarta tipo, int valor) {
        if (tipo == TipoCarta.ATAQUE) {
            return new Carta(tipo, valor, new EstrategiaAtaque());
        } else {
            return new Carta(tipo, valor, new EstrategiaDefesa());
        }
    }
}