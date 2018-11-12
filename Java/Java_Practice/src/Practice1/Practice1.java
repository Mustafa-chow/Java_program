//======================================================================
//
// Title:      Snow Superstars 
// Course:     CSC 3020
// Homework:   Homework 1
// Author:     Mustafa Chowdhury, ge3306
// Date:       01/22/2018
// Description:
//   calculates and shows the total and average snow fall 
// for three winter months by passing argument
// 
//======================================================================


package Practice1;

// import class
import java.util.Scanner;

//===========================================================
//class Mustafa_Chowdhury_hw01
//===========================================================
public class Practice1 {

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
	    	  System.out.printf("%2d \t%8.1f%n",i, al.get(i));
	    	  if (i == 9)
	    		  break;
	      }
	      System.out.println("\n");
	  }
	  
	  
	  
	  // generate random number and store it into the array list
	  private static void randomizeArray(ArrayList<Double> al, int min, int max)
	  {
		
		// Loop to generate and store in array random numbers from min
		// to max
		Random rand = new Random();
	    for (int i = 0; i <size; i++)
	    	//al.add((double)(rand.nextInt((max-min) + min)+1);
	    	al.add((double) (min+rand.nextInt(max-min+1)));
	    
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
		int smaller, larger;
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
					
			
			System.out.print("Enter the lowerbound: (>=1)\n");
			
			smaller = keyboard.nextInt();
			
			System.out.println("\nEnter the upperbound: (<=1000)\n");
			larger = keyboard.nextInt();
			
			
			// validate user input
			if (smaller>=1 && (larger>smaller && larger<=1000))
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
					
			    
			    System.out.printf("Array Size: %4d%n", list.size());
			    System.out.print("-----------------\n");
			    
			    
			    // left justified column 1
				System.out.printf("%n%-1s %15s %n%-1s%,22d %n%-1s %,20d %n%-1s%,22d %n%-1s%19.1f %n ",
						"Sort Method","Insertation", "Swaps",swaps, "Cycles",cycles, "Total",total, "Time(ms)",(double)(after-before));
				
				
				// right justified column 2
			    //System.out.printf("\n%15s %,12d %,15d %,14d %14d %n", 
			    		//"Insertation", swaps, cycles, total, (after-before));
				situation = false;
			}
			
			
			
			else if (smaller < 1 || (larger<smaller || larger >1000))
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

}
