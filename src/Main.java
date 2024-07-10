import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);


        System.out.println("Choose a valid option: ");


        do{


            System.out.println("""
                    0.- Exit
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
                    """);
            var option = keyboard.nextInt();
            switch (option){

                case 0:
                    break;
                case 1:

            } while(option != 0)

            System.out.println("Insert the amount you want to convert");
            var amount = keyboard.nextInt();
            if (amount > 0){
                CurrencyConsult consult = new CurrencyConsult();
                CurrencyValue currency =  consult.searchCurrencys("USD", "MXN");
                BigDecimal currencyAmount = currency.getConversionRate();
                System.out.println(currencyAmount.multiply(BigDecimal.valueOf(amount)));
            } else
                System.out.println("Invalid number");
        }









    }
}