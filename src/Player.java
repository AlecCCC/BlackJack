import java.util.ArrayList;

public class Player {

private ArrayList<Card> hand;

    public Player() {
        hand = new ArrayList<>();
    }

    public void addcardtoHand(Card card){
        hand.add(card);
    }

    public void printHand() {
        System.out.println("\nPlayer's Hand:");
        for (Card card : hand) {
            System.out.println(card.getRank() + " of " + card.getSuit());
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
