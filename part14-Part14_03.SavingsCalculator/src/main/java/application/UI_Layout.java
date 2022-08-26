package application;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Pair;
import javafx.util.StringConverter;

public class UI_Layout {

    private BorderPane _root;

    private NumberCruncher _helper;
    private UI_Components _components;

    private double _currentSavingsAmount;
    private double _currentInterestAmount;

    private XYChart.Series<Number, Number> _savingsData;
    private XYChart.Series<Number, Number> _interestPlusSavingsData;

    // private ArrayList<Double> _compoundSavings;
    // private ArrayList<Double> _compoundInterest;

    // private VBox _chartHolder;

    public UI_Layout() {

        this._helper = new NumberCruncher();
        this._components = new UI_Components();
        this._root = new BorderPane();

        this._savingsData = new XYChart.Series<>();
        this._interestPlusSavingsData = new XYChart.Series<>();

        this._currentSavingsAmount = 25;
        this._currentInterestAmount = 0;

        // # create ArrayList of double values to hold yearly amounts, to be updated by
        // listener
        // this._compoundSavings = _helper.getCompoundSavings(25);
        // this._compoundInterest = _helper.getCompoundSavingsPlusInterest(25, 0);

        _root.setTop(buildVBox());

        LineChart<Number, Number> chart = savingsGrowthChart();
        chart.getData().add(_savingsData);
        chart.getData().add(_interestPlusSavingsData);

        updateSavingsChart(this.getCurrentSavingsAmount(), _savingsData);
        updateInterestChart(getCurrentInterestAmount(), _interestPlusSavingsData);
        _root.setCenter(chart);

    }

    // ! PUBLIC METHODS
    public BorderPane getLayout() {
        return this._root;
    }

    private double getCurrentSavingsAmount() {
        return this._currentSavingsAmount;
    }

    private double getCurrentInterestAmount() {
        return this._currentInterestAmount;
    }

    private VBox buildVBox() {
        VBox vBox = new VBox(15);
        vBox.setPadding(new Insets(5, 10, 20, 10));

        BorderPane savingsPane = savingsPane();

        BorderPane interestPane = interestPane();

        vBox.getChildren().addAll(savingsPane, interestPane);

        return vBox;

    }

    private void updateSavingsChart(double value, XYChart.Series<Number, Number> chartSeries) {
        chartSeries.getData().clear();
        AtomicInteger yearCounter = new AtomicInteger();
        ArrayList<Double> compoundSavings = _helper.getCompoundSavings(value);
        compoundSavings.stream().forEach(savingsAmount -> {
            chartSeries.getData().add(new XYChart.Data<Number, Number>(yearCounter.getAndIncrement(), savingsAmount));
        });

    }

    private void updateInterestChart(double interestAmount,
            XYChart.Series<Number, Number> chartSeries) {
        chartSeries.getData().clear();
        // AtomicInteger yearCounter = new AtomicInteger();
        Map<Integer, Double> interestMap = _helper.calculateInterest(30, getCurrentSavingsAmount(), interestAmount);

        for (Integer i : interestMap.keySet()) {
            chartSeries.getData().add(new XYChart.Data<Number, Number>(i, interestMap.get(i)));
        }

    }

    private BorderPane savingsPane() {
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(5, 5, 5, 5));

        Label left = new Label("Monthly savings");
        Label right = new Label("25");
        Slider slider = _components.getSavingsSlider();

        slider.valueProperty().addListener((obs, oldValue, newValue) -> {
            if (!slider.isValueChanging()) {
                right.setText(String.format("%.2f", slider.getValue()));
                updateSavingsChart(newValue.doubleValue(), _savingsData);
                updateInterestChart(getCurrentInterestAmount(), _interestPlusSavingsData);

            }
        });

        slider.valueChangingProperty().addListener((obs, wasChanging, isCurrentlyChanging) -> {
            if (!isCurrentlyChanging) {
                right.setText(String.format("%.2f", slider.getValue()));
                updateSavingsChart(slider.getValue(), _savingsData);
            }
        });

        pane.setLeft(left);
        pane.setRight(right);
        pane.setCenter(slider);

        return pane;

    }

    private BorderPane interestPane() {
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(5, 5, 5, 5));

        Label left = new Label("Yearly interest rate");
        Label right = new Label("0");

        Slider slider = _components.getInterestSlider();

        slider.valueProperty().addListener((obs, oldValue, newValue) -> {
            if (!slider.isValueChanging()) {
                right.setText(String.format("%.1f", slider.getValue()));

                this._currentInterestAmount = newValue.doubleValue();
                updateInterestChart(newValue.doubleValue(), _interestPlusSavingsData);

            }
        });

        slider.valueChangingProperty().addListener((obs, wasChanging, isCurrentlyChanging) -> {
            if (!isCurrentlyChanging) {
                right.setText(String.format("%.2f", slider.getValue()));
                this._currentInterestAmount = slider.getValue();

            }
            updateInterestChart(slider.getValue(), _interestPlusSavingsData);
        });

        pane.setLeft(left);
        pane.setCenter(slider);
        pane.setRight(right);

        return pane;

    }

    private LineChart<Number, Number> savingsGrowthChart() {
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        LineChart<Number, Number> primaryChart = new LineChart<>(xAxis, yAxis);

        primaryChart.setTitle("Savings growth over time");

        primaryChart.setAnimated(false);
        primaryChart.setLegendVisible(false);

        return primaryChart;
    }

    // ! HELPER METHODS

}
