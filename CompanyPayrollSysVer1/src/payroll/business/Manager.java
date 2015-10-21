package payroll.business;

import dw317.lib.Address;

public class Manager extends Salaried{

	private double yearlySalary;
	
	public Manager(String number, String firstName, String lastName,
			double salary, String department, Address address) {
		super(number, firstName, lastName, salary, department, address);
		yearlySalary = salary;
	}

}
