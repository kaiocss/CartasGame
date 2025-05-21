package main;

import factory.CartaFactory;
import model.Carta;
import model.Jogador;
import model.TipoCarta;
import singleton.GameManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CartaFactory factory = new CartaFactory();
        GameManager gameManager = GameManager.getInstance();

        // Criando decks
        List<Carta> deck1 = new ArrayList<>();
        List<Carta> deck2 = new ArrayList<>();

        System.out.println("=== Criação do Deck Jogador 1 ===");
        criarDeck(scanner, factory, deck1);

        System.out.println("\n=== Criação do Deck Jogador 2 ===");
        criarDeck(scanner, factory, deck2);

        // Criando jogadores
        Jogador jogador1 = new Jogador("Jogador 1", deck1);
        Jogador jogador2 = new Jogador("Jogador 2", deck2);

        jogador1.embaralharDeck();
        jogador2.embaralharDeck();

        System.out.println("\n=== Iniciando Partida ===\n");
        gameManager.lutarEntreJogadores(jogador1, jogador2);
    }

    private static void criarDeck(Scanner scanner, CartaFactory factory, List<Carta> deck) {
        System.out.println("Quantas cartas deseja adicionar ao deck?");
        int qtd = scanner.nextInt();

        for (int i = 0; i < qtd; i++) {
            System.out.println("Carta " + (i + 1) + ": Tipo (A = Ataque / D = Defesa)");
            String tipo = scanner.next();

            System.out.println("Valor da carta:");
            int valor = scanner.nextInt();

            TipoCarta tipoCarta = tipo.equalsIgnoreCase("A") ? TipoCarta.ATAQUE : TipoCarta.DEFESA;
            deck.add(factory.criarCarta(tipoCarta, valor));
        }
    }
}
