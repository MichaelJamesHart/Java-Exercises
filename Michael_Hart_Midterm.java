/**
 * 
 * @author Michael Hart
 * 
 */

import java.util.*;
import java.io.*;

public class Michael_Hart_Midterm {
	
	/**
	 * 
	 * Outputs the following figure to the console
	 * 
	 *           x
	 *          -x-
	 *         --x--
	 *        ---x---
	 *       ----x----
	 */
	public static void problem1()
	{
		// This outer for loop will print the 5 rows.
		for(int row = 1; row <= 5; row++)
		{
			// This inner for loop will print the columns.
			for( int col = 1; col < 6; col++ )
			{
				// If the for loop is at the 5th column, an "x" will be printed.
				if ( col == 5 )
				{
					// Print the central column of x's.
					System.out.print("x");
				}
				// If the for loop is  on row 2 or greater, dashes will be printed to the left of the x
				// equalling the number of the current row that the outer loop is on.
				else if ( (row > 1) && (col > ( 5 - row )) )
				{
					// Print the dashes.
					System.out.print("-");	
				}
				// Print the spaces before the dashes for each row.
				else
				{
					// Print the spaces.
					System.out.print(" ");	
				}
			}
			
			// Before re-ententering the outer for-loop that prints the rows, add dashes after the
			// 5th column of x's if the row number is greater than 1.
			for ( int dashes = 0; dashes <= ( row - 2 ); dashes++ )
			{
				// Print the dashes.
				System.out.print("-");
			}
			
			// Use a println to go to the next line between iterations of the outer for loop.
			System.out.println();
		}
	}
	
	/**
	 * 
	 * Outputs the following figures to the console
	 * based on size:
	 * 
	 * positiveFigSize == 1
	 * 
	 *           x
	 *           
	 * positiveFigSize == 2
	 *           x
	 *          -x-
	 *          
	 * positiveFigSize == 3
	 *           x
	 *          -x-
	 *         --x--
	 *         
	 * etc...
	 * 
	 * NOTE: This assumes positiveFigSize is positive
	 */
	public static void problem2(int positiveFigSize)
	{
		// Initialize a variable to calculate the number of spaces for the first row.
		int num_of_spaces = (positiveFigSize - 1);
		
		// Initialize a variable to calculate the number of dashes for the first row.
		int num_of_dashes = 0;
		
		// This outer for loop will print the 5 rows.
		// Set the continuation condition as postivieFigSize so only that number of rows gets printed.
		for(int row = 1; row <= positiveFigSize; row++)
		{
			// Print the spaces.
			for ( int printed_spaces = 0; printed_spaces < num_of_spaces; printed_spaces++)
			{
				// Print a space.
				System.out.print(" ");
			}
			// Print the dashes.
			for ( int printed_dashes = 0; printed_dashes < num_of_dashes; printed_dashes++)
			{
				// Print a dash.
				System.out.print("-");
			}
			// Print the "x" column.
			System.out.print("x");
			
			// Print the dashes after the "x" column.
			for ( int printed_dashes = 0; printed_dashes < num_of_dashes; printed_dashes++)
			{
				// Print a dash.
				System.out.print("-");
			}
			
			// Update the number of spaces for this row.
			num_of_spaces -= 1;
									
			// Update the number of dashes for this row.
			num_of_dashes += 1;
	
			// Use a println to go to the next line between iterations of the outer for loop.
			System.out.println();
		}
	}
	
	/**
	 * 
	 * Repeatedly asks the user to input a positive int.
	 * If the user enters anything but a positive int
	 * ignore the input and ask again.  Then prints
	 * a list counting down to zero.
	 * 
	 * For example, the program may prompt the user
	 * 
	 * "enter an int:"
	 * 
	 * if the user inputs 10 then the program would
	 * output:
	 * 
	 * 10,9,8,7,6,5,4,3,2,1,0
	 * 
	 * NOTE: Commas occur only between numbers.
	 *
	 */
	public static void problem3()
	{
		// Create a Scanner console.
	    Scanner console = new Scanner(System.in);
	    
	    // Print a message asking the user to enter a positive integer.
	    System.out.print("Input a positive integer and press ENTER: ");
	    
	    // Initialize the entered value as 0 in case nothing is input in the console.
	    int entered_value = 0;
	    
	    // Create a boolean for a while loop to track if console input is finished.
	    boolean finish_input = false;
	    
	    // In this while loop, the user will continually be prompted to enter a positive integer.
	    // The finish_input will only become true once a positive integer is entered.
	    while ( !finish_input )
	    {
	    	// Create a try/catch to make sure an int is being entered.
	        try
	        {
	        	// Take an integer input from the console.
	        	entered_value = console.nextInt();
	        	
	        	// If the user enters a negative integer, tell them their mistake and prompt them to enter a positive integer.
	            while ( entered_value <= 0 )
	            {
	            	// Tell the user their mistake.
	                System.out.println("You entered zero or a negative integer. Please input a positive integer and press ENTER: ");
	                
	                // Take another integer as input.
	                entered_value = console.nextInt();
	            }
	        	
	            // Set finish_input as true to exit the while loop.
	            finish_input = true;
	        }
	        
	        // Catch when the user enters a non-integer.
	        catch (InputMismatchException exception) 
	        { 
	        	// Tell the user their mistake.
	            System.out.println("You didn't enter an integer. Please input a positive integer and press ENTER: ");
	        }
	        // Clear the console with nextLine() so the catch doesn't get stuck in an infinite loop.
	        console.nextLine();
	    }
	    
	    // Print the entered value once as the first part of the fence post.
	    System.out.print(entered_value);

	    // Count down to zero in a for loop.
	    // Set the current count minus one as the entered value, since we already printed the entered value.
	    for ( int current_count = entered_value - 1; current_count >= 0; current_count-- )
	    {
	        // Print a comma concatenated to the current count number.
	        System.out.print("," + current_count);
	    }

	    // Close the console.
	    console.close();
	}
	
	/**
	 * 
	 * Calculates and return a specific fibonacci number.
	 * 
	 * For example, if positiveSeqNum is 7 then the 
	 * fibonacci sequence would be
	 * 
	 * 1,1,2,3,5,8,13
	 * 
	 * The program will return 13.
	 * 
	 * NOTE: positiveSeqNum is positive
	 * 
	 * @return
	 */
	public static int problem4(int positiveSeqNum)
	{
		// Initialize the 1st number, which is zero.
		int previous_fib_number = 0;
					
		// Initialize the 2nd number, which is one.
		int current_fib_number = 1;
		
		// Initialize the 3nd number, which the previous plus the current.
		int next_fib_number = previous_fib_number + current_fib_number;
					
		// Declare a positiveSeqNum_Fib to be returned at the end.
		int positiveSeqNum_Fib = current_fib_number;
		
		// Loop from the 2rd fib number to the last, as defined by positiveSeqNum.
		// Start on the second "1", due to the previous calculations.
		for ( int fib_index = 2; fib_index <= positiveSeqNum; fib_index++ )
		{
			// Set the next fib number as the previous plus the current at the start of each iteration in the for loop.
			next_fib_number = previous_fib_number + current_fib_number;
			
			// Assign the previous fib number as the current fib number, for the next round of the for loop.
			previous_fib_number = current_fib_number;
			
			// Assign the current number as the next number, for the next round of the for loop.
			current_fib_number = next_fib_number;
			
			// Assign the value to positiveSeqNum_Fib.
			positiveSeqNum_Fib = current_fib_number;
		}
		
//		// Print the positiveSeqNum_Fib for testing.
//		System.out.print(positiveSeqNum_Fib);
		
		// Return the postiiveSeqNum-th of the fibonacci sequence.
		return positiveSeqNum_Fib;
	}
	
	/**
	 * 
	 * Calculates the fibonacci sequence of the given
	 * length and first writes that sequence to file.
	 * Then the sequence is returned in an int array.
	 * 
	 * NOTE: This utilizes the problem4 method to help.
	 * 
	 * NOTE: positiveSeqNum will be positive.
	 * 
	 * @param fileName
	 * @param positiveSeqNum
	 * @return
	 */
	public static int[] problem5(String fileName, int positiveSeqNum)
	{
		// Create an int array to hold the fibonacci sequence.
		int[] fib_sequence = new int[positiveSeqNum];
		
		// Use problem4() in a loop to add each fibonacci sequence number to the array.
		for ( int fib_index = 0; fib_index < positiveSeqNum; fib_index++ )
		{
			// Add each number of the fibonacci sequence to the array.
			fib_sequence[fib_index] = problem4(fib_index + 1);
		}
		
//		// Print the array elements for testing.
//		for ( int index = 0; index < positiveSeqNum; index++ ) {
//		    System.out.print( fib_sequence[index] + " " );
//		}
		
		// Do a try/catch for an IOException in case a file name is not entered.
		try
		{
		// Open a print stream to print to a file.
		PrintStream file_output = new PrintStream(new File( fileName ));
		
		// Loop from 0 to the positiveSeqNum, and use the index to access that number in
		// the fibonacci sequence.
		for ( int index = 0; index < positiveSeqNum; index++ )
		{
			// Print each fibonacci sequence number to the .txt file.
			file_output.print( fib_sequence[index] + " " );
		}
		}
		catch ( IOException exception )
		{
			exception.printStackTrace();
		}
		
		// Return the fib_sequence array.
		return fib_sequence;
	}
	
	/**
	 * 
	 * Selects an int on the interval 
	 * [lowerBound, upperBound] uniformly randomly.
	 * 
	 * This assumes that the lowerBound is less than or equal to the upperBound.
	 * 
	 * For example, if given the interval [2,4], the
	 * program will return either 2, 3, or 4 with
	 * equal probability.
	 * 
	 * @param lowerBound
	 * @param upperBound
	 * @return
	 */
	public static int problem6(int lowerBound, int upperBound)
	{
		// Generate a random.
		Random rand = new Random();
				
		// Do rand.nextInt between lowerBound and upperBound.
		int output_number = rand.nextInt(upperBound + 1 - lowerBound) + lowerBound;
		
//		// Print the output number for testing.
//		System.out.print(output_number);
		
		// Return the output_number.
		return output_number;
	}

	
	/**
	 * 
	 * Removes the first numChars of inputString and
	 * tests if the resulting substring is equal
	 * to testString.  If it is, returns null.  Otherwise
	 * returns the substring that was calculated.
	 * 
	 * For example, suppose the inputString is "abcde",
	 * testString is "qwer", and numChars is 2.  Then
	 * the substring is "cde" and the substring and
	 * testString are not equal.  The method then would
	 * return "cde".
	 * 
	 * NOTE: This assumes that numChars is non negative and less
	 * than the size of inputString.
	 * 
	 * @param myString
	 * @param numChars
	 * @return
	 */
	public static String problem7(String inputString, String testString, int numChars)
	{
		// Remove the first numChars of inputString.
		String my_substring = inputString.substring( numChars, inputString.length() );
		
		// Test if the resulting substring is equal to testSTring.
		if ( my_substring.equals(testString) )
		{
//			// Print "null" for testing.
//			System.out.print("null");
			
			// Return null.
			return null;
		}
		
//		// Print my_substring for testing.
//		System.out.print(my_substring);

		return my_substring;
	}
	
	/**
	 * 
	 * Rounds the input double up to the nearest int,
	 * casts the result to an int, then finds and returns
	 * the largest prime divisor of this int.
	 * 
	 * For example, if myDouble is 10.0 this method 
	 * will return 5.
	 * 
	 * NOTE: This assumes that myDouble is greater than 2
	 * 
	 * @param myDouble
	 * @return
	 */
	public static int problem8(double myDouble)
	{
		// Round the input double up to the nearest int.
		double double_rounded_up = Math.ceil(myDouble);
	
		// Cast the result as an int.
		int int_rounded_up = (int) double_rounded_up;
		
		// Set the initial largest prime divisor as 2, since that is the lowest possible one.
		int largest_prime_divisor = 2;
				
		// Check if the int_rounded_up itself is prime by first checking how many factors it has.
		int factors = 0;
	    for (int prime_index = 1; prime_index <= int_rounded_up; prime_index++)
	    {
	    	// Check that the current prime index can evenly divide into the number being checked.
	        if ( int_rounded_up % prime_index == 0 )
	        {
	        	// Iterate factors by one for each time a factor is found.
	            factors++;
	        }
	    }
	    
	    // If the number being checked is larger than the previously set prime divisor,
	    // set the largest_prime_divisor as that number.
	    if ( (factors == 2) && ( int_rounded_up > largest_prime_divisor ) )
	    {
			// Set the new largest_prime_divisor as the number_being_checked.
	    	largest_prime_divisor = int_rounded_up;
	    }
		
		// Iterate through each number from 1 to int_rounded_up.
		// Only go up to int_rounded_up/2, since a prime divisor will never be greater than a number divided by 2.
		for ( int number_being_checked = 1; number_being_checked <= int_rounded_up/2; number_being_checked++ )
		{
			// Re-set the factors as zero every iteration through the loop.
			factors = 0;
			// Check if the number itself is prime by first checking how many factors it has.
		    for (int prime_index = 1; prime_index <= number_being_checked; prime_index++)
		    {
		    	// Check that the current prime index can evenly divide into the number being checked.
		        if ( number_being_checked % prime_index == 0 )
		        {
		        	// Iterate factors by one for each time a factor is found.
		            factors++;
		        }
		    }
		    
		    // If the number being checked is a prime, is a divisor of int_rounded_up, and is also
		    // larger than the previous largest_prime_divisor, set it as the new largest_prime_divisor.
		    if ( (factors == 2) && ( int_rounded_up % number_being_checked == 0 ) && ( number_being_checked > largest_prime_divisor ) )
		    {
				// Set the new largest_prime_divisor as the number_being_checked.
		    	largest_prime_divisor = number_being_checked;
		    }

		}
			
//		// Print the largest_prime_divisor for testing.
//		System.out.print("largest_prime_divisor: " + largest_prime_divisor + "\n");

		// Return the largest prime divisor.
		return largest_prime_divisor;
	}
	
	
	public static void main(String[] args)
	{
		
//		// Testing Code:
//		System.out.println("Problem 1");
//		problem1();
//		
//		System.out.println("\nProblem 2");
//		problem2(3);
//		
//		System.out.println("\nProblem 3");
//		problem3();
//		
//		System.out.println("\nProblem 4");
//		problem4(7);
//		
//		System.out.println("\nProblem 5");
//		problem5("fib_file.txt", 12);
//		
//		System.out.println("\nProblem 6");
//		problem6(5, 10);
//		
//		System.out.println("\nProblem 7");
//		problem7("abcde", "qwer", 2);
//		
//		System.out.println("\nProblem 8");
//		problem8(10.0);
	}
}
