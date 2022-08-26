import java.util.Comparator;

public class BySuitInValueOrder implements Comparator<Card> {

    @Override
    public int compare(Card c1, Card c2) {
        // #if the cards are equal, return 0
        if (c1.getSuit() == c2.getSuit() && c1.getValue() == c2.getValue())
            return 0;
        // # if suits are equal
        if (c1.getSuit() == c2.getSuit()) {
            if (c1.getValue() > c2.getValue()) {
                return 1;

            } else
                return -1;
            // # if card 1 suit > card 2 suit
        } else if (c1.getSuit().isGreaterSuit(c2.getSuit())) {
            return 1;
        } else
            return -1;
    }
}
