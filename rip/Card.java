package rip;

public class Card {
    private final String suit;  //final - pola niemodyfikowalne
    private final String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }
    //getters
    public String getSuit() {
        return suit;
    }
    public String getRank() {
        return rank;
    }
}
