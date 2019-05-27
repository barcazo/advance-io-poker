package io.advance.brian.fivecarddraw.service;

import io.advance.brian.fivecarddraw.domain.model.Card;
import io.advance.brian.fivecarddraw.exception.InvalidHandException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import static io.advance.brian.fivecarddraw.service.EvaluatePlayerHandService.NUMBER_OF_CARDS;


/**
 * Highest Ranked Poker Hand
 */
@Service
public class CardAlgorithmService {

    private final Logger logger = LoggerFactory.getLogger(CardAlgorithmService.class);


    @Autowired
    private EvaluatePlayerHandService evaluatePlayerHandService;

    /**
     * Evaluate the player's hand
     * Determine the hand of the generated cards
     * @return poker hand
     */
    public String evaluateHand(String handOfCards) {

        /**This is an unnecessary check though as the card will be dynamically allocated
        * Added for extensibility purposes where player(s) might be prompted to input their cards
         */
        if (StringUtils.isEmpty(handOfCards)) {
            throw new InvalidHandException(NUMBER_OF_CARDS);
        }
        logger.info("Your cards:  "+handOfCards);
        Card[] cards = playerHandToArray(handOfCards);

        String playerHand;

        if (evaluatePlayerHandService.isFiveOfAKind(cards)) {
            playerHand = "Five of a kind";
        } else if (evaluatePlayerHandService.isStraightFlush(cards)) {
            playerHand = "Straight flush";
        } else if (evaluatePlayerHandService.isFourKind(cards)) {
            playerHand = "Four of a kind";
        } else if (evaluatePlayerHandService.isFullHouse(cards)) {
            playerHand = "Full house";
        } else if (evaluatePlayerHandService.isFlush(cards)) {
            playerHand = "Flush";
        } else if (evaluatePlayerHandService.isStraight(cards)) {
            playerHand = "Straight";
        } else if (evaluatePlayerHandService.isThreeKind(cards)) {
            playerHand = "Three of a kind";
        } else if (evaluatePlayerHandService.isTwoPair(cards)) {
            playerHand = "Two pair";
        } else if (evaluatePlayerHandService.isOnePair(cards)) {
            playerHand = "One Pair";
        } else {
            playerHand = "High cards";
        }

        return playerHand;
    }

    private Card[] playerHandToArray(String handOfCards) {
        String[] cardSplit = handOfCards.split(",");
        Card[] cards = {new Card(cardSplit[0]), new Card(cardSplit[1]), new Card(cardSplit[2]), new Card(cardSplit[3]),
                new Card(cardSplit[4])};
        return cards;
    }
}
