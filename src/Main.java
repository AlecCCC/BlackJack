import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String choice;

        do {
            playBlackjack(input);
            System.out.println("Do you want to play again? (yes/no)");
            choice = input.nextLine();
        } while (choice.equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing!");
    }

    public static void playBlackjack(Scanner input) {
        Deck deck = new Deck();
        Player player = new Player();
        Dealer dealer = new Dealer(deck);

        deck.shuffleDeck();

        System.out.println("Welcome to Blackjack. Type 'start' to begin.");
        String choice = input.nextLine();

        if (!choice.equalsIgnoreCase("start")) {
            System.out.println("Invalid choice. Exiting the game.");
            System.exit(1);
        }

        dealer.dealtoDealer(dealer);
        dealer.dealtoPlayer(player);
        dealer.dealtoDealer(dealer);
        dealer.dealtoPlayer(player);

        dealer.printHand(false);
        player.printHand();

        while (true) {
            if (player.getHandValue() < 22) {
                System.out.println("Player can hit, double down, or stand");
                choice = input.nextLine();
                System.out.println("\n");

                switch (choice) {
                    case "hit":
                        dealer.dealtoPlayer(player);

                        break;
                    case "stand":

                        while (dealer.getHandValue() < 17) {
                            dealer.dealtoDealer(dealer);
                            if (dealer.getHandValue() > 21) {
                                System.out.println("Dealer busted. Player wins.");
                                return;
                            }
                        }

                        System.out.println("Dealer stands at " + dealer.getHandValue());

                        // Determine the winner
                        if (dealer.getHandValue() > player.getHandValue()) {
                            System.out.println("Dealer stands at " + dealer.getHandValue());
                            System.out.println("Dealer wins");
                        } else if (dealer.getHandValue() < player.getHandValue()) {
                            System.out.println("Dealer stands at " + dealer.getHandValue());
                            System.out.println("Player wins");
                        } else {
                            System.out.println("It's a tie");
                        }
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }

                if (choice.equalsIgnoreCase("stand")) {
                    break;
                }
            } else {
                System.out.println("Player busted. Dealer wins.");
                return;
            }
        }
    }
}



