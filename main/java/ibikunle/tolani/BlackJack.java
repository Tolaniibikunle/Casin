package ibikunle.tolani;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by tolaniibikunle on 1/27/17.
 */
public class BlackJack extends CardGame {
    public ArrayList<Card> getDealerHand() {
        return dealerHand;
    }

    ArrayList<Card> dealerHand = new ArrayList<Card>();

    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    ArrayList<Card> playerHand = new ArrayList<Card>();

    public void dealTwoCards(){
        dealerHand.add(deck.deal());
        dealerHand.add(deck.deal());
        playerHand.add(deck.deal());
        playerHand.add(deck.deal());
    }

    public int convertCardToValue(Card card) {

        Rank r = card.getRank();
        switch (r) {
            case JACK:
            case KING:
            case QUEEN:
            case TEN:
                return 10;
            case ACE:
                return 11;
            case EIGHT:
                return 8;
            case NINE:
                return 9;
            case SEVEN:
                return 7;
            case SIX:
                return 6;
            case FIVE:
                return 5;
            case FOUR:
                return 4;
            case THREE:
                return 3;
            case TWO:
                return 2;
            default:
                return -1;
        }
    }
  public int getValueOfHand(ArrayList<Card> hand){
        int value = 0;
      for (Card c:hand) {
          value += convertCardToValue(c); // this is getting the value of card c in our hand which is the arraylist
      }
          return value;
      }
  public boolean checkIfBust(ArrayList<Card> hand){
      return getValueOfHand(hand) >21;

  }
  public int compareValues(ArrayList<Card> handOne, ArrayList<Card> handTwo){
      return getValueOfHand(handOne)-getValueOfHand(handTwo);
  }
  public void hit(ArrayList<Card> hand){
      hand.add(deck.deal());
  }
  public ArrayList<Card> split(ArrayList<Card> hand){
      if(hand.get(0).getRank().equals(hand.get(1).getRank()) ){
          System.out.println("Do you want to split?");
          Scanner scanner = new Scanner(System.in);
          String spiltResponse = scanner.nextLine();
          if(spiltResponse.equalsIgnoreCase("yes")){
            Card card = hand.get(1);
              hand.remove(1);
              hit(hand);
              ArrayList<Card> secondHand = new ArrayList<Card>();
              secondHand.add(card);
              hit(secondHand);
          }
      }
    return
  }
    public boolean checkSpilt(ArrayList<Card> hand){


    }
}


