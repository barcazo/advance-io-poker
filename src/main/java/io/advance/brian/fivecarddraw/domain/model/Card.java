package io.advance.brian.fivecarddraw.domain.model;
/**
 * Define the Card Component bean
 * Get the Card Rank from the Char
 * Get the Suite from the Text
 */
import io.advance.brian.fivecarddraw.deck.RANK;
import io.advance.brian.fivecarddraw.deck.SUITE;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Objects;

@Component
public class Card implements Comparable<Card> {

    Logger logger = LoggerFactory.getLogger(Card.class);
    private RANK rank;
    private SUITE SUITE;

    public Card() {
    }

    public Card(String rank, String suit) {
        this.rank = RANK.getEnum(rank);
        /**
         * Logger is for Test purposes to be deleted after
         */
     //   logger.info("RANK Enum Value "+RANK.getEnum(rank));
        this.SUITE = SUITE.valueOf(suit);
        /**
         * Logger is for Test purposes to be deleted after
         */
     //   logger.info("Suit Value "+ SUITE.valueOf(suit));
    }

    public Card(String card) {
        this.rank = RANK.getEnum(getRank(card));
        this.SUITE = SUITE.valueOf(card.substring(card.length() - 1));
    }

    public Card(SUITE s, RANK r)
    {
        SUITE = s;
        rank = r;
    }

    public RANK getRank() {
        return rank;
    }

    public void setRank(RANK rank) {
        this.rank = rank;
    }

    public SUITE getSUITE() {
        return SUITE;
    }

    public void setSUITE(SUITE SUITE) {
        this.SUITE = SUITE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank);
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.rank.getRankLetter(), o.rank.getRankLetter());
    }

    private String getRank(String card) {
        if (card.length() == 2) {
            return String.valueOf(card.charAt(0));
        } else {
            return card.substring(0, 2);
        }
    }
}
