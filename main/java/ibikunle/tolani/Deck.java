package ibikunle.tolani;


import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by tolaniibikunle on 1/27/17.
 */
public class Deck {
    ArrayList<Card> cards = new ArrayList<Card>();


    public Deck(){
        for (Suit s :Suit.values()) //for each suit s in suit. suit. values returns each part of the enum.
              {
                  for (Rank r: Rank.values()) { // this ist t a run to run through every suit and every card in your constructor
                      cards.add(new Card(s,r));
                  }

        }

    }
    public Card deal(){ // returning a card
        Card c = cards.get(0); // this object c chooses a deck;
        cards.remove(0);   //this method removes one card from the ArrayList
        return c; // this now returns a card and the deck now has 51 cards.
    }
    public void shuffle(){
        Collections.shuffle(cards); //shuffling the cards.
    }
}