/**
 * 
 */
package addressbook.app;
import dw317.lib.Address;

/**
 * @author Erika
 *
 */
public class AddressBook {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Address myAddress = new Address("3040", "Sherbrooke", "Westmount");
		System.out.println(myAddress.getAddress());

	}

}
