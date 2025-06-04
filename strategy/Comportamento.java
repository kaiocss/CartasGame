package strategy;

import model.Carta;

public interface Comportamento {
    String executar(Carta carta, Carta outra);
    String contraAtaque(Carta carta, Carta outra);
    String contraDefesa(Carta carta, Carta outra);
}