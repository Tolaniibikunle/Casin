package ibikunle.tolani;

import java.util.ArrayList;
import java.util.*;

/**
 * Created by tolaniibikunle on 1/27/17.
 */
public class GoFish extends CardGame {
    public ArrayList<Card> dealerHand = new ArrayList<Card>(); //created new arraylists for the dealers hands
    public ArrayList<Card> playerHand = new ArrayList<Card>(); //created new arraylist for the players hands
    Deck deck = new Deck();


    public void startGame() {
        initialDealOfSevenCards(dealer); // we are passing the object dealer through the method initialDealOfSeven cards and dealing seven cards
        initialDealOfSevenCards(player);// we are passing the object dealer through the method initialDealOfSeven cards and dealing seven cards
        while (deck.getCards().size() > 0) {
            dealersTurn();
            playersTurn();

        }
        decideWinner();
    }
    public void decideWinner(){
        if(getNumberOfDealerBooks()>getNumberOfPlayerBooks()){
            System.out.println("Dealer Wins with " + getNumberOfDealerBooks() + " books!");
        } else if (getNumberOfPlayerBooks()> getNumberOfDealerBooks()){
            System.out.println("Player Wins with " + getNumberOfPlayerBooks() + "books!");
        }
        else{
            System.out.println("Tie!");
        }

    }

    public void dealersTurn() {
        Rank mostFrequentRankInDealersHand = getRequestRank(dealerHand);
        boolean isCardInDealerHand = checkIfCardIsInHand(playerHand, mostFrequentRankInDealersHand);
        if (isCardInDealerHand) {
            transferCard("player", mostFrequentRankInDealersHand);
        } else {
            dealCardToDealer();
        }
    }

    public void playersTurn() {
        Rank mostFrequentRankInPlayersHand = getRequestRank(playerHand);
        boolean isCardInPlayerHand = checkIfCardIsInHand(dealerHand, mostFrequentRankInPlayersHand);
        if (isCardInPlayerHand) {
            transferCard("dealer", mostFrequentRankInPlayersHand);
        } else {
            dealCardToPlayer();
        }
    }

    public void initialDealOfSevenCards(Player player) { // this method is dealing the initial seven cards
        if (player.getPlayerName().equals("dealer")) {
            for (int i = 0; i < 7; i++) { // this is dealing out seven cards
                dealerHand.add(deck.deal());
            }
        } else if (player.getPlayerName().equals("player")) {
            for (int i = 0; i < 7; i++) { // this is dealing out seven cards
                playerHand.add(deck.deal());
            }

        }
    }

    public Rank getRequestRank(ArrayList<Card> hand) { // how to count what kinds of cards they have
//
        ArrayList<Rank> ranks = new ArrayList<Rank>(); // every piece of this list is rank
        for (Card c: hand) //for every card in the hand , get the rank of the first hand
              { Rank r = c.getRank();
                  if(numberOfCardsOfRank(hand,r)<4){
                    ranks.add(r);
              }

        }
        int index =(int) Math.floor(Math.random()*ranks.size()); // generating a random between 0 and the length the hand.
        return ranks.get(index) ;
    }


    public boolean checkIfCardIsInHand(ArrayList<Card> hand, Rank lookingFor) {
        for (int i = 0; i < hand.size(); i++) {                 // this method checks to see if the card we are looking for is in the hand of the of the opposite player.
            if (lookingFor == hand.get(i).getRank()) //this is the hand you have now you are going inside of hand that you have to get the rank.
                return true;
        }
        return false;
    }

    public int numberOfCardsOfRank(ArrayList<Card> hand, Rank rank){ // checking to see if the number of cards of each rank.
            int counter = 0;
        for (int i = 0; i <hand.size(); i++) {
            if(hand.get(i).getRank() == rank){
               counter++;
            }

        }
        return counter;
    }

    public int findIndexOfRank(ArrayList<Card> hand, Rank rank) {
        int index = 0;
        for (int i = 0; i < hand.size(); i++) {
            if (rank == hand.get(i).getRank()) {
                index = i;
            }

        }
        return index;
    }

    public void transferCard(String startingTransferHand, Rank rank) {
        if (startingTransferHand.equals("dealer")) {
            int indexOfCard = findIndexOfRank(dealerHand, rank);
            Card card = dealerHand.get(indexOfCard);
            dealerHand.remove(indexOfCard); // this removes the card from the dealers hand
            playerHand.add(card); // this adds the card that you just got from the dealers hand
        } else if (startingTransferHand.equals("player")) {
            int indexOfCard = findIndexOfRank(playerHand, rank);
            Card card = playerHand.get(indexOfCard);
            playerHand.remove(indexOfCard); // this removes the card from the players hand
            dealerHand.add(card); // this adds the card tht you just got from the players hand

        }
    }

    public void dealCardToDealer() {  // deal a card to the dealer
        dealerHand.add(deck.deal());
    }

    public void dealCardToPlayer() {  // deal a card to the player
        playerHand.add(deck.deal());
    }

    public int getNumberOfBooks(ArrayList<Card> hand) {
        int books = 0;
        HashMap<Rank, Integer> bookDictionary = new HashMap<Rank, Integer>();
        for (int i = 0; i < hand.size(); i++) {
            Rank rank = hand.get(i).getRank();
            if (bookDictionary.containsKey(rank)) {
                bookDictionary.put(rank, bookDictionary.get(rank) + 1); // gets the current value back and adds one to it and overrides the current data inside of it.
            } else {
                bookDictionary.put(rank, 1); // this will just add one if the book is not already there.
            }

        }

        for (Integer value : bookDictionary.values()) {
            if (value == 4) {
                books++;
            }
        }
        return books;


    }

    public int getNumberOfDealerBooks(){ // get the number of dealer books
        return getNumberOfBooks(dealerHand);
    }

    public int getNumberOfPlayerBooks(){ // get the number of player books
        return getNumberOfBooks(playerHand);
    }

}