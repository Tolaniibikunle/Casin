package ibikunle.tolani;

/**
 * Created by tolaniibikunle on 1/27/17.
 */
public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Rank getRank() {
        return rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false; // if the ranks are the same they are equal

        Card card = (Card) o;

        if (suit != card.suit) return false; //compares the ranks of the cards
        return rank == card.rank;
    }


    }
