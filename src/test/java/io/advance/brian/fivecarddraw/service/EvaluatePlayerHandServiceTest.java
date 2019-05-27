package io.advance.brian.fivecarddraw.service;

/**
 * tests creation on 2019/05/27 11:56 PM.
 */

import io.advance.brian.fivecarddraw.domain.model.Card;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class EvaluatePlayerHandServiceTest {

    private Card[] defaultCards = new Card[5];

    @Before
    public void setUp() {
        Card firstCard = new Card("A", "S");
        Card secondCard = new Card("T", "C");
        Card thirdCard = new Card("T", "H");
        Card forthCard = new Card("3", "D");
        Card fifthCard = new Card("3", "S");

        defaultCards[0] = firstCard;
        defaultCards[1] = secondCard;
        defaultCards[2] = thirdCard;
        defaultCards[3] = forthCard;
        defaultCards[4] = fifthCard;
    }

    @Test
    public void isFiveOfAKind() {
        Card firstCard = new Card("J", "S");
        Card secondCard = new Card("3", "C");
        Card thirdCard = new Card("3", "H");
        Card forthCard = new Card("3", "D");
        Card fifthCard = new Card("3", "S");

        Card[] cards = {firstCard, secondCard, thirdCard, forthCard, fifthCard};

        EvaluatePlayerHandService EvaluatePlayerHandService = new EvaluatePlayerHandService();

        boolean result = EvaluatePlayerHandService.isFiveOfAKind(cards);

        Assert.assertTrue(result);

    }

    @Test
    public void isFullHouse() {

        Card firstCard = new Card("6", "S");
        Card secondCard = new Card("6", "H");
        Card thirdCard = new Card("6", "D");
        Card forthCard = new Card("K", "C");
        Card fifthCard = new Card("K", "H");

        Card[] cards = {firstCard, secondCard, thirdCard, forthCard, fifthCard};

        EvaluatePlayerHandService EvaluatePlayerHandService = new EvaluatePlayerHandService();

        boolean result = EvaluatePlayerHandService.isFullHouse(cards);

        Assert.assertTrue(result);

    }

    @Test
    public void isFlush() {

        Card firstCard = new Card("J", "D");
        Card secondCard = new Card("9", "D");
        Card thirdCard = new Card("8", "D");
        Card forthCard = new Card("4", "D");
        Card fifthCard = new Card("3", "D");

        Card[] cards = {firstCard, secondCard, thirdCard, forthCard, fifthCard};

        EvaluatePlayerHandService EvaluatePlayerHandService = new EvaluatePlayerHandService();

        boolean result = EvaluatePlayerHandService.isFlush(cards);

        Assert.assertTrue(result);

    }

    @Test
    public void isStraight() {

        Card firstCard = new Card("7", "D");
        Card secondCard = new Card("6", "S");
        Card thirdCard = new Card("5", "H");
        Card forthCard = new Card("4", "D");
        Card fifthCard = new Card("3", "C");

        Card[] cards = {firstCard, secondCard, thirdCard, forthCard, fifthCard};

        EvaluatePlayerHandService EvaluatePlayerHandService = new EvaluatePlayerHandService();

        boolean result = EvaluatePlayerHandService.isStraight(cards);

        Assert.assertTrue(result);

    }

    @Test
    public void isStraightFlush() {

        Card firstCard = new Card("7", "S");
        Card secondCard = new Card("6", "S");
        Card thirdCard = new Card("5", "S");
        Card forthCard = new Card("4", "S");
        Card fifthCard = new Card("3", "S");

        Card[] cards = {firstCard, secondCard, thirdCard, forthCard, fifthCard};

        EvaluatePlayerHandService EvaluatePlayerHandService = new EvaluatePlayerHandService();

        boolean result = EvaluatePlayerHandService.isStraightFlush(cards);

        Assert.assertTrue(result);

    }

    @Ignore
    @Test
    public void isFourKind() {
        Card firstCard = new Card("5", "C");
        Card secondCard = new Card("5", "D");
        Card thirdCard = new Card("5", "H");
        Card forthCard = new Card("5", "S");
        Card fifthCard = new Card("2", "D");

        Card[] cards = {firstCard, secondCard, thirdCard, forthCard, fifthCard};

        EvaluatePlayerHandService EvaluatePlayerHandService = new EvaluatePlayerHandService();

        boolean result = EvaluatePlayerHandService.isFourKind(cards);

        Assert.assertTrue(result);

    }

    @Test
    @Ignore
    public void isThreeKind() {
        Card firstCard = new Card("4", "C");
        Card secondCard = new Card("4", "S");
        Card thirdCard = new Card("4", "H");
        Card forthCard = new Card("9", "H");
        Card fifthCard = new Card("2", "S");

        Card[] cards = {firstCard, secondCard, thirdCard, forthCard, fifthCard};

        EvaluatePlayerHandService EvaluatePlayerHandService = new EvaluatePlayerHandService();

        boolean result = EvaluatePlayerHandService.isThreeKind(cards);

        Assert.assertTrue(result);

    }

    @Test
    public void isTwoPair() {
        Card firstCard = new Card("J", "H");
        Card secondCard = new Card("J", "S");
        Card thirdCard = new Card("3", "C");
        Card forthCard = new Card("3", "S");
        Card fifthCard = new Card("2", "H");

        Card[] cards = {firstCard, secondCard, thirdCard, forthCard, fifthCard};

        EvaluatePlayerHandService EvaluatePlayerHandService = new EvaluatePlayerHandService();

        boolean result = EvaluatePlayerHandService.isTwoPair(cards);

        Assert.assertTrue(result);

    }

    @Test
    public void isOnePair() {
        Card firstCard = new Card("T", "S");
        Card secondCard = new Card("T", "H");
        Card thirdCard = new Card("8", "S");
        Card forthCard = new Card("7", "H");
        Card fifthCard = new Card("4", "C");

        Card[] cards = {firstCard, secondCard, thirdCard, forthCard, fifthCard};

        EvaluatePlayerHandService EvaluatePlayerHandService = new EvaluatePlayerHandService();

        boolean result = EvaluatePlayerHandService.isOnePair(cards);

        Assert.assertTrue(result);

    }
}
