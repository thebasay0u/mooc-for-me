import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        // test your code here

        // Card first = new Card(2, Suit.DIAMOND); // # 2 Diamonds - 3
        // Card second = new Card(14, Suit.SPADE); // # A Spades - 1
        // Card third = new Card(12, Suit.HEART); // # Q Hearts - 2

        // System.out.println(first);
        // System.out.println(second);
        // System.out.println(third);
        // ! PART 1 - Make Card class comparable
        // # WORKING
        // System.out.println(first + " compared to " + second + "(positive number means
        // first is greater) : "
        // first.compareTo(second));
        // System.out.println(second + " compared to " + third + "(positive number means
        // first is greater) : "
        // second.compareTo(third));

        // Card first = new Card(14, Suit.SPADE);
        // Card second = new Card(14, Suit.DIAMOND);

        // System.out.println(first + " compared to " + second + "(positive number means
        // first is greater) : "
        // first.compareTo(second));
        // ! PART 2 - Hand class
        // # WORKING
        // Hand hand = new Hand();

        // hand.add(new Card(2, Suit.DIAMOND));
        // hand.add(new Card(14, Suit.SPADE));
        // hand.add(new Card(12, Suit.HEART));
        // hand.add(new Card(2, Suit.SPADE));

        // hand.print();

        // ! PART 3 - Sorting the hand (Single criteria)
        // # WORKING
        // Hand hand = new Hand();

        // hand.add(new Card(2, Suit.DIAMOND));
        // hand.add(new Card(14, Suit.SPADE));
        // hand.add(new Card(12, Suit.HEART));
        // hand.add(new Card(2, Suit.SPADE));

        // hand.sort();

        // hand.print();

        // ! PART 4 - Comparing Hands
        // # WORKING

        // Hand hand1 = new Hand();

        // hand1.add(new Card(2, Suit.DIAMOND));
        // hand1.add(new Card(14, Suit.SPADE));
        // hand1.add(new Card(12, Suit.HEART));
        // hand1.add(new Card(2, Suit.SPADE));

        // Hand hand2 = new Hand();

        // hand2.add(new Card(11, Suit.DIAMOND));
        // hand2.add(new Card(11, Suit.SPADE));
        // hand2.add(new Card(11, Suit.HEART));

        // int comparison = hand1.compareTo(hand2);

        // if (comparison < 0) {
        // System.out.println("better hand is");
        // hand2.print();
        // } else if (comparison > 0) {
        // System.out.println("better hand is");
        // hand1.print();
        // } else {
        // System.out.println("hands are equal");
        // }

        // ! PART 5 - Sorting cards with different criteria

        // ArrayList<Card> cards = new ArrayList<>();

        // cards.add(new Card(3, Suit.SPADE));
        // cards.add(new Card(2, Suit.DIAMOND));
        // cards.add(new Card(14, Suit.SPADE));
        // cards.add(new Card(12, Suit.HEART));
        // cards.add(new Card(2, Suit.SPADE));

        // Collections.sort(cards, new BySuitInValueOrder());

        // cards.stream().forEach(c -> System.out.println(c));

        Hand hand = new Hand();

        hand.add(new Card(12, Suit.HEART));
        hand.add(new Card(4, Suit.SPADE));
        hand.add(new Card(2, Suit.DIAMOND));
        hand.add(new Card(14, Suit.SPADE));
        hand.add(new Card(7, Suit.HEART));
        hand.add(new Card(2, Suit.SPADE));

        hand.sortBySuit();

        hand.print();

    }
}
