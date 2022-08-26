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

    public ArrayList<Double> getCompoundSavings(double amountToSaveMonthly) {
        double yearlySum = 12 * amountToSaveMonthly;

        ArrayList<Double> compoundSums = new ArrayList<>();

        // double runningSum = yearlySum;

        for (int year = 0; year <= 30; year++) {
            compoundSums.add(year * yearlySum);

        }

        return compoundSums;

    }

    public ArrayList<Double> getCompoundSavingsPlusInterest(double amountToSaveMonthly,
            double interestRate) {
        double actualInterestRate = interestRate / 100;

        ArrayList<Double> compoundSavingsAndInterest = getCompoundSavings(amountToSaveMonthly)
                .stream()
                .map((amount -> amount + (amount * actualInterestRate)))
                .collect(Collectors.toCollection(ArrayList::new));
        for (double d : compoundSavingsAndInterest) {
            System.out.println("Amount = " + d);
        }

        return compoundSavingsAndInterest;

    }

    public Map<Integer, Double> calculateInterest(int numYears, double savingsAmount, double interestRate) {

        ArrayList<Double> compoundSavings = getCompoundSavings(savingsAmount);
        Map<Integer, Double> interestMap = new HashMap<>();
        double yearlyPrincipal = savingsAmount * 12;

        for (int i = 0; i < compoundSavings.size(); i++) {
            interestMap.put(i, yearlyPrincipal);
            if (i > 0) {
                double previousYearsAmount = interestMap.get(i - 1);
                double capitalizedWithInterest = previousYearsAmeount + (previousYearsAmount * (interestRate / 100));
                System.out.println("Interest rate: " + interestRate + "%" + " --- " + capitalizedWithInterest);
                interestMap.put(i, capitalizedWithInterest);
            }

        }
        return interestMap;
    }

}
