import java.util.ArrayList;

public class Dealer {

    private ArrayList<Card> hand;
    private Deck deck;

    public Dealer(Deck deck) {
        this.hand = new ArrayList<>();
        this.deck = deck;
    }

    public void addcardtoHand(Card card){
        hand.add(card);
    }


    public void dealtoPlayer(Player player) {

        Card card = deck.dealCard();
        if (card != null) {
            player.addcardtoHand(card);
        }

    }


    public void dealtoDealer(Dealer dealer) {

        Card card = deck.dealCard();
        if (card != null) {
            dealer.addcardtoHand(card);
        }

    }

//    public void printHand() {
//        System.out.println("\nDealer's Hand:");
//        for (Card card : hand) {
//            System.out.println(card.getRank() + " of " + card.getSuit());
//        }
//        System.out.println("\n");
//    }

    public void printHand(boolean showAllCards) {
        System.out.println("\nDealer's Hand Shows:");
        for (int i = 0; i < hand.size(); i++) {
            if (i == 0 && !showAllCards) {
                System.out.println("Hidden Card");
            } else {
                Card card = hand.get(i);
                System.out.println(card.getRank() + " of " + card.getSuit());
            }
        }
        System.out.println("\n");
    }

    public int getHandValue() {
        int value = 0;
        int numAces = 0;

        for (Card card : hand) {
            value += card.getValue();
            if (card.getRank().equals("ACE")) {
                numAces++;
            }
        }

        // Adjust for Aces
        while (value > 21 && numAces > 0) {
            value -= 10; // Convert an Ace from 11 to 1
            numAces--;
        }

        System.out.println("Player's Hand Value: " + value);
        return value;
    }


}
