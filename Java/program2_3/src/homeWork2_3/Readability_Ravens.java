
//======================================================================
//
// Title:      Readability Ravens
// Course:     CSC 3020
// Homework:   Homework 2
// Author:     Mustafa Chowdhury, ge3306
// Date:       02/06/2018
// Description:
//   analyzes a paragraph for readability using the Coleman–Liau index.  
//   Prompt the user for a paragraph, and then calculate and show the following:
//	Number of characters. Number of whitespace characters.
//  Number of non-whitespace characters.Number of sentences – these are delimited by periods (.).
//	Number of words – these are delimited by one or more spaces, commas, and periods. Number of word letters.
//	Coleman–Liau index – this is calculated as follows:
//		1) Count the number of sentences.
//		2) Count the number of words.
//		3) Count the number of letters in words.
//		4) Calculate L = Letters ÷ Words × 100.
//		5) Calculate S = Sentences ÷ Words × 100.
//		6) Calculate CLI = 0.0588L - 0.296S - 15.8.
//
//======================================================================

package homeWork2_3;

// import packages
import java.util.Scanner;
//import java.util.StringTokenizer;

//===========================================================
//class Readability_Ravens
//===========================================================

public class Readability_Ravens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//------------------------------
	    // main
	    //------------------------------
		
		//creating keyboard to store user input
		Scanner keyboard = new Scanner(System.in);
		
		// show application header
		System.out.print("Welcome to the Readibility Ravaens\n");
		System.out.println("--------------------------------------");
		
		
		// prompt the user to input paragraph
		System.out.print("\nEnter the paragraph: ");
		String p = keyboard.nextLine();
		
		
		System.out.print("\nAfter analyzing the paragraph, we found that: \n");
		
		
		// declare string and split the paragraph with space
		String[] tokens = p.split("\\s");
		
		
		// split paragraph with period
		String[] sentence = p.split("[.]+");
		
		
		//split paragraph with space, comma, period 
		String[] w = p.split("[\\s,.]+");
		
		
		
		//split paragraph with commas 
		String[] comma = p.split("[,]+"); 
		
		
		
		// counting how many commas
		int c = comma.length;
		
		
		// by getting length we find exactly how many character in the
		// paragraph including space, comma, period.
		int chracter = p.length();
		
		
		// because of using nextLine() method it counts a space 
		//after press enter, thats why -1
		int space = (tokens.length)-1; 
		
		
		// counting how many period 
		int s = sentence.length;
		
		
		// counting total space,comma and period
		int total_word = w.length;
		
		
		// from total character we minus total of (space+comma+period)
		// count the last  letter that's why +1
		int l = chracter - (space+s+c) +1; 
		
		
		
		// printing number of character in a paragraph
		System.out.printf("\nNumber of chracter: %20d", chracter);
		
		
		// printing number of white space in a paragraph
		System.out.printf("\nNumber of whitespace characters: %7d", space);
		
		
		
		//printing number of non-whitespace in a paragraph
		System.out.printf("\nNon-whitespace characters: %13d", (chracter-space));
		
		
		
		//printing number of sentence in a paragraph
		System.out.printf("\nNumber of sentence: %20d", s);
		
		
		
		//printing number of words in a paragraph
		System.out.printf("\nWords: %33d", total_word);
		
		
		
		//printing number of word letters in a paragraph
		System.out.printf("\nWord letters: %26d", l);
		
		
		
		
		// calculating L and S (Coleman–Liau index calculation)
		double L = ((double)l/total_word)*100;
		double S = ((double)s/total_word)*100;
		
		
		
		// printing all the formulas and printing L S CLI
		System.out.printf("\nL : %39.2f", L);
		
		System.out.printf("\nS : %39.2f", S);
		
		System.out.printf("\nCLI : %37.2f", (0.0588*L -0.296*S - 15.8));
		
		
		
		// closing keyboard;
		keyboard.close();
		
		
		// show footer of the application
		System.out.println("\n----------------------------------------------");
		System.out.println("\nEnd of the Readability Ravens");
	
	}

}
//======================================================================
//
//Title: ArrayLists
//Description:
// This program demonstrates ArrayLists.
//
//======================================================================
package wsu.ArrayLists;

//Import classes
import java.util.ArrayList;
import java.util.Random;

//======================================================================
//class ArrayLists
//======================================================================
public class ArrayLists
{
  
  //------------------------------------------------------------------
  // Fields
  //------------------------------------------------------------------

  // Declare constant fields
  private final static String COLFMTD = "%3d";

	//------------------------------------------------------------------
  // randomizeArrayList
  //------------------------------------------------------------------
  private static void randomizeArrayList(ArrayList<Integer> al, 
		int newElements, int upperLimit)
  {
  	
  	// Loop to generate and store random numbers in ArrayList
  	Random rand = new Random();
      for (int i = 1; i <= newElements; i++)
      	al.add(rand.nextInt(upperLimit) + 1);
      
  }
	
	//------------------------------------------------------------------
  // printArrayList
	//------------------------------------------------------------------
  private static void printArrayList(String heading, 
		ArrayList<Integer> al)
  {
  	
  	// Loop to print ArrayList
  	System.out.print(heading + ": [");
      for (int i = 0; i < al.size(); i++)
      	System.out.printf(COLFMTD, al.get(i));
  	System.out.println("]");

  }
  
	//------------------------------------------------------------------
  // main
	//------------------------------------------------------------------
	@SuppressWarnings("unchecked")  // Needed for method clone
	public static void main(String[] args)
  {

      // Declare variables
		ArrayList<Integer> aList1 = new ArrayList<Integer>();
			// Create ArrayList of initial size 10
		ArrayList<Integer> aList2 = new ArrayList<Integer>(20);  
			// Create ArrayList of initial size 20
		
		// Show application header
		System.out.println("Welcome to ArrayLists");
		System.out.println("---------------------");

		// Print integer ArrayLists before adds
		printArrayList("\nEmpty ArrayList 1", aList1);
		printArrayList("Empty ArrayList 2", aList2);
		System.out.println("The size of ArrayList 1 is " + 
			aList1.size() + ".");

		// Add random values to and print integer ArrayList 1
		randomizeArrayList(aList1, 4, 99);
		printArrayList("\nArrayList 1 after value adds", aList1);
		System.out.println("The size of ArrayList 1 is " +
			aList1.size() + ".");

		// Add random values to and print integer ArrayList 2
		randomizeArrayList(aList2, 6, 99);
		printArrayList("ArrayList 2 after value adds", aList2);

		// Set some values and print integer ArrayList 1
		aList1.set(0,  30);
		aList1.set(3,  60);
		printArrayList("\nArrayList 1 after values changed", aList1);

		// Test if ArrayList 1 contains 30
		if (aList1.contains(30))
			System.out.println("ArrayList 1 contains 30.");
		else
			System.out.println("ArrayList 1 DOES NOT contain 30.");

		// Remove value from ArrayList 1
		aList1.remove(Integer.valueOf(60));
		printArrayList("\nArrayList 1 after value removed", aList1);
		System.out.println("The size of ArrayList 1 is " + 
			aList1.size() + ".");

		// Clear and print integer ArrayList 2
		aList2.clear();
		printArrayList("\nArrayList 2 after cleared", aList2);
		
  	// Clone ArrayList
		aList2 = (ArrayList<Integer>) aList1.clone();
		printArrayList("\nArrayList 1 after cloning", aList1);
		printArrayList("ArrayList 2 after cloning", aList2);
		aList2.set(0, 77);
		printArrayList("ArrayList 1 after element change", aList1);
		printArrayList("ArrayList 2 after element change", aList2);

      // Use for-each loop
  	System.out.println("\nFor-each looping through ArrayList 1");
  	System.out.print("[");
      for (int e : aList1)
      	System.out.printf(COLFMTD, e);
  	System.out.println("]");

		// Show application close
		System.out.println("\nEnd of ArrayLists");

  }

}
