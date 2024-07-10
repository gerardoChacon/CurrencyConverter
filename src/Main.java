import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        int option;

        do {
            System.out.println("""
                    1.- USD => MXN
                    2.- MXN => USD
                    3.- MXN => ARS
                    4.- ARS => MXN
                    5.- USD => ARS
                    6.- ARS => USD
                    7.- MXN => BRL
                    8.- BRL => MXN
                    9.- USD => BRL
                    10.-BRL => USD
                    11.-Exit
                    """);
            option = keyboard.nextInt();

            // Handle exit immediately
            if (option == 0) break;

            // Perform conversion if option is valid
            if (option > 0 && option <= 10) {
                handleOption(option);
            } else {
                System.out.println("Please select a valid option.");
            }

        } while (option != 11);

        keyboard.close();
    }

    private static void handleOption(int option) {
        String baseCurrency = "", targetCurrency = "";

        switch (option) {
            case 1 -> { baseCurrency = "USD"; targetCurrency = "MXN"; }
            case 2 -> { baseCurrency = "MXN"; targetCurrency = "USD"; }
            case 3 -> { baseCurrency = "MXN"; targetCurrency = "ARS"; }
            case 4 -> { baseCurrency = "ARS"; targetCurrency = "MXN"; }
            case 5 -> { baseCurrency = "USD"; targetCurrency = "ARS"; }
            case 6 -> { baseCurrency = "ARS"; targetCurrency = "USD"; }
            case 7 -> { baseCurrency = "MXN"; targetCurrency = "BRL"; }
            case 8 -> { baseCurrency = "BRL"; targetCurrency = "MXN"; }
            case 9 -> { baseCurrency = "USD"; targetCurrency = "BRL"; }
            case 10 -> { baseCurrency = "BRL"; targetCurrency = "USD"; }
        }


        if (!baseCurrency.isEmpty()) {
            performConversion(baseCurrency, targetCurrency);
        }
    }

    private static void performConversion(String baseCurrency, String targetCurrency) {
        System.out.println("Insert the amount you want to convert:");
        int amount = keyboard.nextInt();

        if (amount > 0) {
            CurrencyConsult consult = new CurrencyConsult();
            CurrencyValue currency = consult.searchCurrencys(baseCurrency, targetCurrency);
            BigDecimal currencyAmount = currency.getConversionRate();
            System.out.println("Converted Amount: $" + currencyAmount.multiply(BigDecimal.valueOf(amount)));
        } else {
            System.out.println("Invalid number");
        }
    }
}
