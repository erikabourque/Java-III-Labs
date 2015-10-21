/**
 * 
 */
package payroll.business;

import dw317.lib.Address;

/**
 * @author C. Legendre
 *
 */
public class Hourly extends Employee
{
	private String paycode;
	private double hours;
	
	public Hourly (String number, String firstName, String lastName, double hours,
			       String paycode, String department, Address address)
	{
		super(number, firstName, lastName, department, address);
		this.hours = hours;
		this.paycode = paycode;
	}

	public double getHours() {
		return hours;
	}

	public String getPaycode() {
		return paycode;
	}
	
	public double getWeeklyGrossPay()
	{
		double weeklyGrossPay;
		//We will ignore the pay code for now
		weeklyGrossPay = 7.86 * getHours();
		weeklyGrossPay = Math.round(weeklyGrossPay * 100) / 100.0;
		return weeklyGrossPay;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	public void setPaycode(String paycode) {
		this.paycode = paycode;
	}
}
