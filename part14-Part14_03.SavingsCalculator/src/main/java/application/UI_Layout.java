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

    private XYChart.Series<Number, Number> _savingsSeries;
    private XYChart.Series<Number, Number> _interestPlusSavingsSeries;

    // private ArrayList<Double> _compoundSavings;
    // private ArrayList<Double> _compoundInterest;

    // private VBox _chartHolder;

    public UI_Layout() {

        this._helper = new NumberCruncher();
        this._components = new UI_Components();
        this._root = new BorderPane();

        this._savingsSeries = new XYChart.Series<>();
        this._interestPlusSavingsSeries = new XYChart.Series<>();

        this._currentSavingsAmount = 25;
        this._currentInterestAmount = 0;

        // # create ArrayList of double values to hold yearly amounts, to be updated by
        // listener
        // this._compoundSavings = _helper.getCompoundSavings(25);
        // this._compoundInterest = _helper.getCompoundSavingsPlusInterest(25, 0);

        _root.setTop(buildVBox());

        LineChart<Number, Number> chart = savingsGrowthChart();
        chart.getData().add(_savingsSeries);
        chart.getData().add(_interestPlusSavingsSeries);

        updateSavingsChart(getCurrentSavingsAmount(), _savingsSeries);
        // updateInterestChart(getCurrentInterestAmount(), _interestPlusSavingsSeries);
        _root.setCenter(chart);

    }

    private void setCurrentSavingsAmount(double amountToSaveMonthly) {
        this._currentSavingsAmount = amountToSaveMonthly;
    }

    private void setCurrentInterestRate(double interestRate) {
        this._currentInterestAmount = interestRate;
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

    private void updateSavingsChart(double currentSavingsAmount, XYChart.Series<Number, Number> chartSeries) {
        chartSeries.getData().clear();
        // AtomicInteger yearCounter = new AtomicInteger();
        // ArrayList<Double> compoundSavings = _helper.getCompoundSavings(value);
        Map<Integer, Double> simpleSavings = _helper.calculateSavings(currentSavingsAmount);
        // compoundSavings.stream().forEach(savingsAmount -> {
        // chartSeries.getData().add(new XYChart.Data<Number,
        // Number>(yearCounter.getAndIncrement(), savingsAmount));
        // });
        simpleSavings.keySet().stream()
                .forEach(year -> {
                    chartSeries.getData().add(new XYChart.Data<Number, Number>(year, simpleSavings.get(year)));
                });

    }

    private void updateInterestChart(double savingsAmount, double interestAmount,
            XYChart.Series<Number, Number> chartSeries) {
        chartSeries.getData().clear();
        // AtomicInteger yearCounter = new AtomicInteger();
        Map<Integer, Double> interestMap = _helper.calculateInterest(getCurrentSavingsAmount(), interestAmount);

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
            if (!slider.isValueChanging() && getCurrentInterestAmount() > 0) {
                right.setText(String.format("%.2f", slider.getValue()));
                updateSavingsChart(newValue.doubleValue(), _savingsSeries);

                setCurrentSavingsAmount(Double.parseDouble(String.format("%.2f", slider.getValue())));
                updateInterestChart(getCurrentSavingsAmount(), getCurrentInterestAmount(), _interestPlusSavingsSeries);

            }
        });

        slider.valueChangingProperty().addListener((obs, wasChanging, isCurrentlyChanging) -> {
            if (!isCurrentlyChanging) {
                right.setText(String.format("%.2f", slider.getValue()));
                updateSavingsChart(slider.getValue(), _savingsSeries);
                setCurrentSavingsAmount(Double.parseDouble(String.format("%.2f", slider.getValue())));
                if (getCurrentInterestAmount() > 0) {
                    updateInterestChart(getCurrentSavingsAmount(), getCurrentInterestAmount(),
                            _interestPlusSavingsSeries);
                }

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
            if (!slider.isValueChanging() && slider.getValue() > 0) {
                right.setText(String.format("%.1f", slider.getValue()));
                setCurrentInterestRate(newValue.doubleValue());
                ;
                updateInterestChart(getCurrentSavingsAmount(), getCurrentInterestAmount(), _interestPlusSavingsSeries);

            }
        });

        slider.valueChangingProperty().addListener((obs, wasChanging, isCurrentlyChanging) -> {
            if (!isCurrentlyChanging) {
                right.setText(String.format("%.2f", slider.getValue()));
                setCurrentInterestRate(slider.getValue());
                if (getCurrentInterestAmount() > 0)
                    updateInterestChart(getCurrentSavingsAmount(), getCurrentInterestAmount(),
                            _interestPlusSavingsSeries);

            }

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
