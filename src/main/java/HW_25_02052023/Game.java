package HW_25_02052023;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private  int numPlayers;
    private final int numCardsPerPlayer;
    private final Deck deck;
    private final Scanner scanner;

    public Game(int numPlayers, int numCardsPerPlayer) {
        this.numPlayers = numPlayers;
        this.numCardsPerPlayer = numCardsPerPlayer;
        this.deck = new Deck();
        this.scanner = new Scanner(System.in);
    }

    public void play() {
        while (true) {
            System.out.print("Enter the number of players: ");
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (input <= 0) {
                    System.out.println("The number of players must be positive.");
                    continue;
                }
                if (input * numCardsPerPlayer > deck.size()) {
                    System.out.println("There are not enough cards in the deck for that many players.");
                    continue;
                }
                this.numPlayers = input;
                break;
            } else {
                System.out.println("Invalid input. Please enter a positive integer.");
                scanner.next();
            }
        }

        deck.shuffle();

        for (int i = 0; i < numPlayers; i++) {
            System.out.printf("Player %d's hand:%n", i + 1);
            List<Card> hand = deck.deal(numCardsPerPlayer);
            for (Card card : hand) {
                System.out.println(card);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Game game = new Game(2, 5);
        game.play();
    }
}
