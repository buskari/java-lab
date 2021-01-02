package com.buskari;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        double mortgage;

        Scanner scanner = new Scanner( System.in );

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Interest Rate (annual): ");
        float annualInterestRate = scanner.nextFloat();
        float monthlyInterestRate = annualInterestRate / MONTHS_IN_YEAR / PERCENT;

        System.out.print("Periods (years): ");
        byte periodsInYears = scanner.nextByte();
        int periodsInMonths = periodsInYears * MONTHS_IN_YEAR;

        mortgage = principal
                * monthlyInterestRate * Math.pow((1 + monthlyInterestRate), periodsInMonths)
                / (Math.pow((1 + monthlyInterestRate), periodsInMonths) - 1);

        String mortgageCurrencyFormat = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageCurrencyFormat);
    }
}
