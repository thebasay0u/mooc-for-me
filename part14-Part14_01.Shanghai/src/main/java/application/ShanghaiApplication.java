package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Pair;

public class ShanghaiApplication extends Application {

    public static void main(String[] args) throws Exception {

        launch(ShanghaiApplication.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        String fName = "rankings.txt";
        // create the x and y axes that the chart is going to use
        NumberAxis xAxis = new NumberAxis(2006, 2018, 1);
        NumberAxis yAxis = new NumberAxis(0, 100, 5);
        init();
        HashMap<Integer, Integer> contents = readFile(fName);

        // set the titles for the axes
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");
        // xAxis.setTickMarkVisible(true);
        xAxis.setMinorTickCount(5);
        yAxis.setMinorTickCount(5);

        // yAxis.setTickMarkVisible(true);

        // create the line chart. The values of the chart are given as numbers
        // and it uses the axes we created earlier
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University Of Helsinki, Shanghai ranking");
        lineChart.setVerticalZeroLineVisible(true);

        // lineChart.setVerticalGridLinesVisible(true);
        // lineChart.setHorizontalGridLinesVisible(true);

        // create the data set that is going to be added to the line chart
        XYChart.Series helsinkiRankings = new XYChart.Series();
        helsinkiRankings.setName("University of Helsinki");
        // and single points into the data set
        // addDataFromMap(contents, helsinkiRankings);
        helsinkiRankings.getData().add(new XYChart.Data<Integer, Integer>(2007, 73));
        helsinkiRankings.getData().add(new XYChart.Data<Integer, Integer>(2008, 68));
        helsinkiRankings.getData().add(new XYChart.Data<Integer, Integer>(2009, 72));
        helsinkiRankings.getData().add(new XYChart.Data<Integer, Integer>(2009, 72));
        helsinkiRankings.getData().add(new XYChart.Data<Integer, Integer>(2010, 72));
        helsinkiRankings.getData().add(new XYChart.Data<Integer, Integer>(2011, 74));
        helsinkiRankings.getData().add(new XYChart.Data<Integer, Integer>(2012, 73));
        helsinkiRankings.getData().add(new XYChart.Data<Integer, Integer>(2013, 76));
        helsinkiRankings.getData().add(new XYChart.Data<Integer, Integer>(2014, 73));
        helsinkiRankings.getData().add(new XYChart.Data<Integer, Integer>(2015, 67));
        helsinkiRankings.getData().add(new XYChart.Data<Integer, Integer>(2016, 56));
        helsinkiRankings.getData().add(new XYChart.Data<Integer, Integer>(2017, 56));

        // add the data set to the line chart
        lineChart.getData().add(helsinkiRankings);

        // display the line chart
        Scene view = new Scene(lineChart, 640, 480);
        primaryStage.setScene(view);
        primaryStage.show();

    }

    public HashMap<Integer, Integer> readFile(String fileName) throws Exception {
        HashMap<Integer, Integer> fileContents = new HashMap<>();
        try (Scanner scanner = new Scanner(Paths.get(fileName))) {

            System.out.println("Starting to read from file...");
            while (scanner.hasNextLine()) {
                String[] row = scanner.nextLine().split(":");
                // # Map is year : ranking
                fileContents.put(Integer.parseInt(row[0]), Integer.parseInt(row[1]));
                // System.out.println("Adding year: " + row[0]);
                // System.out.println("Adding ranking: " + row[1]);

            }
            return fileContents;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileContents;

    }

    public void addDataFromMap(HashMap<Integer, Integer> fileData, XYChart.Series seriesData) throws Exception {

        for (Map.Entry<Integer, Integer> entry : fileData.entrySet()) {
            seriesData.getData().addAll(new XYChart.Data<Integer, Integer>(entry.getKey(), entry.getValue()));
            System.out.println("Adding year: " + entry.getKey());
            System.out.println("Adding ranking: " + entry.getValue());
        }

    }

}
