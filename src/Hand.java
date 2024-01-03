import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> hand;

    public Hand() {
        hand = new ArrayList<Card>();
    }

    public void takeCardFromDeck(Deck deck) {
        hand.add(deck.takeCard());
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        for(Card card: hand) {
            output.append(card).append(" - ");
        }
        return output.toString();
    }

    public int calculatedValue() {

        int value = 0;
        int aceCount = 0;

        for(Card card: hand) {
            value += card.getValue();

            if (card.getValue() == 11) {
                aceCount++;
            }
        }

        if (value > 21 && aceCount > 0) {
            while (aceCount > 0 && value > 21) {
                aceCount--;
                value -= 10;
            }
        }
        return value;
    }

    public Card getCard(int i) {
        return hand.get(i);
    }

    public void discardHandToDeck(Deck discarded) {
        discarded.addCards(hand);

        hand.clear();
    }

}
