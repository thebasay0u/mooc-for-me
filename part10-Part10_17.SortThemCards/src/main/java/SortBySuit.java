import java.util.Comparator;

public class SortBySuit implements Comparator<Card> {

    @Override
    public int compare(Card c1, Card c2) {
        // # returns negative number if c1 should be sorted before c2
        // # returns positive if c2 should be sorted before c1
        // # returns 0 if they are equal
        return c1.getSuit().ordinal() - c2.getSuit().ordinal();
    }

}
