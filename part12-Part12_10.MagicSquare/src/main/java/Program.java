import java.util.ArrayList;
import java.util.List;

public class Program {

    public static ArrayList<Integer> sumsOfRows(int[][] square) {
        ArrayList<Integer> sums = new ArrayList<>();

        for (int row = 0; row < square.length; row++) {
            int sum = 0;
            for (int col = 0; col < square[row].length; col++) {
                int value = square[row][col];
                sum += value;

            }
            sums.add(sum);

        }
        return sums;
    }

    public static ArrayList<Integer> sumsOfColumns(int[][] square) {
        ArrayList<Integer> sums = new ArrayList<>();
        for (int i = 0; i < square[0].length; i++) {
            int sumCol = 0;
            for (int j = 0; j < square.length; j++) {
                sumCol += square[j][i];
            }
            sums.add(sumCol);

        }
        return sums;
    }

    public static List<Integer> sumsOfDiagonals(int[][] square) {
        int primaryDiagonal = square[0][0] + square[1][square[1].length / 2]
                + square[square.length - 1][square[0].length - 1];
        int secondaryDiagonal = square[0][square[0].length - 1] + square[1][square[1].length / 2]
                + square[square.length - 1][0];
        List<Integer> diagonals = new ArrayList<>();
        diagonals.add(primaryDiagonal);
        diagonals.add(secondaryDiagonal);
        return diagonals;

    }

    public static void main(String[] args) {
        // Test the MagicSquare class here

        // MagicSquareFactory msFactory = new MagicSquareFactory();
        // System.out.println(msFactory.createMagicSquare(5));

        // MagicSquare ms = new MagicSquare(3);
        // System.out.println(ms);
        // ! Part 1 - sums of rows
        // # Working
        int[][] testSquare = {
                { 8, 1, 6 },
                { 3, 5, 7 },
                { 4, 9, 2 }
        };

        int[][] anotherTestSquare = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        // ArrayList<Integer> sumRows = sumsOfRows(testSquare);
        // System.out.println(sumRows);

        // ! Part 2: Sums of Columns
        // ArrayList<Integer> sumCols = sumsOfColumns(testSquare);
        // System.out.println(sumCols);
        // ! Part 3 : Sums of diagonals
        List<Integer> sumDiagonals = sumsOfDiagonals(anotherTestSquare);
        System.out.println(sumDiagonals);

        // ! Part 4 : Conjure a magic square (Siamese method)

    }
}
