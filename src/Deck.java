import java.util.ArrayList;
public class Deck {

    private ArrayList<Card> deck;


    public Deck() {
        deck = new ArrayList<Card>();
    }

    public Deck(boolean makeDeck) {
        deck = new ArrayList<Card>();
        if(makeDeck) {
            for (Suit suit: Suit.values()) {
                for(Rank rank: Rank.values()) {
                    deck.add(new Card(suit, rank));
                }
            }
        }
    }

    public void addCard(Card card) {
        deck.add(card);
    }

    public ArrayList<Card> getCards() {
        return deck;
    }

    public Card takeCard() {
        Card cardToTake = new Card(deck.getFirst());
        deck.removeFirst();
        return cardToTake;
    }


    public String toString() {
        StringBuilder output = new StringBuilder();

        for(Card card: deck) {
            output.append(card);
            output.append("\n");
        }
        return output.toString();
    }


    public void shuffle() {
        ArrayList<Card> shuffledDeck = new ArrayList<Card>();

        while(!deck.isEmpty()) {
            int cardPulled = (int)(Math.random()*(deck.size() - 1));

            shuffledDeck.add(deck.get(cardPulled));

            deck.remove(cardPulled);
        }
        deck = shuffledDeck;
    }


    public boolean hasCards() {
        return !deck.isEmpty();
    }

    public void emptyDeck() {
        deck.clear();
    }

    public void addCards(ArrayList<Card> cards) {
        deck.addAll(cards);
    }

    public void reloadDeckFromDiscard(Deck discarded) {
        this.addCards(discarded.getCards());
        this.shuffle();
        discarded.emptyDeck();
        System.out.println("Ran out of cards, creating new deck from discard pile & shuffling deck.");
    }

    public int cardsLeft() {
        return deck.size();
    }

}
