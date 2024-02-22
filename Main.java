import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double[] numbers = new double[20];
        int i = 0;
        do{
            System.out.println("Enter numbers for the array: ");
            Scanner sc = new Scanner(System.in);
            double doubleValue = sc.nextDouble();
            if(doubleValue == 9999)
                break;
            numbers[i] = doubleValue;
            i++;
        }while (i < 20);
        System.out.println("These are the numbers you entered: " + Arrays.toString(numbers));
}}