package io.advance.brian.fivecarddraw.deck;

/**
 * Card Suite Description
 */
public enum SUITE {

    C("Clubs"),
    D("Diamonds"),
    H("Hearts"),
    S("Spades");

    private String description;

    SUITE(String description) {
        this.description = description;
    }
    public String description() {
        return description;
    }
}
