package io.advance.brian.fivecarddraw.deck;

/**
 * Cards ranked in ascending value
 */

public enum RANK {
    TWO('2'), 
    THREE('3'), 
    FOUR('4'), 
    FIVE('5'), 
    SIX('6'), 
    SEVEN('7'), 
    EIGHT('8'),
    NINE('9'), 
    TEN('T'), 
    JACK('J'), 
    QUEEN('Q'), 
    KING('K'), 
    ACE('A');

    private char rankLetter;

    RANK(char symbol){
        this.rankLetter = symbol;
    }
    public char getRankLetter() {
        return this.rankLetter;
    }
    public void setRankLetter(char rankLetter) {
        this.rankLetter = rankLetter;
    }
    public static RANK getEnum(String rankEnum) {
        RANK rank;
        switch (rankEnum) {
            case "A":
                rank = ACE;
                break;
            case "2":
                rank = TWO;
                break;
            case "3":
                rank = THREE;
                break;
            case "4":
                rank = FOUR;
                break;
            case "5":
                rank = FIVE;
                break;
            case "6":
                rank = SIX;
                break;
            case "7":
                rank = SEVEN;
                break;
            case "8":
                rank = EIGHT;
                break;
            case "9":
                rank = NINE;
                break;
            case "T":
                rank = TEN;
                break;
            case "J":
                rank = JACK;
                break;
            case "Q":
                rank = QUEEN;
                break;
            case "K":
                rank = KING;
                break;
            default:
                throw new IllegalArgumentException("Rank is not valid: " + rankEnum);
        }
        return rank;
    }
}