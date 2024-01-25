import java.text.DecimalFormat;
import java.util.*;
import static java.lang.Math.floor;

public class Main {
    private static final DecimalFormat wholefor = new DecimalFormat("0");
    public static void main(String[] args) {
        // assigns each variable to a double format
        double amount;
        double dollars;
        double remainder;
        double quarters;
        double dimes;
        double nickels;
        double pennies;
        double hundreddollars;
        double fiftydollars;
        double twentydollars;
        double tendollars;
        double fivedollars;

        // uses scanner to get the input amount to convert
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the amount: ");
        amount = sc.nextDouble();

        // checks to see how many hundred dollar bills there are
        hundreddollars = amount / 100;
        // returns the remainder after dividing by 100 and is stored in the variable "remainder"
        remainder = amount % 100;
        //prints "Hundred Dollar Bills: " followed by the amount of them
        System.out.println("Hundred Dollar Bills: " + wholefor.format(floor(hundreddollars)));

        // FIFTY DOLLAR BILLS
        fiftydollars = remainder / 50;
        remainder = remainder % 50;
        System.out.println("Fifty Dollar Bills: " + wholefor.format(floor(fiftydollars)));

        // TWENTY DOLLAR BILLS
        twentydollars = remainder / 20;
        remainder = remainder % 20;
        System.out.println("Twenty Dollar Bills: " + wholefor.format(floor(twentydollars)));

        // TEN DOLLAR BILLS
        tendollars = remainder / 10;
        remainder = remainder % 10;
        System.out.println("Ten Dollar Bills: " + wholefor.format(floor(tendollars)));

        // FIVE DOLLAR BILLS
        fivedollars = remainder / 5;
        remainder = remainder % 5;
        System.out.println("Five Dollar Bills: " + wholefor.format(floor(fivedollars)));

        // ONE DOLLAR BILLS
        dollars = remainder / 1;
        remainder = remainder % 1;
        System.out.println("One Dollar Bills: " + wholefor.format(floor(dollars)));

        // QUARTERS
        quarters = remainder / 0.25;
        remainder =  remainder % 0.25;
        System.out.println("Quarters: " + wholefor.format(floor(quarters)));

        // DIMES
        dimes = remainder / 0.10;
        remainder =  remainder % 0.10;
        System.out.println("Dimes: " + wholefor.format(floor(dimes)));

        // NICKELS
        nickels = remainder / 0.05;
        remainder =  remainder % 0.05;
        System.out.println("Nickels: " + wholefor.format(floor(nickels)));

        // PENNIES
        pennies = remainder / 0.01;
        System.out.println("Pennies: " + wholefor.format(floor(pennies)));
    sc.close();
        }
    }