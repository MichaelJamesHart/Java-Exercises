/**
 * 
 * @author Michael Hart
 * Java Final Project
 */

package Final;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Michael_Hart_Final {
	
	/**
	 * 
	 * This method takes as input a positive int
	 * that is smaller than or equal to 10 and
	 * prints out a square with length and width
	 * equal to this input value.  Moreover, this
	 * method counts up to the square of the input
	 * For example, suppose the input is 4 then 
	 * the output should be:
	 * 
	 * 01 02 03 04
	 * 05 06 07 08
	 * 09 10 11 12
	 * 13 14 15 16
	 * 
	 * If the input was 2 then the output would be
	 * 
	 * 01 02
	 * 03 04
	 * 
	 * This problem will use NO 
	 * MORE than one loop of any type.
	 * 
	 * @param squareSize
	 */
	public static void problem1(int squareSize)
	{
		// Create a variable to hold the value of squareSize squared.
		int total_integers = squareSize * squareSize;
		
		// Create a column_counter to keep track of when the printing should skip to the next row.
		int column_counter = 1;
		
		// Create a loop that will run to squareSize^2.
		for (int current_integer = 1; current_integer <= total_integers; current_integer++)
		{
			// Print for testing.
//			System.out.println("column_counter: " + column_counter);
//			System.out.println("current_integer: " + current_integer);
			
			// Create a new printed_value for each run through the loop. This will be what is actually printed, with a zero added before single-digits.
			String printed_value = "";
			
			// Check if the current_integer is single-digit.
			if ( (current_integer - 10) < 0 )
			{
				// Concatenage '0' with the current_integer.
				printed_value += "0" + current_integer;
			}
			else // The current_integer is two-digits.
			{
				// Set the printed_value as the current_integer.
				printed_value += current_integer;
			}
			
			// Check if *not* on the first or last row, which means a space should be printed.
			if ( (column_counter != 1) && (column_counter != (squareSize + 1)) )
			{
				// Print the printed_value with a space before it.
				System.out.print(" " + printed_value);
			}
			else // Just the printed_value should be printed.
			{
				// Print the printed_value.
				System.out.print(printed_value);
			}
			
			
			// Check if the number of columns equals the squareSize.
			if (column_counter == squareSize)
			{
				// Go to the next row.
				System.out.println();
				
				// Reset the column_counter to zero.
				column_counter = 0;
			}
			
			// Increment the column_counter.
			column_counter++;
		}
	}
	
	
	/**
	 * 
	 * This method prints out the first given number of primes
	 * to a file at the given location.  If the file does not
	 * exist, it will be created.  Otherwise, the file will be
	 * overwriten.  Num primes will be at least 1.
	 * 
	 * For example, suppose that numPrimes is 10.  Then the file
	 * will contain:
	 * 
	 * 2, 3, 5, 7, 11, 13, 17, 19, 23, 29
	 * 
	 * The method will not throw any exceptions.
	 * 
	 * @param numPrimes
	 * @param fileLocation
	 */
	public static void problem2(int numPrimes, String fileName)
	{
		// Do a try/catch to avoid file name errors.
		try
		{
			// Open a print stream to print to a file.
			PrintStream file_output = new PrintStream(new File( fileName ));
			
			// Check if the number of primes to be printed is 0.
			if (numPrimes == 0)
			{
				// Print an empty string to the file.
				file_output.print("");
				
				// Exit the function.
				return;
			}
			// Print the first integer without a comma for a fenceposting solution.
			// The first prime is always 2.
			file_output.print("2");
//			System.out.print("2");
			
			// Create a variable to keep track of how many primes have been printed so far.
			int printed_primes = 1;
			
			// Check if the number of primes to be printed is greater than 2.
		    if (numPrimes >= 2)
		    {
		    	// Set the number of possible primes to 3.
		    	int possible_prime = 3;
		    	
		    	// Keep printing primes until printed_primes is equal to numPrimes.
		    	while (printed_primes < numPrimes)
		    	{
		        	// Start the number of divisors as 0.
		        	int num_of_divisors = 0;
		        	
		        	// Loop through all possible divisors.
		    	    for (int possible_divisor = 1; possible_divisor <= possible_prime; possible_divisor++)
		    	    {
		    	        // Check if possible_divisor is a factor of the possible_prime.
		    	    	if (possible_prime % possible_divisor == 0)
		    	    	{
		    	    		// Keep track of how many divisors have been found.
		    	        	num_of_divisors++;
		    	        }
		    	    }
		        	// If the num_of_divisors is 2, then the possible_prime is a prime number.
		            if (num_of_divisors == 2)
		            {
		            	// Print the possible prime to the file, with a comma and space before it.
		            	file_output.print(", " + possible_prime);
//		            	System.out.print(", " + possible_prime);
		            	
		            	// Increment the printed_primes, to keep track of how many primes have been printed.
				        printed_primes++;
		            }
		            // Increment to check the next possible prime number.
		            possible_prime++;
		    	}
		    	// Print a newline character to the file.
		        file_output.println();
//		        System.out.println();
		    }
		}
		// Catch file name errors.
		catch ( FileNotFoundException exception )
		{
			exception.printStackTrace();
		}
	}
	
	/**
	 * 
	 * Returns true if firstString is a subString of secondString
	 * or if secondString is a subString of firstString.  For 
	 * example, suppose that firstString is "cat" and secondString
	 * is "at".  In this case secondString would be a substring of
	 * firstString.
	 * 
	 * Will only use the length method, charAt method, and subString
	 * method of the string class for this problem.
	 * 
	 * @param firstString
	 * @param secondString
	 * @return
	 */
	public static boolean problem3(String firstString, String secondString)
	{
		// Get the firstString length.
		int first_length = firstString.length();
		
		// Get the secondString length.
		int second_length = secondString.length();

		// Check if firstString is shorter than or equal to secondString.
		if (first_length <= second_length)
		{
			// Loop through all possible starting and ending indices of first_length within second_length, and see if the words match up.
			for (int start_of_secondString = 0; start_of_secondString <= (second_length - first_length); start_of_secondString++)
			{
				// Calculate the end index of the substring.
				int end_of_secondString = start_of_secondString + first_length;
				
				// Create the second word.
				String second_word = secondString.substring(start_of_secondString, end_of_secondString);
				
				// Print for testing.
//				System.out.println("Comparing: " + firstString + " and " + second_word);
				
				// Create a counter to see how many of the characters match.
				int matching_chars = 0;
				
				// Check if the two strings equal each other.
				for (int char_index = 0; char_index < first_length; char_index++)
				{
					// Check if each of the characters are the same.
					if (firstString.charAt(char_index) == second_word.charAt(char_index)
							&&
							// Check if the upper/lower cases are the same for each character.
							( Character.isUpperCase(firstString.charAt(char_index)) == Character.isUpperCase(second_word.charAt(char_index)) 
							|| ( Character.isLowerCase(firstString.charAt(char_index)) == Character.isLowerCase(second_word.charAt(char_index))) )
							)
					{
						// Increment the matching_chars by 1 for each matching char.
						matching_chars++;
					}
					
					// If the matching_chars is equal to the length of the words, return true.
					if (matching_chars == first_length)
					{
						return true;
					}
				}
			}
		}
		// The secondString is shorter than the firstString.
		else if (second_length < first_length)
		{
			// Loop through all possible starting and ending indices of second_length within first_length, and see if the words match up.
			for (int start_of_firstString = 0; start_of_firstString <= (first_length - second_length); start_of_firstString++)
			{
				// Calculate the end index of the substring.
				int end_of_firstString = start_of_firstString + second_length;

				// Create the first word.
				String first_word = firstString.substring(start_of_firstString, end_of_firstString);
				
				// Print for testing.
//				System.out.println("Comparing: " + first_word + " and " + secondString);
				
				// Create a counter to see how many of the characters match.
				int matching_chars = 0;
				
				// Check if the two strings equal each other.
				for (int char_index = 0; char_index < second_length; char_index++)
				{
					// Check if each of the characters are the same.
					if (secondString.charAt(char_index) == first_word.charAt(char_index)
							&&
							// Check if the upper/lower cases are the same for each character.
							( Character.isUpperCase(secondString.charAt(char_index)) == Character.isUpperCase(first_word.charAt(char_index)) 
							|| ( Character.isLowerCase(secondString.charAt(char_index)) == Character.isLowerCase(first_word.charAt(char_index))) )
							)
					{
						// Increment the matching_chars by 1 for each matching char.
						matching_chars++;
					}
				}
				
				// If the matching_chars is equal to the length of the words, return true.
				if (matching_chars == second_length)
				{
					return true;
				}
			}
		}
		else // The two strings are the same length.
		{
			// Check if the words are the same.
			if (firstString.substring(0) == firstString.substring(0))
			{
				return true;
			}
		}
		// Return false if none of the above conditions are met.
		return false;
	}
	
	
	/**
	 * 
	 * This method takes as input an HashSet of strings
	 * that first removes all strings that contain the letter "a"
	 * (case sensitive!).  Then, for all strings that contain the
	 * letter b (case sensitive!), a copy of the string is made, an 
	 * "s" is added to the end of the copy, and the copy is added 
	 * to the HashSet.
	 * 
	 * For example, suppose the hashset contains "about", "at", 
	 * "cAt", "bob".
	 * At the end of this method the hashset will contain 
	 * "cAt", "bob", "bobs"
	 * 
	 * @param myArrayList
	 */
	public static void problem4(HashSet<String> myHashSet)
	{
		// Create a transfer_words array since we cannot add to a HashSet while using an iterator.
		String[] transfer_words = new String[myHashSet.size()];
		
		// Create an index tracker for the b_words array.
		int transfer_words_index = 0;
		
		// Check each string in myHashSet with an iterator.
		Iterator<String> itr = myHashSet.iterator();
		while (itr.hasNext())
		{
			// Set the current_string as the iteration value.
			String current_string = itr.next();
			
		    // Check if the string contains the letter "a".
			if (current_string.contains("a"))
			{
				// Print for testing.
//				System.out.println("Removing: " + current_string);
				
				// Remove the string.
				itr.remove();
			}
			
			// Check if the string contains the letter "b".
			else if (current_string.contains("b"))
			{
				// Make a copy of the string with the letter "s" added to the end.
				String string_copy = current_string.concat("s");
				
				// Print for testing.
//				System.out.println("Adding s to : " + current_string);
				
				// Add the string to the b_words array.
				transfer_words[transfer_words_index] = string_copy;
				
				// Increment the b_words index.
				transfer_words_index++;
			}
			
			// Check if the string contains the letter "b".
			else if (current_string.contains("b"))
			{
				// Add the string to the b_words array.
				transfer_words[transfer_words_index] = current_string;
				
				// Increment the b_words index.
				transfer_words_index++;
				
				// Remove the string.
				itr.remove();
			}
		}
		
		// Add each word from b_words to myHashSet.
		for (String string: transfer_words)
		{
			// Print for testing.
//			System.out.println("Transferring : " + string);
			
			if (string != null)
			{
				// Add the copy to myHashSet.
				myHashSet.add(string);
			}
		}
	}
	
	
	/**
	 * 
	 * If the given collection is an ArrayList, this method
	 * will remove the first num elements or all elements 
	 * if num is bigger than the size of the ArrayList.  If 
	 * instead the collection is a HashSet, this method will
	 * add the strings "0", "1", ..., "num" to the HashSet.
	 * 
	 * For example, suppose that num is 3 and the collection 
	 * is an ArrayList of size 5.  Then, the elements in the
	 * arrayList at locations 0, 1, and 2 will be removed.
	 * If instead the ArrayList is size 2, all elements from
	 * the ArrayList will be removed.  If the collection is
	 * a HashSet, the strings "0", "1", and "2" will be added
	 * to it.
	 * 
	 * The num is assumed to be positive.
	 * 
	 * @param myCollection
	 */
	public static void problem5(Collection<String> myCollection, int num)
	{
		// Check if myCollection is an ArrayList.
		if (myCollection instanceof ArrayList)
		{
			// Check if num is smaller than the length of myCollection.
			if (num < myCollection.size())
			{
				// Create a counter for how many Strings have been removed.
				int removal_counter = 0;
				
				// Run an iterator on the ArrayList.
				Iterator<String> itr = myCollection.iterator();
				while (itr.hasNext())
				{
					// Set current_string as the value of the itr.next(), so it can be removed.
					String curent_string = itr.next();
					
					// Check if we still need to remove any Strings.
					if (removal_counter < num)
					{
						// Remove the element.
						itr.remove();
						
						// Increment the removal_counter.
						removal_counter++;
					}
				}
			}
			// Check if num is equal to the length of myCollection.
			else if (num >= myCollection.size())
			{
				// Run an iterator on the ArrayList.
				Iterator<String> itr = myCollection.iterator();
				while (itr.hasNext())
				{
					// Set current_string as the value of the itr.next(), so it can be removed.
					String curent_string = itr.next();
					
					// Remove the element.
					itr.remove();
				}
			}
		}
		// Check if myCollection is a HashSet.
		else if (myCollection instanceof HashSet)
		{
			// Add the strings "0", "1", ..., "num" to the HashSet.
			for (Integer index = 0; index < num; index++)
			{
				// Cast the index as a string.
				String number_string = index.toString();
				myCollection.add(number_string);
			}
		}
	}
	
	
	/**
	 * 
	 * In this constructor the passed
	 * name and score variables are assigned
	 * to their corresponding fields of the object
	 * created by the contructor.  In addition, there
	 * are mutator and accessor methods for both fields
	 * (i.e. setName, getName etc).
	 * 
	 * @param name
	 * @param score
	 */
	private String name;
	private double score;
	public Michael_Hart_Final(String name, double score)
	{
		// Assign the passed name and score variables to their corresponsing fields.
		this.name = name;
		this.score = score;
	}
	public void setName(String name)
	{
		// Set the object's name as the parameter name.
		this.name = name;
	}
	public String getName()
	{
		// Return the object's name.
		return name;
	}
	public void setScore(double score)
	{
		// Set the object's score to the parameter score.
		this.score = score;
	}
	public double getScore()
	{
		// Return the object's score.
		return score;
	}
	
	
	
	/**
	 * 
	 * This method calculates the num'th number in the
	 * Tribonacci sequence USING RECURSION.
	 * The Tribonacci sequence is defined
	 * as the sequence of numbers such that 
	 * each number is the sum of the previous three 
	 * numbers given that the first three numbers are 
	 * 0, 0, and 1 (The Tribonacci is very similar to 
	 * the Fibonacci sequence.  The difference being 
	 * that the Fibonacci sequence uses the previous 
	 * two numbers while the Tribonacci sequence uses 
	 * the previous three).
	 * 
	 * For example, suppose num is 10.  Then the
	 * corresponding Tribonacci sequence would be
	 * 0,0,1,1,2,4,7,13,24,44 and the number returned
	 * by this method would be 44.
	 * 
	 * The num is assumed to be at least 3.
	 * 
	 * @param num
	 * @return
	 */
	public static int problem7(int num)
	{
		// Check if the number is 0, 1, or 2.
        if (num == 0 || num == 1 || num == 2)
        {
        	// Return 0 if that is the case, since the first three numbers of the tribonacci are always 0.
        	return 0; 
        }
        
        // Check if the number is 3.
        if (num == 3)
        {
        	// Return 1, since the third number is always 1.
        	return 1; 
        }
        
        else // For every number after 3.
        {
        	// Return the sum of the three preceding numbers using recursion.
        	return problem7(num - 1) + problem7(num - 2) + problem7(num - 3); 
        }
	}
	
	
	/**
	 * 
	 * This method returns an anonymous class object
	 * that extends Michael_Hart_Final with an overriden equals method
	 * that returns true if the name field of the two 
	 * objects are the same length and each corresponding
	 * char are the same case.
	 * 
	 * For example, suppose that the two Strings are "cat"
	 * and "dog".  These strings are the same length and
	 * each character is lower case so the method would 
	 * return true.
	 * 
	 * Consider another example, suppose the two Strings are
	 * "cat" and "cAt".  These strings are the same length
	 * but each character is not the same case (the "a" and 
	 * "A" are not the same case) so the method would return
	 * false.
	 * 
	 * @param input
	 * @return
	 */
	public static Michael_Hart_Final problem8(String name, double score)
	{
		// Create a new Michael_Hart_Final object with the input parameter from Michael_Hart_Final() passed to it.
		Michael_Hart_Final obj = new Michael_Hart_Final(name, score)
		{
			// Override the original equals() method.
			@Override
			public boolean equals(Object object)
			{
				// Check if the object is of the type Michael_Hart_Final.
			    if (object instanceof Michael_Hart_Final)
			    {
			    	// The object is a Michael_Hart_Final, so cast and compare it
			    	Michael_Hart_Final other = (Michael_Hart_Final) object;
			    	
			    	// Print for testing.
//			    	System.out.println("Name of other: " + other.getName());
//			    	System.out.println("Name of other: " + getName());
			    	
			    	// Create variables to hold the first and second words.
			    	String other_name = other.getName();
			    	String orig_name = getName();
			    	
			    	// Check if the name fields are the same length.
					if (other_name.length() != orig_name.length() )
					{
						// Return false if they are the same length.
						return false;
					}
					else // The fields are the same length.
					{
						// Create a variable to hold the word length.
						int word_length = other_name.length();
						
						// Check if each character of both Strings is upper or lower.
						for (int string_index = 0; string_index < word_length; string_index++)
						{
							// Set the first String's current character to be checked.
							char first_string_character = orig_name.charAt(string_index);
							char second_string_character = other_name.charAt(string_index);
							
							// Print for testing.
//							System.out.println("Comparing " + first_string_character + " and " + second_string_character + ".");
							
							// Compare the characters's cases.
							if ( (Character.isUpperCase(first_string_character)) && (Character.isLowerCase(second_string_character))
									||
									(Character.isLowerCase(first_string_character)) && (Character.isUpperCase(second_string_character)) )
							{
								// Return false if they are of different cases.
								return false;
							}
						}
					}	
					// Return true if the previous checks passed.
					return true;
			    }
			    // The object is not a String; cannot be equal.
			    else
			    {
			        // Return false.
			        return false;
			    }
			}
			
		};
		
		// Return the anonymous class object.
		return obj;
	}
	
	public static void main (String[] args)
	{
		
		// Problem 1 Testing //
//		System.out.println("Problem 1 result: ");
//		problem1(1);
//		System.out.println();
//		problem1(2);
//		System.out.println();
//		problem1(4);
//		System.out.println();
//		problem1(5);
//		System.out.println();
//		problem1(6);
		
		// Problem 2 Testing //
//		problem2(10, "problem2_test.txt");
		
		// Problem 3 Testing //
//		System.out.println("Problem 3 result for 'cat' and 'at': " + problem3("cat", "at"));
//		System.out.println("Problem 3 result for 'at' and 'cat': " + problem3("at", "cat"));
//		System.out.println("Problem 3 result for 'cA' and 'at': " + problem3("cA", "at"));
//		System.out.println("Problem 3 result for 'at' and 'cAt': " + problem3("at", "cAt"));
//		System.out.println("Problem 3 result for 'courageous' and 'age': " + problem3("courageous", "age"));
//		System.out.println("Problem 3 result for 'age' and 'courageous': " + problem3("age", "courageous"));
//		System.out.println("Problem 3 result for 'COURAGEOUS' and 'AGE': " + problem3("COURAGEOUS", "AGE"));
//		System.out.println("Problem 3 result for 'AGE' and 'COURAGEOUS': " + problem3("AGE", "COURAGEOUS"));
//		System.out.println("Problem 3 result for 'informatics' and 'info': " + problem3("informatics", "info"));
//		System.out.println("Problem 3 result for 'info' and 'informatics': " + problem3("info", "informatics"));
//		System.out.println("Problem 3 result for 'matics' and 'informatics': " + problem3("matics", "informatics"));
//		System.out.println("Problem 3 result for 'identical' and 'identical': " + problem3("identical", "identical"));
//		System.out.println("Problem 3 result for 'identical' and 'IDENTICAL': " + problem3("identical", "IDENTICAL"));
//		System.out.println("Problem 3 result for 'call' and 'recall': " + problem3("call", "recall"));
//		System.out.println("Problem 3 result for 'recall' and 'call': " + problem3("recall", "call"));
//		System.out.println("Problem 3 result for 'courageous' and 'identical': " + problem3("courageous", "identical"));
//		System.out.println("Problem 3 result for 'informatics' and 'cat': " + problem3("informatics", "cat"));
//		System.out.println("Problem 3 result for 'Apple' and 'apples': " + problem3("Apple", "apples"));
//		System.out.println("Problem 3 result for 'apples' and 'Apple': " + problem3("apples", "Apple"));
		
		// Problem 4 Testing //
//		HashSet<String> prob4_test_HashSet = new HashSet<String>();
//		prob4_test_HashSet.add("about");
//		prob4_test_HashSet.add("at");
//		prob4_test_HashSet.add("cAt");
//		prob4_test_HashSet.add("bob");
//		System.out.println(prob4_test_HashSet);
//		problem4(prob4_test_HashSet);
//		System.out.println("Problem 4 result: " + prob4_test_HashSet);
		
		// Problem 5 Testing //
//		ArrayList<String> prob5_test_ArrayList = new ArrayList<String>();
//		prob5_test_ArrayList.add("one");
//		prob5_test_ArrayList.add("two");
//		prob5_test_ArrayList.add("three");
//		prob5_test_ArrayList.add("four");
//		prob5_test_ArrayList.add("five");
//		problem5(prob5_test_ArrayList, 3);
//		System.out.println("Problem 5 result when ArrayList passed: " + prob5_test_ArrayList);
//		HashSet<String> prob5_test_HashSet = new HashSet<String>();
//		prob5_test_HashSet.add("one");
//		prob5_test_HashSet.add("two");
//		prob5_test_HashSet.add("three");
//		prob5_test_HashSet.add("four");
//		prob5_test_HashSet.add("five");
//		prob5_test_HashSet.add("six");
//		prob5_test_HashSet.add("seven");
//		problem5(prob5_test_HashSet, 3);
//		System.out.println("Problem 5 result when HashSet passed: " + prob5_test_HashSet);

		// Problem 6 Testing //

		// Problem 7 Testing //
//		System.out.println("Problem 7 result: " + problem7(1));
//		System.out.println("Problem 7 result: " + problem7(2));
//		System.out.println("Problem 7 result: " + problem7(3));
//		System.out.println("Problem 7 result: " + problem7(4));
//		System.out.println("Problem 7 result: " + problem7(5));
//		System.out.println("Problem 7 result: " + problem7(6));
//		System.out.println("Problem 7 result: " + problem7(7));
//		System.out.println("Problem 7 result: " + problem7(8));
//		System.out.println("Problem 7 result: " + problem7(9));
//		System.out.println("Problem 7 result: " + problem7(10));
		
		// Problem 8 Testing //
//		 * For example, suppose that the two Strings are "cat"
//		 * and "dog".  These strings are the same length and
//		 * each character is lower case so the method would 
//		 * return true.
//		 * 
//		 * Consider another example, suppose the two Strings are
//		 * "cat" and "cAt".  These strings are the same length
//		 * but each character is not the same case (the "a" and 
//		 * "A" are not the same case) so the method would return
//		 * false.
//		Michael_Hart_Final prob8_test_cat = problem8("cat", 2.5);
//		Michael_Hart_Final prob8_test_dog = problem8("dog", 2.5);
//		Michael_Hart_Final prob8_test_cAt = problem8("cAt", 2.5);
//		Michael_Hart_Final prob8_test_dOg = problem8("dOg", 2.5);
//		System.out.println("Problem 8 'cat' and 'dog' result (non-overriden): " + "cat".equals("dog"));
//		System.out.println("Problem 8 'cat' and 'cAt' result (non-overriden): " + "cat".equals("cAt"));
//		System.out.println("Problem 8 'cat' and 'dog' result (overriden): " + prob8_test_cat.equals(prob8_test_dog));
//		System.out.println("Problem 8 'cat' and 'cAt' result (overriden): " + prob8_test_cat.equals(prob8_test_cAt));
//		System.out.println("Problem 8 'cAt' and 'dOg' result (overriden): " + prob8_test_cAt.equals(prob8_test_dOg));
	}

}