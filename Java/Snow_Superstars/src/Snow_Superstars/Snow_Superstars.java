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




package Snow_Superstars;

//===========================================================
//class Snow_Superstars 
//===========================================================
public class Snow_Superstars {

	public static void main(String[] args) {
		
		//------------------------------
	    // main
	    //------------------------------
		
		// Show application header
		System.out.print("Welcome to snow superster\n--------------------------");
		
		// show how many argument passed
		System.out.println("\nNumber of arguments passed: " + args.length);
		
		System.out.println("\nIndex\t Argument");
		
		for (int i = 0; i<args.length; i++)
		{
			System.out.println(i + "\t " + args[i]);
		}
		
		// declare variable and sum arguments and 
		// convert it by using Integer.parseInt(arg[j])
		int total = 0;
		
		for (int j =0; j<args.length; j++)
		{
			total = total + Integer.parseInt(args[j]); 
		}
		
		System.out.printf("\nTotal: %5d %1s", total, "inch (es)");
		
		// declare variable 
		double avarage;
		avarage = (double)total / args.length;
		
		System.out.printf("\nAvarage: %9f %1s", avarage, "inch(es)\n");
		
		// Show application header
		System.out.println("\nEnd of snow superstars");

	}

}
