package rip;
import java.util.*;

public class DeckCreator {
    public static void main(String[] args) {
        String[] suits = {"Kier", "Karo", "Trefl", "Pik"};
        String[] ranks = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Walet", "Dama", "Król", "As"};

        List<Card> deck = new ArrayList<>();

        for (String suit : suits) {                 //dla kazdego koloru w kolorach
            for (String rank : ranks) {             //dla kazdej warosci w wartosciach
                deck.add(new Card(suit, rank));     //stworz nowa karte w talii
            }
        }

        Collections.shuffle(deck);

        for(Card card : deck) {
            System.out.println(card.getRank() + " " + card.getSuit());
        }

    }
}
