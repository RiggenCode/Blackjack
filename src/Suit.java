public enum Suit {
    CLUB("Clubs"),
    SPADE("Spades"),
    HEART("Hearts"),
    DIAMOND("Diamonds");
    String suitName;

    Suit(String suitName) {
        this.suitName = suitName;
    }

    public String toString() {
        return suitName;
    }
}
