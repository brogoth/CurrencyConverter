package com.example;

import java.text.DecimalFormat;

public class CurrencyConverter {

    public static void main(String[] args) {
        // Run the conversion process and print the results
        String result = runConversion(args);
        System.out.println(result);
    }

    /**
     * This method performs currency conversion and returns the result as a string.
     * It handles invalid inputs and performs case-insensitive currency matching.
     *
     * @param args Command-line arguments: amount and currency type
     * @return A string containing the conversion results or error messages
     */
    public static String runConversion(String[] args) {
        StringBuilder output = new StringBuilder();

        // Validate arguments
        if (args.length < 2) {
            output.append("Error: Please provide the amount and currency type.");
            return output.toString();
        }

        double amount;
        try {
            // Parse the first argument as a numeric value
            amount = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            output.append("Error: Amount must be a valid number.");
            return output.toString();
        }

        // Convert the currency type to lowercase for case-insensitive comparison
        String currency = args[1].toLowerCase();
        DecimalFormat formatter = new DecimalFormat("##.##");
        DecimalFormat amountFormatter = new DecimalFormat("###");

        String formattedAmount = amountFormatter.format(amount);

        // Perform conversions based on the currency type
        switch (currency) {
            case "dollars":
                double pound = amount * 0.74;
                output.append(amount).append(" Dollars = ").append(formatter.format(pound)).append(" Pounds\n");
                double euro = amount * 0.88;
                output.append(amount).append(" Dollars = ").append(formatter.format(euro)).append(" Euros");
                break;
            case "pounds":
                double dollar = amount * 1.36;
                output.append(amount).append(" Pounds = ").append(formatter.format(dollar)).append(" Dollars\n");
                euro = amount * 1.19;
                output.append(amount).append(" Pounds = ").append(formatter.format(euro)).append(" Euros");
                break;
            case "euros":
                dollar = amount * 1.13;
                output.append(amount).append(" Euros = ").append(formatter.format(dollar)).append(" Dollars\n");
                pound = amount * 0.84;
                output.append(amount).append(" Euros = ").append(formatter.format(pound)).append(" Pounds");
                break;
            default:
                // Handle unsupported currencies
                output.append("Error: Unsupported currency type. Please use 'dollars', 'pounds', or 'euros'.");
        }

        return output.toString();
    }
}
