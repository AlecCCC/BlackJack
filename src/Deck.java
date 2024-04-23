import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;
    private String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private String[] ranks = {"TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING", "ACE"};


    public Deck() {
        cards = new ArrayList<>();
        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void printDeck(){
        for (Card card : cards) {
            System.out.println(card.getRank() + " of " + card.getSuit());
        }
    }

    public void shuffleDeck() {
        System.out.println("\nSHUFFLED DECK");

        Collections.shuffle(cards);
        for (Card card : cards) {
            System.out.println(card.getRank() + " of " + card.getSuit());
        }
        System.out.println("\n");
    }

    public Card dealCard(){
        if (cards.size() > 0) {
           return cards.remove(0);
        }
        return null;
    }

}
