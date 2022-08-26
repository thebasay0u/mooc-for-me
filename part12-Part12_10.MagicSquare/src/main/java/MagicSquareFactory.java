
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);
        int row = 0, column = size / 2, count = 1;
        int futRow = row, futColumn = column;
        // implement the creation of a magic square with the Siamese method algorithm
        // here
        for (int i = 0; i < size * size; i++) {
            if (square.readValue(futColumn, futRow) == 0) {
                column = futColumn;
                row = futRow;
                square.placeValue(column, row, count);
            } else {
                if (row < size - 1) {
                    row++;
                } else {
                    row = 0;
                }
                square.placeValue(column, row, count);
                futColumn = column;
                futRow = row;
            }

            if (futColumn < size - 1) {
                futColumn++;
            } else {
                futColumn = 0;
            }
            if (futRow > 0) {
                futRow--;
            } else {
                futRow = size - 1;
            }

            count++;
        }
        return square;
    }

}
