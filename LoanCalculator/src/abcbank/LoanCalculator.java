/**
 * Provides a Loan Calculator.
 */
package abcbank;

/**
 * Description of Loan Calculator
 * 
 * @author Erika Bourque
 * @version 1.0 Aug 27 2015
 *  
 */

public class LoanCalculator
{
	private double loanAmount;
	private int numberOfYears;
	private double yearlyInterestRate;
	
	/**
	 * Class Constructor 
	 */
	public LoanCalculator()
	{
	}
	
	/**
	 * Description of constructors
	 * 
	 * @param loanAmount
	 * @param numberOfYears
	 * @param yearlyInterestRate
	 * 
	 */
	public LoanCalculator(double loanAmount, int numberOfYears, double yearlyInterestRate)
	{
			this.loanAmount = loanAmount;
			this.numberOfYears = numberOfYears;
			this.yearlyInterestRate = yearlyInterestRate;
	}
	
	/**
	 * 	Method
	 * 	
	 *  @return
	 */
	public double getLoanAmount()
	{
		return loanAmount;
	}
	
	/**
	 * 	Method
	 * 	
	 *  @param
	 *  @param
	 *  @return
	 */
	public double getMonthlyPayment()
	{
		double monthlyPayment;
		double monthlyInterestRate;
		int numberOfMonths;
		
		monthlyInterestRate = (yearlyInterestRate / 12) / 100;
		numberOfMonths = numberOfYears * 12;
		
		monthlyPayment = (loanAmount * monthlyInterestRate) / 
				(1 - (1 / Math.pow(1 + monthlyInterestRate, numberOfMonths)));
		
		return monthlyPayment;
	}
	
	/**
	 * 	Method
	 * 	
	 *  @return
	 */
	public int getNumberOfYears()
	{
		return numberOfYears;
	}
	
	/**
	 * 	Method
	 * 	
	 *  @return
	 */
	public double getTotalCostOfLoan()
	{
		double totalCostofLoan;
		
		totalCostofLoan = getMonthlyPayment()*12*numberOfYears;
		return totalCostofLoan;
	}
	
	/**
	 * 	Method
	 * 	
	 *  @return
	 */
	public double getTotalInterest()
	{
		double totalInterest;
		
		totalInterest = getTotalCostOfLoan() - loanAmount;
				
		return totalInterest;
	}
	
	/**
	 * 	Method
	 * 	
	 *  @return
	 */
	public double getYearlyInterestRate()
	{
		return yearlyInterestRate;
	}
	
	/**
	 * 	Method
	 * 	
	 *  @param
	 */
	public void setLoanAmount(double loanAmount)
	{
		if (loanAmount > 0){
			this.loanAmount = loanAmount;
		}
		else{
			throw new IllegalArgumentException("Loan Amount Error - must be greater than zero."
					+ "  Invalid value");
		}
	}
	
	/**
	 * 	Method
	 * 	
	 *  @param
	 */
	public void setNumberOfYears(int numberOfYears)
	{
		if (numberOfYears > 0){
			this.numberOfYears = numberOfYears;
		}
		else{
			throw new IllegalArgumentException("Number of Years Error - must be greater than zero."
					+ "  Invalid value");
		}
	}
	
	/**
	 * 	Method
	 * 	
	 *  @param
	 */
	public void setYearlyInterestRate (double yearlyInterestRate)
	{
		if (yearlyInterestRate > 0){
			this.yearlyInterestRate = yearlyInterestRate;
		}
		else{
			throw new IllegalArgumentException("Yearly Interest Rate Error - must be greater than zero."
					+ "  Invalid value");
		}
	}
	
	/**
	 * 	Method
	 * 	
	 *  @return
	 */
	public String toString()
	{
		//add total cost of loan, total interest, monthly payment
		return "Loan Amount: " + loanAmount + "\nNumber Of Years: "
				+ numberOfYears + "\nYearly Interest Rate: " + yearlyInterestRate; 
	}
}
