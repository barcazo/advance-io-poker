package io.advance.brian.fivecarddraw.domain.model;
/**
 * Contains a players cards and allocates randomly 5 cards to the player
 * Does sorting of the cards as well
 */

import java.util.ArrayList;
import java.util.Collections;

public class Player {
	protected ArrayList <Card> hand; //array list of cards to hold  players hand
	protected int handScore; //an int that will represent the 'power' of the hand. used with evaluateHand() in Hands.java

	public Player(Card FirstCard, Card SecondCard, Card ThirdCard, Card FourthCard, Card FifthCard){
		hand = new ArrayList <Card>();
		
		hand.add(FirstCard);
		hand.add(SecondCard);
		hand.add(ThirdCard);
		hand.add(FourthCard);
		hand.add(FifthCard);
		/**
		 * Sort cards highest to lowest Rank
		 */

		for(int x=0; x<=4; x++){
			for(int y=0; y<=4; y++){
			if(hand.get(x).getRank().ordinal() > hand.get(y).getRank().ordinal())
				Collections.swap(hand, x, y);
				}//end y loop
		}//end x loop
		this.handScore = -1;
	}

	public String showCards(){
		String cards = "";
		for(int i = 0; i <= 4; i++) //loop through hand
		{
                String listString = String.join(",", hand.get(i).getRank().getRankLetter() + "" + hand.get(i).getSUITE() + ",");
                cards += listString;
		}
		return cards;
	}
}

