/**
 * 
 */
package abcbank.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import abcbank.LoanCalculator;

/**
 * @author 1141669
 *
 */
public class LoanCalculatorApp {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		double loanAmount;
		double interestRate;
		int numOfYears;
		
		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
		
		LoanCalculator calc = new LoanCalculator();;
				
		try {
			System.out.printf("%-20s", "Loan Amount:");
			loanAmount = Double.parseDouble(userInput.readLine());
			calc.setLoanAmount(loanAmount);
			
			System.out.printf("%-20s", "Number of Years:");
			numOfYears = Integer.parseInt(userInput.readLine());
			calc.setNumberOfYears(numOfYears);
			
			System.out.printf("%-20s", "Interest Rate:");
			interestRate = Double.parseDouble(userInput.readLine());
			calc.setYearlyInterestRate(interestRate);
		} catch (NumberFormatException nfe) {
			System.out.println("Please enter positive digits only.");
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}		
		
		System.out.printf("%-20s", "Monthly Payment:");
		System.out.printf("%.2f", calc.getMonthlyPayment());
		System.out.println();
		
		System.out.printf("%-20s", "Total Payment:");
		System.out.printf("%.2f", calc.getTotalCostOfLoan());
		System.out.println();
		
		System.out.printf("%-20s", "Total Interest:");
		System.out.printf("%.2f", calc.getTotalInterest());
		System.out.println();
		
		System.out.println("\nWritten by: Erika Bourque");
	}

}
