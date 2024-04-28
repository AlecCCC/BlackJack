import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    Deck deck = new Deck();
    Player player = new Player();
    Dealer dealer = new Dealer(deck);
    Scanner input = new Scanner(System.in);

    deck.shuffleDeck();

        System.out.println("Welcome to Blackjack to play, type 'start'");

        String choice = input.nextLine();

        if (choice.equalsIgnoreCase("start")) {
            System.out.println("The dealer will start dealing cards.");
        } else
            System.exit(1);

        dealer.dealtoDealer(dealer);
        dealer.dealtoPlayer(player);
        dealer.dealtoDealer(dealer);
        dealer.dealtoPlayer(player);


        dealer.printHand(false);
        player.printHand();

        while (true){

        if (player.getHandValue() < 22) {

            System.out.println("Player can hit, double down, stand");

            choice = input.nextLine();

           switch (choice){
               case "hit":
                   dealer.dealtoPlayer(player);
                   player.printHand();
                   break;
               case "stand":
                   break;
           }

        }

        }


//    dealer.dealtoDealer(dealer);
//    dealer.dealtoPlayer(player);
//    dealer.dealtoDealer(dealer);
//    dealer.dealtoPlayer(player);
//
//    deck.printDeck();
//
//    player.printHand();
//    dealer.printHand(false);
//
//    player.printHand();
//
//    player.getHandValue();
//    dealer.dealtoPlayer(player);
//        player.printHand();
//
//    if (player.getHandValue() > 22) {
//        System.out.println("Player Loses!");
//    }

    }
}