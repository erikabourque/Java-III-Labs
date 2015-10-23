/**
 * 
 */
package abcbank;

/**
 * @author Erika Bourque
 *
 */
public class LoanCalculatorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		double loanAmount = 1000.0;
		int numberOfYears = 3;
		double yearlyInterestRate = 2.5;
		
		LoanCalculator myLoan = new LoanCalculator(loanAmount, numberOfYears, yearlyInterestRate);
		
		System.out.println("Hi.");
		System.out.println("My loan is of " + myLoan.getLoanAmount() + " dollars.");
		System.out.println("My loan is for " + myLoan.getNumberOfYears() + " years.");
		System.out.println("My interest rate is " + myLoan.getYearlyInterestRate() + "% each year.");
		System.out.println(myLoan.toString());
		
		System.out.println("My monthly payment is " + myLoan.getMonthlyPayment() + " dollars.");
		System.out.println("My total cost is " + myLoan.getTotalCostOfLoan());
		System.out.println("My total interest is " + myLoan.getTotalInterest());
		
		try{
			double newLoan = 5;
			myLoan.setLoanAmount(newLoan);
			System.out.print("My new loan is: " + myLoan.getLoanAmount());
		}
		catch(IllegalArgumentException iae){
			System.out.print(iae.getMessage());
		}
	}

}
