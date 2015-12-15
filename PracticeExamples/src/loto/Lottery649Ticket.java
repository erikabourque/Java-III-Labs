/**
 * 
 */
package loto;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Erika
 *
 */
public final class Lottery649Ticket 
{
	private final int[] lotteryNumbers;
	private final Random randomGenerator = new Random();
	
	/**
	 * Default Constructor.  Retrieves random numbers.
	 */
	Lottery649Ticket()
	{
		int[] temp = new int[6];
		
		for (int i = 0; i < temp.length; i++)
		{
			// Between 0 and 48, will add 1 (so ends up as between 1 and 49)
			temp[i] = randomGenerator.nextInt(48) + 1;
		}
		
		Arrays.sort(temp);
		
		lotteryNumbers = temp;
	}
	
	/**
	 * 6 Param Constructor.  Takes in the six numbers to build
	 * the ticket with
	 */
	Lottery649Ticket(int num1, int num2, int num3, int num4, int num5, int num6)
	{
		int[] temp = {num1, num2, num3, num4, num5, num6};
		
		for (int i = 0; i < temp.length; i++)
		{
			if ((temp[i] < 1) || (temp[i] > 49))
			{
				throw new IllegalArgumentException("Numbers must be between 1 and 49.  "
						+ "Invalid value: " + temp[i]);
			}
		}
		
		Arrays.sort(temp);
		
		lotteryNumbers = temp;		
	}
	
	public int[] getNumbers()
	{
		int[] copy = new int[6];
		
		for(int i = 0; i < copy.length; i++)
		{
			copy[i] = lotteryNumbers[i];
		}
		
		return copy;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(lotteryNumbers);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Lottery649Ticket other = (Lottery649Ticket) obj;
		if (!Arrays.equals(lotteryNumbers, other.lotteryNumbers)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString()
	{
		StringBuilder strBuilder = new StringBuilder();
		
		for (int i = 0; i < lotteryNumbers.length; i++)
		{
			strBuilder.append(lotteryNumbers[i] + " ");
		}
		
		return strBuilder.toString();
		
	}
}
