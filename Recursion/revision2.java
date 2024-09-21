package Recursion;

import java.util.Scanner;

public class revision2 {

    // Print Counting
    public static void printCounting(int start, int end) {
        if (start > end) {
            return;
        }
        System.out.print(start + " ");
        start++;
        printCounting(start, end);
    }

    // Recursive method to calculate the sum of first n natural numbers
    public static int calculateSumOfnNaturalNumbers(int n) {
        if (n <= 0) {
            return 0; // Base case: sum of first 0 natural numbers is 0
        }
        return n + calculateSumOfnNaturalNumbers(n - 1); // Recursive case
    }

    // Calculate the factorial of n
    public static int calculateFactorial(int n) {
        if (n == 1 || n == 0) {
            return 1; // Base case
        }
        return n * calculateFactorial(n - 1); // Recursive case
    }

    // Print Fibonacci sequence till nth term
    public static void calculateFibonacciSequence(int a, int b, int n) {
        if (n == 0) {
            return;
        }
        int c = a + b; // Fibonacci number calculation
        System.out.print(c + " ");
        calculateFibonacciSequence(b, c, n - 1);
    }

    // Calculate x raised to the power of n
    public static int calculatePower(int x, int n) {
        if (n == 0) {
            return 1; // Base case: x^0 = 1
        }
        return x * calculatePower(x, n - 1); // Recursive case
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Code for counting
        System.out.println("Enter start:");
        int start = sc.nextInt();
        System.out.println("Enter end:");
        int end = sc.nextInt();
        printCounting(start, end);

        // Code for sum of first n natural numbers
        System.out.println("Enter value of n to calculate sum of first n natural numbers:");
        int n = sc.nextInt();
        int sum = calculateSumOfnNaturalNumbers(n);
        System.out.println("Sum of first " + n + " natural numbers is: " + sum);

        // Print Factorial of a number n
        System.out.println("Enter value of n to calculate factorial:");
        int n2 = sc.nextInt();
        int fact = calculateFactorial(n2);
        System.out.println("Factorial of " + n2 + " is: " + fact);

        // Print Fibonacci sequence till nth term
        System.out.println("Enter value of n to print Fibonacci sequence till nth term:");
        int n3 = sc.nextInt();
        System.out.print("Fibonacci sequence till " + n3 + " term is: ");
        System.out.print(0 + " " + 1 + " "); // Printing first two terms
        calculateFibonacciSequence(0, 1, n3 - 2);

        // Calculate x raised to the power of n
        System.out.println("\nEnter base value x to calculate x^n:");
        int x = sc.nextInt();
        System.out.println("Enter exponent value n:");
        int n4 = sc.nextInt();
        int power = calculatePower(x, n4);
        System.out.println(x + " raised to the power of " + n4 + " is: " + power);

        sc.close();
    }
}
