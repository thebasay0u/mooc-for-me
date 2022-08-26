import javax.sound.sampled.SourceDataLine;

public class Program {

    public static String arrayAsString(int[][] array) {
        StringBuilder sb = new StringBuilder();
        // int rows = array.length;
        // int columns = array[0].length;
        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                int valueToAdd = array[row][column];
                if (column == array[row].length - 1) {
                    sb.append(valueToAdd + "\n");
                } else {
                    sb.append(valueToAdd);
                }

            }

        }
        return sb.toString();

    }

    public static void main(String[] args) {
        // Test your method here

        int[][] matrix = {
                { 3, 2, 7, 6 },
                { 2, 4, 1, 0 },
                { 3, 2, 1, 0 }
        };

        // System.out.println(matrix[0].length); // # number of columns
        // System.out.println(matrix.length); // # number of rows

        System.out.println(arrayAsString(matrix));

    }

}
