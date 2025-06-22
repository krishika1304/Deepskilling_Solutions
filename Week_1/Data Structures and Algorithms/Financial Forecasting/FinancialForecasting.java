package FinancialForecasting;
import java.util.*;
public class FinancialForecasting {
	public static double computeFutureValue(double presentValue, double interestRate, int years) {
        if (years == 0) return presentValue;
        return computeFutureValue(presentValue, interestRate, years - 1) * (1 + interestRate);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the present value:");
        double presentValue = sc.nextDouble();

        System.out.println("Enter the interest rate (as a decimal):");
        double interestRate = sc.nextDouble();

        System.out.println("Enter the number of years:");
        int years = sc.nextInt();

        double futureValue = computeFutureValue(presentValue, interestRate, years);
        System.out.printf("Future Value: %.2f", futureValue);
        sc.close();
    }
}
