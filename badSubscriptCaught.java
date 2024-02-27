import java.util.Scanner;

public class badSubscriptCaught {
    public static void main(String[] args) {
        String[] names = {"Eddie", "Aris", "Sai", "Adrian", "Fergus", "Graham", "Jake", "Asher", "Ryan", "Tanner"};
        System.out.print("Enter an integer: ");
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        try {
            System.out.println("This is the name at the index you selected: " + names[value - 1]);
        }
        catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("The index is out of range.  Pick a number between 1 and 10");
        }
        catch (Exception ex) {
            System.out.println("We caught an exception.  Try another number!");
        }
    }
}