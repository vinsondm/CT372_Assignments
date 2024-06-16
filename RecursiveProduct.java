import java.util.Scanner;

public class RecursiveProduct {
    
    // Recursive method to calculate the product of numbers in the array
    public static int product(int[] numbers, int n) {
        // Base case: if end of array, return 1
        if (n == 0) {
            return 1;
        }
        // Recursive case: multiply last number with product of the rest
        return numbers[n - 1] * product(numbers, n - 1);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] numbers = new int[5];
        
        // Prompting for five user entered numbers
        System.out.println("Enter five numbers:");
        for (int i = 0; i < 5; i++) {
            numbers[i] = scanner.nextInt();
        }
        
        // Calculate the product of the numbers
        int result = product(numbers, numbers.length);
        
        // Display the result
        System.out.println("The product of the five numbers is: " + result);
        
        // Close the scanner
        scanner.close();
    }
}
