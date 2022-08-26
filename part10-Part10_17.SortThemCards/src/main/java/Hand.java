import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Hand implements Comparable<Hand> {
    private List<Card> _playerHand;

    public Hand() {
        this._playerHand = new ArrayList<>();
    }

    // # WORKING
    public void add(Card card) {
        if (!this._playerHand.contains(card)) {
            this._playerHand.add(card);
        }

    }

    // # WORKING
    public void print() {

        this._playerHand.stream().forEach(card -> System.out.println(card));

    }

    // # WORKING
    public void sort() {
        Collections.sort(this._playerHand);

    }

    private int sumValues() {
        int sumOfValues = 0;
        Iterator<Card> it = this._playerHand.iterator();
        while (it.hasNext()) {
            Card current = it.next();
            sumOfValues += current.getValue();
        }
        return sumOfValues;
    }

    // private int getHandSize() {
    // return this._playerHand.size();
    // }

    @Override
    public int compareTo(Hand hand) {

        // # Hands are ranked based on the sum of values of its cards
        if (this.sumValues() == hand.sumValues()) {
            return 0;
        } else if (this.sumValues() > hand.sumValues())
            return 1;
        else
            return -1;

    }

    public void sortBySuit() {
        Collections.sort(this._playerHand, new BySuitInValueOrder());
    }
}
