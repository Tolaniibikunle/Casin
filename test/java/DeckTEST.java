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
    GoFish goFish; //declarations
    ArrayList<Card> testHand;
    Player player;
    Player dealer;
    BlackJack blackJack;

    @Before
    public void setUp() {
        deck = new Deck();
        card = new Card(Suit.SPADES, Rank.TWO);
        goFish = new GoFish();
        testHand = new ArrayList<Card>();
        testHand.add(new Card(Suit.SPADES, Rank.TWO));
        testHand.add(new Card(Suit.HEARTS, Rank.TWO));
        testHand.add(new Card(Suit.DIAMONDS, Rank.TWO));// instances
        testHand.add(new Card(Suit.HEARTS, Rank.ACE));
        testHand.add(new Card(Suit.CLUBS,Rank.TWO));
        player = new Player("player");
        dealer = new Player("dealer");
        blackJack = new BlackJack();


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
        goFish.initialDealOfSevenCards(dealer); // to make sure that you could pass in the dealers name and they would receive the right amount of cards
        int expected = 7;
        int actual = goFish.dealerHand.size();// go into go go fish object, go into playerhand, then get size .. file directory
        assertEquals("I am expecting 7 cards", expected, actual);
    }

    @Test
    public void dealingInitialCardsToPlayerTest() {  // we tested these to makes sure that you could pass in a player name as well
        goFish.initialDealOfSevenCards(player);
        int expected = 7;
        int actual = goFish.playerHand.size();// go into go go fish object, go into playerhand, then get size .. file directory
        assertEquals("I am expecting 7 cards", expected, actual);
    }

    @Test
    public void getRequestRankTest() {
        Rank expected = Rank.ACE;
        Rank actual = goFish.getRequestRank(testHand);
        assertEquals("I am expecting a ACE", expected, actual);
    }

    @Test
    public void checkIfCardIsInHandExpectingTrueTest() {
        boolean expected = true;
        boolean actual = goFish.checkIfCardIsInHand(testHand, Rank.TWO);
        assertEquals("I am expecting a TWO", expected, actual);


    }

    @Test
    public void creatingDeckTest() {
        int expeted = 52;
        int actual = deck.getCards().size();
        assertEquals("I am expecting 52 cards in deck ", expeted, actual);
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
        assertEquals("I am expecting a TWO",expected,actual);
    }

    @Test
    public void dealCardToPlayerTest(){
        goFish.dealCardToPlayer();
        Card expected = new Card(Suit.SPADES,Rank.TWO);
        Card actual = goFish.playerHand.get(0);
        assertEquals("I am expecting a TWO",expected,actual);
    }
    @Test
    public void checkDeckAfterDealTest(){
        goFish.initialDealOfSevenCards(dealer);
       int  expected = 45;
       int actual = deck.getCards().size();
       assertEquals(" I am expecting 45",expected,actual);
    }
    @Test
    public void getNumberOfBooksTest() {
        int expected = 1;
        int actual = goFish.getNumberOfBooks(testHand);
        assertEquals("I am expecting 1", expected, actual);

    }
    @Test
    public void numberOfCardsOfRankTest(){
        int expected = 4;
        int acutal = goFish.numberOfCardsOfRank(testHand,Rank.TWO);
        assertEquals("I am expecting four",expected,acutal);
    }
    @Test
    public void dealTwoCardsToDealerTest(){
        blackJack.dealTwoCards();
        int expected = 2;
        int actual = blackJack.getDealerHand().size();
        assertEquals("I am expecting two",expected,actual);
    }
    @Test
    public void dealerTwoCardsToPlayerTest(){
        blackJack.dealTwoCards();
        int expected = 2;
        int actual = blackJack.getPlayerHand().size();
        assertEquals("I am expecting two",expected,actual);
    }
    @Test
    public void convertCardToValueTest(){
      int expected = 10;
      int actutal = blackJack.convertCardToValue(new Card(Suit.CLUBS,Rank.KING)) ;
      assertEquals("I am expecting a 10",expected,actutal);
    }
    @Test
    public void getValueOfHandTest(){
        int expected = 19;
        int actual =blackJack.getValueOfHand(testHand);
        assertEquals("I am expecting 19",expected,actual);
    }
    @Test
    public void checkIfBustTest(){
        testHand.add(new Card(Suit.SPADES,Rank.KING));
        boolean expected = true;
        boolean actual = blackJack.checkIfBust(testHand);
        assertEquals("I am expecting true",expected,actual);

    }
    @Test
    public void compareValues(){
        ArrayList<Card> playerHand = new ArrayList<Card>();
        playerHand.add(new Card(Suit.SPADES,Rank.EIGHT));
        playerHand.add(new Card(Suit.HEARTS,Rank.JACK));
        int expected = 1;
        int actual = blackJack.compareValues(testHand,playerHand);
        assertEquals("I am expecting one",expected,actual);
    }
    @Test
    public void hitTest(){
        blackJack.hit(testHand);
        int expected =6;
        int actual = testHand.size();
        assertEquals("I am expected 6",expected,actual);

    }
}

