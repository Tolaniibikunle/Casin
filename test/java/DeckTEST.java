import ibikunle.tolani.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by tolaniibikunle on 1/28/17.
 */
public class DeckTEST {
    Deck deck;
    Card card;
    GoFish goFish;
    ArrayList<Card> testHand;


    @Before
    public void setUp() {
        deck = new Deck();
        card = new Card(Suit.SPADES, Rank.TWO);
        goFish = new GoFish();
        testHand = new ArrayList<Card>();
        testHand.add(new Card(Suit.SPADES, Rank.TWO));
        testHand.add(new Card(Suit.HEARTS, Rank.TWO));
        testHand.add(new Card(Suit.CLUBS, Rank.THREE));
        testHand.add(new Card(Suit.DIAMONDS, Rank.TWO));
        testHand.add(new Card(Suit.HEARTS, Rank.ACE));


    }

    @Test
    public void dealNextCardTest() { //this card is dealing the next card
        Card expected = new Card(Suit.SPADES, Rank.TWO);
        Card actual = deck.deal();
        assertEquals("I am expecting Two of Spades", expected, actual);
    }

    @Test
    public void getCardRankTest() {  // this test is geting the rank of the card.
        Rank expected = Rank.TWO;
        Rank actual = card.getRank();
        assertEquals("I am expecting Two of Spades", expected, actual);
    }

    @Test
    public void dealingInitialCardsToDealerTest() {
        goFish.initialDealOfSevenCards("dealer"); // to make sure that you could pass in the dealers name and they would receive the right amount of cards
        int expected = 7;
        int actual = goFish.dealerHand.size();// go into go go fish object, go into playerhand, then get size .. file directory
        assertEquals("I am expecting 7 cards", expected, actual);
    }

    @Test
    public void dealingInitialCardsToPlayerTest() {  // we tested these to makes sure that you could pass in a player name as well
        goFish.initialDealOfSevenCards("player");
        int expected = 7;
        int actual = goFish.playerHand.size();// go into go go fish object, go into playerhand, then get size .. file directory
        assertEquals("I am expecting 7 cards", expected, actual);
    }

    @Test
    public void getMostFrequentRankInHandTest() {
        Rank expected = Rank.TWO;
        Rank actual = goFish.getMostFrequentRankInHand(testHand);
        assertEquals("I am expecting a TWO", expected, actual);
    }

    @Test
    public void checkIfCardIsInHandExpectingTrueTest() {
        boolean expected = true;
        boolean actual = goFish.checkIfCardIsInHand(testHand, Rank.TWO);
        assertEquals("I am expecting a TWO", expected, actual);


    }

    @Test
    public void checkIfCardIsInHandExpectingFalseTest() {
        boolean expected = false;
        boolean actual = goFish.checkIfCardIsInHand(testHand, Rank.FIVE);
        assertEquals("I am expecting a TWO", expected, actual);

    }

    @Test
    public void transferCardToPlayerTest() {
        goFish.dealerHand.add(new Card(Suit.HEARTS, Rank.TWO));
        goFish.dealerHand.add(new Card(Suit.CLUBS, Rank.ACE));
        goFish.dealerHand.add(new Card(Suit.DIAMONDS, Rank.FOUR));
        goFish.dealerHand.add(new Card(Suit.SPADES, Rank.EIGHT));

        goFish.transferCard("dealer", Rank.TWO);

        Rank expected = Rank.TWO;
        Rank actual = goFish.playerHand.get(goFish.playerHand.size() - 1).getRank();
        assertEquals("I am expecting a TWO", expected, actual);
    }

    @Test
    public void TransferCardToDealerHand() {
        goFish.playerHand.add(new Card(Suit.HEARTS, Rank.TWO));
        goFish.playerHand.add(new Card(Suit.CLUBS, Rank.ACE));
        goFish.playerHand.add(new Card(Suit.DIAMONDS, Rank.FOUR));
        goFish.playerHand.add(new Card(Suit.SPADES, Rank.EIGHT));

        goFish.transferCard("player", Rank.TWO);

        Rank expected = Rank.TWO;
        Rank actual = goFish.dealerHand.get(goFish.dealerHand.size() - 1).getRank();
        assertEquals("I am expecting a TWO", expected, actual);
    }

    @Test
    public void dealCardToDealerTest(){
        goFish.dealCardToDealer();
        Card expected = new Card(Suit.SPADES,Rank.TWO);
        Card actual = goFish.dealerHand.get(0);
        assertEquals("I am expecting a FOUR",expected,actual);
    }

    @Test
    public void dealCardToPlayerTest(){
        goFish.dealCardToPlayer();
        Card expected = new Card(Suit.SPADES,Rank.TWO);
        Card actual = goFish.playerHand.get(0);
        assertEquals("I am expecting a TWO",expected,actual);
    }
}