/**
 * 
 */
package dw317.payroll.business;

import static java.lang.System.out;
import payroll.business.Salaried;
import dw317.lib.Address;

/**
 * @author Erika Bourque
 *
 */
public class SalariedTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testConstructor();
		testSetName();
		testEquals();
	}
	
	public static void testConstructor() {
		out.print("\nTesting the Salaried constructor.\n");
		testConstructor("Case 1 - Valid data (John Doe)", "E100", "John", "Doe", 10000,
				"D1", new Address("3040", "Sherbrooke", "Westmount"), true);
		testConstructor("Case 2 - Invalid data � empty first name ( Doe)", "E100", "", "Doe", 10000,
				"D1", new Address("3040", "Sherbrooke", "Westmount"), false);
		testConstructor("Case 3 - Invalid data � empty last name (John  )", "E100", "John", "", 10000,
				"D1", new Address("3040", "Sherbrooke", "Westmount"), false);
		testConstructor("Case 4 - Valid data � first name trailing spaces (  John   Doe)", "E100", "  John   ", "Doe", 10000,
				"D1", new Address("3040", "Sherbrooke", "Westmount"), true);
		testConstructor("Case 5 - Valid data � last Name trailing spaces (John   Doe  )", "E100", "John", "  Doe  ", 10000,
				"D1", new Address("3040", "Sherbrooke", "Westmount"), true);
		testConstructor("Case 8 - Invalid data � null first name (null Doe)", "E100", null, "Doe", 10000,
				"D1", new Address("3040", "Sherbrooke", "Westmount"), false);
		testConstructor("Case 9 - Invalid data � null last Name (John null)", "E100", "John",
				null, 10000, "D1", new Address("3040", "Sherbrooke", "Westmount"), false);
		testConstructor("Case 10 - Valid data single character first name J Doe", "E100", "J", "Doe", 10000,
				"D1", new Address("3040", "Sherbrooke", "Westmount"), true);
		testConstructor("Case 11 - Valid data single character last name John D", "E100", "John", "D", 10000,
				"D1", new Address("3040", "Sherbrooke", "Westmount"), true);
		testConstructor("Case 12 - Invalid data number has no letter (1000)", "1000", "John", "Doe", 10000,
				"D1", new Address("3040", "Sherbrooke", "Westmount"), false);
		testConstructor("Case 13 - Invalid data number has no numbers (EEEE)", "EEEE", "John", "Doe", 10000,
				"D1", new Address("3040", "Sherbrooke", "Westmount"), false);
		testConstructor("Case 14 - Invalid data number not 4 chars (E10)", "E10", "John", "Doe", 10000,
				"D1", new Address("3040", "Sherbrooke", "Westmount"), false);
		testConstructor("Case 15 - Invalid data number null (null)", null, "John", "Doe", 10000,
				"D1", new Address("3040", "Sherbrooke", "Westmount"), false);
	}
	
	private static void testConstructor(String testCase, String number, 
			String firstName, String lastName, double salary, String department, 
			Address address, boolean expectValid) {

		out.print("\n" + testCase + "\n");

		try {
			Salaried thePerson = new Salaried(number, firstName, lastName, salary, department, address);
			out.print("\tThe Salaried instance was created: " + thePerson + "\n");

			if (!expectValid)
				out.print("  Error! Expected Invalid. ==== FAILED TEST ====");
		} catch (IllegalArgumentException iae) {
			out.print("\t" + iae.getMessage() + "\n");
			if (expectValid)
				out.print("  Error! Expected Valid. ==== FAILED TEST ====");
		} catch (Exception e) {
			out.print("\tUNEXPECTED EXCEPTION TYPE! " + e.getClass() + " "
					+ e.getMessage() + " ==== FAILED TEST ====");
			if (expectValid)
				out.print(" Expected Valid.");
		}
	}
	
	public static void testSetName() {
		out.print("\nTesting the setName method.\n");
		testSetName("Case 1: first name change without leading/trailing spaces", "Oliver", "Doe",
				"Oliver*Doe", true);
		testSetName("Case 2: first name change with leading/trailing spaces", "   Oliver   ", "Doe",
				"Oliver*Doe", true);
		testSetName("Case 3: last name change without leading/trailing spaces", "John", "Edison",
				"John*Edison", true);
		testSetName("Case 4: last name change with leading/trailing spaces", "John", "   Edison   ",
				"John*Edison", true);
	}

	private static void testSetName(String testCase, String firstName, String lastName,
			String expectedFullName, boolean expectValid) {
		out.print("\n" + testCase + "\n");
		try {
			Salaried thePerson = new Salaried ("E100", "John", "Doe", 10000, "D1", 
					new Address("3040", "Sherbrooke", "Westmount"));
			out.print("\tThe Salaried instance was created: " + thePerson + "\n");
			
			thePerson.setName(firstName, lastName);
			out.print("\tThe Salaried name was changed: " + thePerson + "\n");

			if (!thePerson.getName().toString().equals(expectedFullName))
				out.print("  Error! Expected Valid. ==== FAILED TEST ====");
		} catch (IllegalArgumentException iae) {
			out.print("\t" + iae.getMessage());
			if (expectValid)
				out.print("  Error! Expected Valid. ==== FAILED TEST ====");
		} catch (Exception e) {
			out.print("\tUNEXPECTED EXCEPTION TYPE! " + e.getClass() + " "
					+ e.getMessage() + " ==== FAILED TEST ====");
			if (expectValid)
				out.print(" Expected Valid.");
		}
	}
	public static void testEquals(){
		out.print("\nTesting the equals method");
		testEquals("Case 1 - Different Employees John Doe vs James Edison",
				new Salaried("E100", "John", "Doe", 10000,
				"D1", new Address("3040", "Sherbrooke", "Westmount")),
				new Salaried("E200", "James", "Edison", 10000,
				"D1", new Address("5050", "Sherbrooke", "Westmount"	)), true);
		testEquals("Case 2 - Same employee number Digits John Doe vs James Edison",
				new Salaried("E100", "John", "Doe", 10000,
				"D1", new Address("3040", "Sherbrooke", "Westmount")),
				new Salaried("E100", "James", "Edison", 10000,
				"D1", new Address("5050", "Sherbrooke", "Westmount"	)), true);
		//testEquals("Case 3 - One empty constructor XXYY01010122 vs empty string", new Ramq("XXYY01010122"),
				//new Ramq(), true);
	}
	
	public static void testEquals(String testCase, Salaried emp1, Salaried emp2, boolean expectValid){
		out.print("\n\n" + testCase + "\n");
		
		try{
			out.print("\tThe first Employee instance was created: " + emp1 + "\n");
			out.print("\tThe Second Employee instance was created: " + emp2 + "\n");
			out.print("\tThe equals result is: " + emp1.equals(emp2) + "\n");
			if (!expectValid){
				out.print("Error! Expected Invalid. ==== FAILED TEST ====\n");
			}
		}
		catch (IllegalArgumentException iae){
			out.print("\t" + iae.getMessage() + "\n");
			if (expectValid){
				out.print("Error! Expected Valid. ==== FAILED TEST ====\n");
			}
				
		}
		catch (Exception e) {
			out.print("\tUNEXPECTED EXCEPTION TYPE! " + e.getClass() + " "
					+ e.getMessage() + " ==== FAILED TEST ====\n");
			if (expectValid)
				out.print("\tExpected Valid.");
		}
	}

}
