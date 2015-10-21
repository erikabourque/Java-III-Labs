/**
 * 
 */
package payroll.business;

import dw317.lib.Person;
import dw317.lib.Address;

/**
 * @author C. Legendre
 * @version 3.0, 2013/08/28
 *
 */
public abstract class Employee extends Person {

	private String number;
	private String department;

	public Employee(String number, String firstName, String lastName,
			String department, Address address)
	{
		super(validateName(firstName, "First"), validateName(lastName, "Last"), address);
		this.number = validateNumber(number);
		this.department = department;
	}

	public String getDepartment()
	{
		return department;
	}

	public String getNumber()
	{
		return number;
	}

	public void setDepartment(String department)
	{
		this.department = department;
	}

	/**
	 * Overrides Person's setName method to validate name.
	 * Name must not be null and must have at least one character.
	 */
	@Override
	public void setName(String firstName, String lastName) {
		super.setName(validateName(firstName, "First"),
				  validateName(lastName, "Last"));
	}

	public abstract double getWeeklyGrossPay();

	// improperly overridden equals method
	public boolean equals(Employee otherEmp)
	{
		return number.equals(otherEmp.number);
	}
	
	/**
	 * Verifies if the string exists and if it contains at least one character.
	 * 
	 * @param aName The name to be verified.
	 * 
	 * @param nameDescriptor The description of the name parameter. If the name
	 * parameter represents the first name, it will hold "First"; otherwise it
	 * will hold "Last".
	 * @return 
	 * 
	 * @return The trimmed name if it exists.
	 * 
	 * @throws IllegalArgumentException if the name parameter doesn't exists.
	 */
	
	private static String validateName (String aName, String nameDescriptor){
		if (aName == null){
			throw new IllegalArgumentException("The employee must have a " 
					+ nameDescriptor + " name.");
		}
		
		aName = aName.trim();
		if (aName.length() < 1){
			throw new IllegalArgumentException("The employee must have a " 
					+ nameDescriptor + " name.");
		}
		return aName;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}

	private static String validateNumber (String number){
		if (number == null){
			throw new IllegalArgumentException("The employee must have a number.");
		}
		
		number = number.trim().toUpperCase();
		
		if (number.length() !=4 ||
				!number.matches("[A-Z][\\d]{3}")){
			throw new IllegalArgumentException(number + " is an invalid employee number");
		}
		
		return number;
	}
}
