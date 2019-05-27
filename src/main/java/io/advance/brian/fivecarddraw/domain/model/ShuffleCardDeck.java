package io.advance.brian.fivecarddraw.domain.model;

/**
 * Generate different variations loop through suites and ranks
 * Add a new card to the deck with the determined suite and rank
 * Randomly permutes the specified list using a default source of randomness
 * All permutations occur with approximately equal likelihood
 */

import io.advance.brian.fivecarddraw.deck.RANK;
import io.advance.brian.fivecarddraw.deck.SUITE;

import java.util.Collections;
import java.util.*;


public class ShuffleCardDeck {
	private ArrayList <Card> deck;
	private int topCardIndex;

	public ShuffleCardDeck() {
		deck = new ArrayList<Card>();
		this.topCardIndex = 51;

		for (SUITE s : SUITE.values()) {
			for (RANK r : RANK.values()) {
				deck.add(new Card(s, r));
			}
		}
		 Collections.shuffle(deck);
	}

	public int getTopCardIndex() {
		return topCardIndex;
	}

	public void setTopCardIndex(int topCardIndex) {
		this.topCardIndex = topCardIndex;
	}

	public Card drawCard(){
		Card drawnCard = this.deck.get(getTopCardIndex());
		this.deck.remove(this.topCardIndex);
		this.setTopCardIndex(this.getTopCardIndex() - 1);
				
		return drawnCard;
	}
}
