public abstract class Person {

    private Hand hand;
    private String name;

    public Person() {
        this.hand = new Hand();
        this.name = "";
    }

    public Hand getHand() {
        return this.hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean hasBlackjack() {
        return this.getHand().calculatedValue() == 21;
    }

    public void printHand() {
        System.out.println(this.name + "'s hand looks like this:");
        System.out.println(this.hand + " Valued at: " + this.hand.calculatedValue());
    }

    public void hit(Deck deck, Deck discarded) {
        if (!deck.hasCards()) {
            deck.reloadDeckFromDiscard(discarded);
        }
        this.hand.takeCardFromDeck(deck);
        System.out.println(this.name + " gets a card.");
        this.printHand();
    }
}

