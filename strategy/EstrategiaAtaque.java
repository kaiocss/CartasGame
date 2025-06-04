package strategy;

import model.Carta;
import model.TipoCarta;

public class EstrategiaAtaque implements Comportamento {
    @Override
    public String executar(Carta carta, Carta outra) {
        if (outra.getTipo() == TipoCarta.ATAQUE) {
            if (carta.getValor() > outra.getValor()) {
                return "Carta de Ataque venceu! Oponente perde a carta.";
            } else  {
                return "Carta de Ataque perdeu! Perde a carta.";
            }
        } else {
            if (carta.getValor() > outra.getValor()) {
                return "Carta de Ataque venceu! Ambos mantêm suas cartas.";
            } else {
                return "Carta de Defesa venceu! Ambos mantêm suas cartas.";
            }
        }
    }
}


/*  
A + A = Maior A vence, menor A perde a carta
A + D = Maior entre A e D vence, mantém a carta
D + D = Empate*/