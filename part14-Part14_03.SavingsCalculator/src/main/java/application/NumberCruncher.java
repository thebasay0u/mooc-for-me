package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javafx.scene.chart.LineChart;

public class NumberCruncher {

    // private HashMap<Integer, Double> _savingsAmounts;

    public NumberCruncher() {

    }

    // public ArrayList<Double> getCompoundSavings(double amountToSaveMonthly) {
    // double yearlySum = 12 * amountToSaveMonthly;

    // ArrayList<Double> compoundSums = new ArrayList<>();

    // // double runningSum = yearlySum;

    // for (int year = 0; year <= 30; year++) {
    // compoundSums.add(year * yearlySum);

    // }

    // return compoundSums;

    // }

    // public ArrayList<Double> getCompoundSavingsPlusInterest(double
    // amountToSaveMonthly,
    // double yearlyInterestRate) {
    // double actualyearlyInterestRate = yearlyInterestRate / 100;

    // ArrayList<Double> compoundSavingsAndInterest =
    // getCompoundSavings(amountToSaveMonthly)
    // .stream()
    // .map((amount -> amount + (amount * actualyearlyInterestRate)))
    // .collect(Collectors.toCollection(ArrayList::new));
    // for (double d : compoundSavingsAndInterest) {
    // System.out.println("Amount = " + d);
    // }

    // return compoundSavingsAndInterest;

    // }

    public Map<Integer, Double> calculateSavings(double amountToSaveMonthly) {

        Map<Integer, Double> savingsMap = new HashMap<>();
        // # amount saved each year
        double amountSavedYearly = amountToSaveMonthly * 12;
        double runningTotal = 0;

        for (int year = 0; year <= 30; year++) {

            savingsMap.put(year, amountSavedYearly * year);
            // System.out.println("Year : " + year);

            runningTotal += amountSavedYearly;
            // System.out.println("Adding " + amountSavedYearly);
            // System.out.println("New total: " + runningTotal);
        }

        return savingsMap;

    }

    public Map<Integer, Double> calculateInterest(double monthlySavingsAmount,
            double yearlyInterestRate) {

        Map<Integer, Double> savingsMap = calculateSavings(monthlySavingsAmount);

        // ArrayList<Double> compoundSavings = getCompoundSavings(monthlySavingsAmount);
        Map<Integer, Double> interestMap = new HashMap<>();
        double yearlyPrincipal = monthlySavingsAmount * 12;
        double actualYearlyRate = yearlyInterestRate / 100;

        final double interestMultiplier = 1 + actualYearlyRate;

        double runningTotal = 0;

        for (int year = 0; year <= 30; year++) {
            if (year == 0) {
                interestMap.put(year, yearlyPrincipal * year);
                // runningTotal += yearlyPrincipal;
                continue;

            } else {

                runningTotal += yearlyPrincipal;
                double interest = actualYearlyRate * runningTotal;
                runningTotal += interest;
                // # amount that will be added to map (includes interest)

                interestMap.put(year, runningTotal);

            }

            // System.out.println("Interest rate: " + yearlyInterestRate + "%" + " --- " +
            // capitalizedWithInterest);

        }
        return interestMap;
    }

}
