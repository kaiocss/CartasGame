package strategy;

import model.Carta;


public class EstrategiaDefesa implements Comportamento {
    @Override
    public String executar(Carta carta, Carta outra) {
        return outra.getComportamento().contraDefesa(carta, outra);
    }

    @Override
    public String contraAtaque(Carta carta, Carta outra) {
        if (carta.getValor() > outra.getValor()) {
            return "Defesa venceu! Ambos mantêm suas cartas.";
        }
        return "Ataque venceu! Ambos mantêm suas cartas.";
    }

    @Override
    public String contraDefesa(Carta carta, Carta outra) {
        return "Empate! Defesa x Defesa.";
    }
}