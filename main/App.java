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

        // Decks pre-criados aleatoriamente
        List<Carta> cartasAleatorias = gerarDeckAleatorio(factory, 20);

        // Criando decks dos jogadores
        List<Carta> deck1 = new ArrayList<>();
        List<Carta> deck2 = new ArrayList<>();

        System.out.println("=== Criação do Deck Jogador 1 ===");
        escolherOuCriarDeck(scanner, factory, deck1, cartasAleatorias);

        System.out.println("\n=== Criação do Deck Jogador 2 ===");
        escolherOuCriarDeck(scanner, factory, deck2, cartasAleatorias);

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
            System.out.println("Carta " + (i + 1) + ": Nome:");
            String nome = scanner.next();

            System.out.println("Tipo (A = Ataque / D = Defesa)");
            String tipo = scanner.next();

            System.out.println("Valor da carta:");
            int valor = scanner.nextInt();

            TipoCarta tipoCarta = tipo.equalsIgnoreCase("A") ? TipoCarta.ATAQUE : TipoCarta.DEFESA;
            deck.add(factory.criarCarta(nome, tipoCarta, valor));
        }
    }

    private static void escolherOuCriarDeck(Scanner scanner, CartaFactory factory, List<Carta> deck, List<Carta> cartasPreCriadas) {
        System.out.println("Deseja usar o deck aleatório pré-criado? (S/N)");
        String escolha = scanner.next();
        if (escolha.equalsIgnoreCase("S")) {
            copiarDeck(cartasPreCriadas, deck, factory);
        } else {
            criarDeck(scanner, factory, deck);
        }
    }

    private static List<Carta> gerarDeckAleatorio(CartaFactory factory, int qtd) {
        List<Carta> deck = new ArrayList<>();
        java.util.Random random = new java.util.Random();

        String[] nomes = {
                "Dragao Branco de Olhos Azuis",
                "Mago Negro",
                "Caveira Invocada",
                "Cavaleiro Gaia",
                "Kuriboh",
                "Dragao Negro de Olhos Vermelhos",
                "Exodia",
                "Arpia",
                "Soldado do Lustro Negro",
                "Slifer o Dragao Celeste"
        };

        for (int i = 1; i <= qtd; i++) {
            TipoCarta tipo = random.nextBoolean() ? TipoCarta.ATAQUE : TipoCarta.DEFESA;
            int valor = random.nextInt(10) + 1;
            String nome = nomes[random.nextInt(nomes.length)] + " #" + i;
            deck.add(factory.criarCarta(nome, tipo, valor));
        }
        return deck;
    }

    private static void copiarDeck(List<Carta> origem, List<Carta> destino, CartaFactory factory) {
        for (Carta c : origem) {
            destino.add(factory.criarCarta(c.getNome(), c.getTipo(), c.getValor()));
        }
    }
}
