package strategy;

import model.Carta;

public interface Comportamento {
    String executar(Carta carta, Carta outra);
}