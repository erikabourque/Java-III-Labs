package payroll.application;

import java.util.Optional;

import payroll.business.Employee;
import payroll.business.Hourly;
import payroll.business.Salaried;
import dw317.lib.Address;

/**
 * @author C. Legendre
 * 
 */
public class PayrollApp {

	/**
	 * @param args
	 */
	
public static void displayPayrollDetails(Employee employee)
{	
	System.out.println(employee.getName().getFullName() 
					   +"  (" + employee.getNumber() 
					   + ")\n"
					   + "works in the " + employee.getDepartment() 
					   + " department,"
	                   + "\nmakes " + employee.getWeeklyGrossPay() 
	                   + " gross per week,"
	                   + "\nresides at:\n" +
	                  (employee.getAddress().getCivicNumber().isEmpty() ?
	                		  "UNKNOWN ADDRESS" :
	                		  employee.getAddress().getAddress()) + "\n");
}

public static void main(String[] args) {
	Employee [] employeeList = new Employee [10];
	
	employeeList [0] = 
		new Salaried("E123","Chantal", "Leclair", 36000,"D1",
			new Address("314", "Maple","Montreal",
			Optional.of("Quebec"),Optional.of("H3N1C2")));
		
	employeeList [1] = new Hourly("E768","Peter", "Smith", 10, "C1", "D6",
			new Address("1165","Sherbrooke West, Apt 1034","Montreal",
			Optional.of("Quebec"),Optional.of("H3N1R3")));
	
	employeeList [2] = 
			new Salaried("E230","Robert", "Thomson", 41750,"D2",
				new Address("275", "Clifton","Otterburn Park",
				Optional.of("Quebec"),Optional.of("J3G1Y4")));
	
	employeeList [3] = 
			new Salaried("E175","Susan", "Brown", 27500,"D1",
				new Address("1175", "Peel, Apt 17","Montreal",
				Optional.of("Quebec"),Optional.of("H3N1R5")));
		
	for (Employee employee : employeeList)
	{	
		if (employee == null)
			break;
		displayPayrollDetails(employee);
	}	
  }//end main

}//end PayrollApp class
