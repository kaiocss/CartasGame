package strategy;

import model.Carta;

public class EstrategiaAtaque implements Comportamento {
    @Override
    public String executar(Carta carta, Carta outra) {
        return outra.getComportamento().contraAtaque(carta, outra);
    }

    @Override
    public String contraAtaque(Carta carta, Carta outra) {
        if (carta.getValor() > outra.getValor()) {
            return "Carta de Ataque venceu! Oponente perde a carta.";
        }
        return "Carta de Ataque perdeu! Perde a carta.";
    }

    @Override
    public String contraDefesa(Carta carta, Carta outra) {
        if (carta.getValor() > outra.getValor()) {
            return "Carta de Ataque venceu! Ambos mantêm suas cartas.";
        }
        return "Carta de Defesa venceu! Ambos mantêm suas cartas.";
    }
}


/*  
A + A = Maior A vence, menor A perde a carta
A + D = Maior entre A e D vence, mantém a carta
D + D = Empate*/