public class Main {
    public static void main(String[] args) {

    Deck deck = new Deck();
    Player player = new Player();
    Dealer dealer = new Dealer(deck);

    deck.shuffleDeck();

    dealer.dealtoDealer(dealer);
    dealer.dealtoPlayer(player);
    dealer.dealtoDealer(dealer);
    dealer.dealtoPlayer(player);

    deck.printDeck();

    player.printHand();
    dealer.printHand(false);

    player.getHandValue();

    }
}