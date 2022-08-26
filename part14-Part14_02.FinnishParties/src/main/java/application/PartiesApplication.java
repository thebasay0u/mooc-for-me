package application;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.util.Pair;

public class PartiesApplication extends Application {

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        String file = "partiesdata.tsv";

        NumberAxis xAxis = new NumberAxis(1967, 2009, 4);

        NumberAxis yAxis = new NumberAxis(0, 30, 5);

        LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);
        chart.setTitle("Relative support of the parties");

        Map<String, Map<Integer, Double>> fileContents = readFileContents(file);
        // addDataToLineChart(fileContents, chart);
        fileContents.keySet().stream().forEach(party -> {
            // # create a different data set for each party
            XYChart.Series<Number, Number> data = new XYChart.Series<Number, Number>();
            data.setName(party);

            fileContents.get(party).entrySet().stream().forEach(pair -> {
                data.getData().add(new XYChart.Data<Number, Number>(pair.getKey(), pair.getValue()));

            });
            chart.getData().add(data);
        });

        Scene view = new Scene(chart, 640, 480);

        window.setScene(view);
        window.show();

    }

    // # String = Party Name
    // # Double =
    private Map<String, Map<Integer, Double>> readFileContents(String fileName) {

        Map<String, Map<Integer, Double>> fContents = new HashMap<>();

        ArrayList<Integer> years = new ArrayList<>();

        try (Scanner s = new Scanner(Paths.get(fileName))) {

            // # parse first line and add each year to array list
            String[] firstLine = s.nextLine().split("\t");
            for (int i = 1; i < firstLine.length; i++) {
                years.add(Integer.parseInt(firstLine[i]));
            }

            while (s.hasNext()) {

                String[] line = s.nextLine().split("\t");

                String party = line[0];
                int lineLength = line.length;
                HashMap<Integer, Double> values = new HashMap<>();

                for (int i = 1; i < lineLength; i++) {

                    if (!line[i].equals("-")) {
                        int year = years.get(i - 1);
                        double supportPercentage = Double.parseDouble(line[i]);
                        values.put(year, supportPercentage);

                    }

                }

                fContents.put(party, values);
                System.out.println("All values added");
            }

        } catch (Exception e) {

            e.printStackTrace();

        }
        return fContents;
    }

    // private void addDataToLineChart(Map<String, Map<Integer, Double>> contents,
    // LineChart<Number, Number> lineChart) {

    // contents.keySet().stream().forEach(party -> {
    // // # create a different data set for each party
    // XYChart.Series<Number, Number> data = new XYChart.Series<Number, Number>();
    // data.setName(party);

    // contents.get(party).entrySet().stream().forEach(pair -> {
    // data.getData().add(new XYChart.Data<Number, Number>(pair.getKey(),
    // pair.getValue()));

    // });
    // lineChart.getData().add(data);
    // });

    // }

}
