
//================================================================================================================
//
// Title:      Sort Scorchers 
// Course:     CSC 3020
// Homework:   Homework 3
// Author:     Mustafa Chowdhury, ge3306
// Date:       02/22/2018
// Description:
//
//	application that sorts an array list of random real numbers.  
//	Use a validation loop to prompt for and get from the user the number of real numbers to sort in the range 10-10,000.  
//	Create and store in the array list that many random real numbers.  Randomly generate the real numbers in the range 0-1,000. 
//	Print the array list size and use formatted output to print the first ten values of the array list in two columns:
//	 The first column is the zero-based index of the value.
//	The second column is the right-justified value.
//	Use the insertion sort method to sort the array list.  
//	Monitor the number of cycles and swaps during the sort, and the elapsed time in milliseconds to complete the sort.  
//	Use formatted output to print the results (cycles, swaps, total cycles and swaps, and elapsed time) in two columns:
//
//===================================================================================================================


package pracHW_3_a;

// import packages
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//===========================================================
//class 
//===========================================================
public class pracHW_3_a {

	static int size=0;
	
	
	
	// print method
	  private static void printArrayList(ArrayList<Double> al)
	  {
		  	//------------------------------
		    // printing the 1st 10 value form
			// the list
		    //------------------------------
	  	
		  System.out.printf("Index \t%8s", "Value at Index\n");
		  System.out.printf("%s\t%5s", "------", "---------------\n");
		  
	  	// Loop to print ArrayList
	      for (int i = 0; i <al.size(); i++)
	      {
	    	  System.out.printf("%2d \t%,8.1f%n",i, al.get(i));
	    	  if (i == 9)
	    		  break;
	      }
	      System.out.println("\n");
	  }
	  
	  
	  
	  // generate random number and store it into the array list
	  private static void randomizeArray(ArrayList<Double> al, double min, double max)
	  {
		
		// Loop to generate and store in array random numbers from min
		// to max
		Random rand = new Random();
	    for (int i = 0; i <size; i++)
	    	//al.add((double)(rand.nextInt((max-min) + min)+1);
	    	al.add((min+(double)rand.nextInt((int) (max-min+1))));
	    
	  }
	  
	  
	  // declare static variable
	  static long swaps = 0;
	  static long cycles = 0;
	  static long total = 0;
	
	  
	 // method that will sort the array list
	private static void InsertationSort(ArrayList<Double> a)
	{
		// declare variable
		double temp;
		int loc, i;
		int length = a.size();
		for(i = 1; i<length;i++)
		{
			temp = a.get(i);
			loc = i-1;
			while(loc>=0 && a.get(loc)>temp)
			{
				a.set(loc+1, a.get(loc));
				loc--;
				swaps++;
				cycles++;
			}
			a.set(loc+1, temp);
		}
		
		
		total = swaps+cycles;
		
		System.out.println("\n");
	}
	
	

	public static void main(String[] args) {
	
		//------------------------------
	    // main
	    //------------------------------
		
		// creating keyboard for user input
		Scanner keyboard = new Scanner(System.in);
		
		//declare variable
		double smaller, larger;
		boolean situation = true;
		long before, after;
		
		// application header
		System.out.println("Welcome to The  Sort Scorchers");
		System.out.println("--------------------------------\n");
		
		System.out.print("Please enter the size (10-10000) of the array list: \n");
		size = keyboard.nextInt();
		while(true)
		{
			if (size<10 || size >10000)
			{
			System.out.println("\nInvalid Entry");
			System.out.print("Please enter the size (10-10000) of the array list: \n");
			size = keyboard.nextInt();
			}
			else
				break;
		}
		
		// loop run until validation
		while(situation)
		{
			
			// crating array list
			// than ask user for the range to generate
			//random value and store into the array list of each index
			ArrayList<Double> list = new ArrayList<Double>(size);
			
			System.out.println("Please set the random number (range 1-1000) of the value "
					+ "that will store in the array list\n");
					
			
			System.out.print("Enter the lowerbound: (>=0)\n");
			
			smaller = keyboard.nextDouble();
			
			System.out.println("\nEnter the upperbound: (<=1000)\n");
			larger = keyboard.nextDouble();
			
			
			// validate user input
			if (smaller>=0 && (larger>smaller && larger<=1000))
			{
				
				// call the method with actual parameter
				randomizeArray(list, smaller, larger);
				
				
				//call the method to print the list before sorting
				System.out.println("\nBefore Sorting");
				printArrayList(list);
				
				
				InsertationSort(list);
				// printing print function again after sorting
			    System.out.println("After Sorting\n");
			    printArrayList(list);
				
			    
			    
				// calculating the time of occurring insertion sort
				before = System.currentTimeMillis();
				InsertationSort(list);
			    after = System.currentTimeMillis();
					
			    
			    System.out.printf("Array Size: %,4d%n", list.size());
			    System.out.print("-----------------------\n");
			    
			    
			    // left justified column 1 and right justified column 2
				System.out.printf("%n%-1s %15s %n%-1s%,22d %n%-1s %,20d %n%-1s%,22d %n%-1s%19.1f %n ",
						"Sort Method","Insertation", "Swaps",swaps, "Cycles",cycles, "Total",total, "Time(ms)",(double)(after-before));
				
				
			 
			    // exiting while loop
				situation = false;
			}
			
			
			
			else if (smaller < 0 || (larger<smaller || larger >1000))
				System.out.println("\nInvalid entry");
			
			
		}// end while loop
		
		
		
		// application footer
		System.out.println("__________________________________"
				+ "____________________________________");
		System.out.println("\nThank you for using the app");
		
		// Closing keyboard
		keyboard.close();
		
	}// end main
		

}
