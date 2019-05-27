package io.advance.brian.fivecarddraw.domain.model;
/**
 * This class contains the player's hand and methods to evaluate player's hand cards
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hands {
	private final Logger logger = LoggerFactory.getLogger(Hands.class);
	private Player playerHand;

	public Hands(ShuffleCardDeck gameDeck) {

		/**
		 *Dispense 5 Cards to playerHand
		 */
		playerHand = new Player(
				gameDeck.drawCard(),
				gameDeck.drawCard(),
				gameDeck.drawCard(),
				gameDeck.drawCard(),
				gameDeck.drawCard()
		);
	/*	logger.info(playerHand.showCards());
		*//**
		 * Test the playerHand's cards
		 * Not a very good place to place the test
		 *//*
		Card testCard1 = new Card(SUITE.H, RANK.FIVE);
		Card testCard2 = new Card(SUITE.H, RANK.FIVE);
		Card testCard3 = new Card(SUITE.S, RANK.KING);
		Card testCard4 = new Card(SUITE.S, RANK.QUEEN);
		Card testCard5 = new Card(SUITE.S, RANK.JACK);
		playerHand = new Player(testCard1, testCard2, testCard3, testCard4, testCard5);*/
	}

	public String playersCards() {
		return playerHand.showCards();
	}
}

