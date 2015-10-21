/**
 * 
 */
package payroll.business;

import dw317.lib.Address;

/**
 * @author C. Legendre
 *
 */
public class Salaried extends Employee{

	private double yearlySalary;
		
	public Salaried(String number, String firstName, String lastName, 
					double salary, String department, Address address)
	{
		super(number,firstName,lastName,department,address);
		yearlySalary = salary;
	}
	
	public double getYearlySalary() {
		return yearlySalary;
	}

	public void setYearlySalary(double yearlySalary) {
		this.yearlySalary = yearlySalary;
	}
	
	public double getWeeklyGrossPay() {
		double weeklyGrossPay;
		weeklyGrossPay = getYearlySalary() / 52;
		weeklyGrossPay = Math.round(weeklyGrossPay * 100) / 100.0;
		return weeklyGrossPay;
	}

}
