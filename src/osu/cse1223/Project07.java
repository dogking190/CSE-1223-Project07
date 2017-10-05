/*
 * Project07.java
 * 
 *   A program that plays the dice game high/low
 *   Used to practice breaking code up into methods. 
 * 
 * @author Paul M Onderisin
 * @verison 1.0.0
 * 
 */
package osu.cse1223;
import java.util.Random;
import java.util.Scanner;


public class Project07 {


	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		int _usrAmount = 100;
		
		while(_usrAmount > 0)
		{
			System.out.println("You have a $" + _usrAmount + " to bet.");
			int _usrBet = getBet(in, _usrAmount);
			
			if (_usrBet == 0)
					break;
			
			char _highhLow = getHighLow(in);
			
			int _roll1 = getRoll(); System.out.println("Roll 1: " + _roll1);
			int _roll2 = getRoll(); System.out.println("Roll 2: " + _roll2);
			
			int _di_results = _roll1 + _roll2;
			
			System.out.println("Total of two dice is: " + _di_results);
			
			_usrAmount += determineWinnings(_highhLow, _usrBet, _di_results);
			
			System.out.println(" ");
		}
		
		System.out.println(" ");
		System.out.println("You have $" + _usrAmount + " left.");
		System.out.println("Goodbye!");
	}
	
	
	// Given a Scanner and a current maximum amount of money, prompt the user for
	// an integer representing the number of dollars that they want to bet.  This
	// number must be between 0 and to maximum number of dollars.  If the user enters
	// a number that is out of bounds, display an error message and ask again.
	// Return the bet to the calling program.
	private static int getBet(Scanner inScanner, int currentPool) {
		
		while(true)
		{
			System.out.print("Enter an amount to bet (0 to quit): ");
			int _betAmount = inScanner.nextInt();
			inScanner.nextLine();
			
			if(_betAmount <= currentPool && _betAmount >= 0)
			{
				return _betAmount;
			}
			else
			{
				System.out.println("Your bet MUST be between 0 and " + currentPool + " dollars");
			}
		}
		
	}
	
	// Given a Scanner, prompt the user for a single character indicating whether they
	// would like to bet High ('H'), Low ('L') or Sevens ('S').  Your code should accept
	// either capital or lowercase answers, but should display an error if the user attempts
	// to enter anything but one of these 3 values and prompt for a valid answer.
	// Return the character to the calling program.
	private static char getHighLow(Scanner inScanner) {
		
		while(true)
		{
			System.out.print("High, low or sevens (H/L/S): ");
			
			String _answer = inScanner.nextLine();
			
			if(_answer.equalsIgnoreCase("h"))
			{
				return 'H';
			}
			else if(_answer.equalsIgnoreCase("l"))
			{
				return 'L';
			}
			else if(_answer.equalsIgnoreCase("s"))
			{
				return 'S';
			}
			else
			{
				System.out.println("Enter a Valid Betting Choice.");
			}
		}
	}
	
	// Produce a random roll of a single six-sided die and return that value to the calling
	// program
	private static int getRoll() {
		
		Random _rand = new Random();
		return _rand.nextInt(6) + 1;
	}
	
	// Given the choice of high, low or sevens, the player's bet and the total result of
	// the roll of the dice, determine how much the player has won.  If the player loses
	// the bet then winnings should be negative.  If the player wins, the winnings should
	// be equal to the bet if the choice is High or Low and 4 times the bet if the choice
	// was Sevens.  Return the winnings to the calling program.
	private static int determineWinnings(char highLow, int bet, int roll) {
		
		if(roll == 7 && highLow == 'S') 
		{
			System.out.println("You won $" + ( bet * 4 ) + "!");
			return bet * 4;
		}
		else if(roll <= 6 && highLow == 'L')
		{
			System.out.println("You won $" + bet + "!");
			return bet;
		}
		else if(roll >= 8 && highLow == 'H')
		{
			System.out.println("You won $" + bet + "!");
			return bet;
		}
		else
		{
			System.out.println("You Lost!");
			return bet * -1;
		}
	}

}
