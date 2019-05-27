package io.advance.brian.fivecarddraw;

/**
 * Main Poker Application
 */

import io.advance.brian.fivecarddraw.domain.model.ShuffleCardDeck;
import io.advance.brian.fivecarddraw.domain.model.Hands;
import io.advance.brian.fivecarddraw.service.CardAlgorithmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FiveCardPokerApplication implements CommandLineRunner {

	@Autowired
	private CardAlgorithmService cardAlgorithmService;

	private final Logger logger = LoggerFactory.getLogger(FiveCardPokerApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(FiveCardPokerApplication.class, args);
	}

	@Override
	public void run(String... strings) {

			ShuffleCardDeck gameDeck = new ShuffleCardDeck();
			Hands hand = new Hands(gameDeck);
			logger.info("Shuffling...Shuffling...Shuffling...\n");//shuffle function is actually called in the hands constructor
			hand.playersCards();
			String cards = hand.playersCards();
			String adviseOnPlayersHand = cardAlgorithmService.evaluateHand(cards.replace(" ", ""));
			logger.info("You have: "+adviseOnPlayersHand);
	}
}
