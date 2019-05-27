package io.advance.brian.fivecarddraw.service;

/**
 * Service class that evaluates and validates the players hand
 */

import io.advance.brian.fivecarddraw.deck.RANK;
import io.advance.brian.fivecarddraw.deck.SUITE;
import io.advance.brian.fivecarddraw.domain.model.Card;
import io.advance.brian.fivecarddraw.exception.InvalidHandException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class EvaluatePlayerHandService {

    public static final String NUMBER_OF_CARDS = "Invalid number of cards";

    /**
     * Five of a kind evaluation true if the hand contains the same ranks(4)
     * @see <a href="https://en.wikipedia.org/wiki/List_of_poker_hands#Five_of_a_kind">Five of a kind</a>
     */
    public boolean isFiveOfAKind(Card[] cardsOnPlayersHand) {
        return countRank(cardsOnPlayersHand) == 4;
    }

    /**
     * Straight flush evaluation true if contains five cards of sequential rank, all of the same suit
     * @see <a href="https://en.wikipedia.org/wiki/List_of_poker_hands#Straight_flush">Straight Flush</a>
     */
    public boolean isStraightFlush(Card[] cardsOnHand) {
        return isStraight(cardsOnHand) && isFlush(cardsOnHand);
    }

    /**
     * Four of a kind evaluation true if contains four cards of one rank and one card of another rank
     * @see <a href="https://en.wikipedia.org/wiki/List_of_poker_hands#Four_of_a_kind">Four of a kind</a>
     */
    public boolean isFourKind(Card[] cardsOnHand) {
        if (cardsOnHand == null || cardsOnHand.length != 5) {
            throw new InvalidHandException(NUMBER_OF_CARDS);
        }

        return countRank(cardsOnHand) == 4;
    }
    /**
     * Full House evaluation true if contains three cards of one rank and two cards
     * @see <a href="https://en.wikipedia.org/wiki/List_of_poker_hands#Full_house">Full House</a>
     */
    public boolean isFullHouse(Card[] cardsOnHand) {
        return countPair(cardsOnHand) == 3;
    }

    /**
     * Flush evaluation true if contains  five cards all of the same suit
     * @see <a href="https://en.wikipedia.org/wiki/List_of_poker_hands#Flush">Flush</a>
     */
    public boolean isFlush(Card[] cardsOnHand) {
        int count = 0;

        SUITE currentSUITE = cardsOnHand[0].getSUITE();
        for (Card card : cardsOnHand) {
            if (card.getSUITE() == currentSUITE) {
                count++;
            }
        }
        return count == 5;
    }

    /**
     * Straight evaluation true if  contains  five cards of sequential rank
     * @see <a href="https://en.wikipedia.org/wiki/List_of_poker_hands#Straight">Straight</a>
     */
    public boolean isStraight(Card[] cardsOnHand) {
        boolean sequential = false;

        Arrays.sort(cardsOnHand);

        for (int i = 0; i < cardsOnHand.length - 1; i++) {
            if (cardsOnHand[i].getRank().getRankLetter() != (cardsOnHand[i + 1].getRank().getRankLetter() - 1)) {
                sequential = false;
            } else {
                sequential = true;
            }
        }
        return sequential;
    }

    /**
     * Three of a kind evaluation true if contains three cards of one rank and two cards of two other ranks
     * @see <a href="https://en.wikipedia.org/wiki/List_of_poker_hands#Three_of_a_kind">Three of a kind</a>
     */
    public boolean isThreeKind(Card[] cardsOnHand) {
        if (cardsOnHand == null || cardsOnHand.length != 5) {
            throw new InvalidHandException(NUMBER_OF_CARDS);
        }
        return countRank(cardsOnHand) == 3;
    }

    /**
     * Two pair true if contains two cards of one rank, two cards of another rank and one card of a third rank
     * @see <a href="https://en.wikipedia.org/wiki/List_of_poker_hands#Two_pair">Two pair</a>
     */
    public boolean isTwoPair(Card[] cardsOnHand) {
        return countPair(cardsOnHand) == 2;
    }

    /**
     *Checks One pair true if contains two cards of one rank and three cards of three other ranks
     * @see <a href="https://en.wikipedia.org/wiki/List_of_poker_hands#One_pair">One pair</a>
     */
    public boolean isOnePair(Card[] cardsOnHand) {
        return countPair(cardsOnHand) == 1;
    }

    private int countPair(Card[] cardsOnHand) {
        int count = 0;
        Set<Card> cards = new HashSet<>();
        for (Card card : cardsOnHand) {
            if (!cards.add(card)) {
                count++;
            }
        }
        return count;
    }

    private int countRank(Card[] cardsOnHand) {
        RANK rank = getAnyHandRank(cardsOnHand);
        int count = 0;
        for (Card card : cardsOnHand) {
            if (card.getRank() == rank) {
                count++;
            }
        }
        return count;
    }

    private RANK getAnyHandRank(Card[] cardsOnHand) {
        RANK rank = null;
        for (Card card : cardsOnHand) {
                rank = card.getRank();
        }
        return rank;
    }
}
