
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LiteracyComparison {

    public static void main(String[] args) {

        String file = "literacy.csv";

        // # Reads the file into a list of lines
        List<String> literacyRates = readFile(file);

        // # Prints each line from the list
        // literacyRates.stream().forEach(line -> System.out.println(line));

        printInOrderOfLiteracyRate(literacyRates);

    }

    public static List<String> readFile(String fileName) {
        List<String> lines = new ArrayList<>();

        try {
            Files.lines(Paths.get(fileName)).forEach(line -> lines.add(line));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return lines;

    }

    public static void printInOrderOfLiteracyRate(List<String> list) throws NumberFormatException {
        list.stream()
                // # split each line by comma delimiter and return the new stream
                .map(line -> line.split(","))
                // # filter out possible entries that don't match the required num of columns
                .filter(parts -> parts.length >= 5)
                // # sort in place using a comparator function with Double.compare() to order by
                // literacy rate %
                .sorted((a, b) -> {
                    return Double.compare(Double.parseDouble(a[5]), Double.parseDouble(b[5]));
                    // * returns a stream of sorted lines as arrays of parts
                    // * parts[0] = "Adult literacy rate"
                    // * parts[1] = "population 15+ years"
                    // * parts[2] = "gender (%)"
                    // * parts[3] = "Country"
                    // * parts[4] = (int) year
                    // * parts[5] = (double) literacy rate

                }).forEach(parts -> System.out.printf("%s (%d), %s, %s%n", parts[3].trim(), Integer.valueOf(parts[4]),
                        parts[2].split(" ")[1],
                        Double.valueOf(parts[5]).toString()));

    }
}
