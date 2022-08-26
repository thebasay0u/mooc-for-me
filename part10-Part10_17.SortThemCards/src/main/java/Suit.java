/**
 * * CLUB = 1
 * * DIAMOND = 2
 * * HEART = 3
 * * SPADE = 4
 */
public enum Suit implements Comparable<Suit> {
    CLUB, DIAMOND, HEART, SPADE;

    public boolean isGreaterSuit(Suit suit) {

        return this.ordinal() > suit.ordinal() ? true : false;
    }

}
