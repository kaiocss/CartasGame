package strategy;

import model.Carta;
import model.TipoCarta;

public class EstrategiaDefesa implements Comportamento {
    @Override
    public String executar(Carta carta, Carta outra) {
        if (outra.getTipo() == TipoCarta.DEFESA) {
            return "Empate! Defesa x Defesa.";
        } else {
            if (carta.getValor() > outra.getValor()) {
                return "Defesa venceu! Ambos mantêm suas cartas.";
            } else {
                return "Ataque venceu! Ambos mantêm suas cartas.";
            }
        }
    }
}