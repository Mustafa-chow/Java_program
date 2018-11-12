package Sort_Scorchers;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.lang.String;

public class Sort_Scorchers {
	
	private static final String COLFMTD1 = "%,16d";
	private static final String COLFMTD2 = "%,1d";
	private static final String COLFMTD3 = "%,6d";
	private static final String COLFMTS1 = "%6s";
	private static final String COLFMTS2 = "%-12s";
	private static final String COLFMTS3 = "%16s";
	private static final String COLFMTS4 = "%1s";
	
	  private static void printArrayList(double[] al)
	  {
	  	
		  System.out.printf("Index \t%8s", "Value at Index\n");
		 // System.out.printf("--------%3s\t","-----------------\n");
	  	// Loop to print ArrayList
	  	
		  //printing 1st 10 elements from the list
	      for (int i = 0; i < 10; i++)
	      {
	    		  System.out.printf("%2d \t%8.1f%n",i, al[i]);
	      }
	  	
	
	  }
	  
	  private static void randomizeArray(double[] arr, double min, double max)
	  {
    	
    	// Loop to generate and store in array random numbers from 1
    	// to upperLimit
    	Random rand = new Random();
        for (int i = 0; i < arr.length; i++)
        	arr[i] = (double)(rand.nextInt((int)(max-min)) + min);
        
	  }
	  
	  static long swaps = 0, cycles=0, total=0;
	  private static void insertionSortArray(double[] arr)
	  {
    	
    	// Declare variables
    	double value;
    	int spot;
    	long cycles = 0;
    	long swaps = 0;
    	
    	// Loop to test each value
    	for (int i = 1; i < arr.length; i++)
    	{
        	
        	// Loop to find spot to place value
    		value = arr[i];
    		spot = i - 1;
		    while (spot >= 0 && arr[spot] > value)
		    {
		        arr[spot + 1] = arr[spot];
        		swaps = swaps + 1;
        		cycles = cycles + 1;
		        spot = spot - 1;
		    }
		    
		    // Place value in spot
		    arr[spot + 1] = value;
		    
    	}
    	total = swaps+cycles;
    	// Return cycles and swaps
    
    }

	public static void main(String[] args) {
	
		Scanner keyboard = new Scanner(System.in);
		
		double smaller, larger;
		boolean situation = true;
		long before, after, t;
		
		String results;
		
		System.out.println("Please enter the size of the array\n");
		int size = keyboard.nextInt();
		
		
		double[] list = new double[size];
		
		System.out.println("\nPlease set the range between 10 to 10000\n");
		
		System.out.println("Enter the lowerbound (>=10)");
		
		smaller = keyboard.nextDouble();
		
		System.out.println("\nEnter the upperbound (<=10000)");
		larger = keyboard.nextDouble();
		
		while(situation)
		{
			
			
			if (smaller>=10 && (larger>smaller && larger<=10000))
			{
				
				situation = false;
			}
			
			else if (smaller < 10 || (larger<smaller || larger >10000))
			{
				System.out.println("\nInvalid entry");
				
			}
			
		}
		randomizeArray(list, smaller, larger);
		
		printArrayList(list);
		
		
		
		
		double[] sorted_array = new double [size];
		sorted_array = Arrays.copyOf(list,
	    		list.length);
	    before = System.currentTimeMillis();
	    insertionSortArray(sorted_array);
	    after = System.currentTimeMillis();
        t = after - before;
        printArrayList(list);
        
        System.out.printf(COLFMTS2 + COLFMTS3 + COLFMTS3 + COLFMTS3 +
				COLFMTS3 + "%n", "Sort method", "Cycles", "Swaps", 
				"Total", "Time (ms)");
        
	    System.out.printf(COLFMTS2 + COLFMTS4 + COLFMTS4 + "%n", 
				"Insertion", swaps, cycles, total, t);
	}

	
	
}	


