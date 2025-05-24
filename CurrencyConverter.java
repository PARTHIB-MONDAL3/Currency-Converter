import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// CurrencyConverter class demonstrating OOP principles
public class CurrencyConverter {
    private Map<String, Double> exchangeRates;

    public CurrencyConverter() {
        exchangeRates = new HashMap<>();
        // Fixed exchange rates
        exchangeRates.put("USD", 1.0);           // Base currency
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("GBP", 0.75);
        exchangeRates.put("INR", 74.5);
        exchangeRates.put("JPY", 110.0);
    }

    public boolean isValidCurrency(String currency) {
        return exchangeRates.containsKey(currency.toUpperCase());
    }

    public double convert(String from, String to, double amount) {
        double fromRate = exchangeRates.get(from.toUpperCase());
        double toRate = exchangeRates.get(to.toUpperCase());
        return (amount / fromRate) * toRate;
    }

    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Currency Converter");

        System.out.print("Enter source currency (e.g., USD): ");
        String from = scanner.nextLine().toUpperCase();
        if (!converter.isValidCurrency(from)) {
            System.out.println("Invalid source currency.");
            return;
        }

        System.out.print("Enter target currency (e.g., EUR): ");
        String to = scanner.nextLine().toUpperCase();
        if (!converter.isValidCurrency(to)) {
            System.out.println("Invalid target currency.");
            return;
        }

        System.out.print("Enter amount to convert: ");
        double amount;
        try {
            amount = Double.parseDouble(scanner.nextLine());
            if (amount < 0) {
                System.out.println("Amount must be non-negative.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount entered.");
            return;
        }

        double result = converter.convert(from, to, amount);
        System.out.printf("%.2f %s = %.2f %s\n", amount, from, result, to);
    }
}
