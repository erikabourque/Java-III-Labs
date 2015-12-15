package loto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lottery649App {

	public static void main(String[] args)
	{
		String choice;
		
		BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
		
		Lottery649Ticket userTicket;
		Lottery649Ticket winningTicket = new Lottery649Ticket();
		
		int[] temp = new int[6];
		
		try {
			System.out.print("Enter ‘R’ for a random ticket, or anything else to choose the 6 digits:\t");
			choice = userInput.readLine();
			
			if (choice.equalsIgnoreCase("r"))
			{
				userTicket = new Lottery649Ticket();
			}
			else
			{
				for(int i = 0; i < temp.length; i++)
				{
					System.out.print("Enter number " + (i + 1) + ": ");
					temp[i] = Integer.parseInt(userInput.readLine());
				}
				
				userTicket = new Lottery649Ticket(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5]);
			}
			
			System.out.println("Your lottery ticket is: " + userTicket);
			System.out.println("The winning lottery ticket is: " + winningTicket);
			
			if (userTicket.equals(winningTicket))
			{
				System.out.println("Congratulations! You won the lottery!");
			}
			else
			{
				System.out.println("Sorry, you did not win.");
			}
			
		} catch (NumberFormatException nfe) {
			System.out.println("Please enter digits only.");
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}

}
