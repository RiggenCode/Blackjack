public class Card {

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Card(Card card) {
        this.suit = card.getSuit();
        this.rank = card.getRank();
    }

    public int getValue() {
        return rank.rankValue;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public String toString() {
        return ("[" + rank + " of " + suit + "] (" + this.getValue() + ")");
    }
}
