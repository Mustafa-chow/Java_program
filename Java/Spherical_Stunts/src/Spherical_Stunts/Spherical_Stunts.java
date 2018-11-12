//======================================================================
//
// Title:      Spherical Stunts
// Course:     CSC 3020
// Homework:   Homework 1
// Author:     Mustafa Chowdhury, ge3306
// Date:       01/22/2018
// Description:
//   Calculate the radius, volume, circumference, and surface area 
//  after asking user to enter radius
//
//======================================================================


package Spherical_Stunts;

//import classes
import java.util.Scanner;

//===========================================================
//class Spherical Stunts
//===========================================================
public class Spherical_Stunts {

	public static void main(String[] args) {
		
		//------------------------------
	    // main
	    //------------------------------
		
		Scanner keyboard = new Scanner(System.in);
		
		// Show application header
		System.out.print("Welcome to Spherical Stunts");
		System.out.print("\n---------------------------");
		
		// declare variable and output the radius calculation
		double radius;
		System.out.print("\n\nEnter the radius in cm: ");
		radius = keyboard.nextDouble();
		
		System.out.printf("\nRadius: %20.3f %2s", radius, "cm");
		
		// declare variable and output the volume calculation
		double v = (4./3) * Math.PI * radius * radius * radius;
		System.out.printf("\nVolume: %20.3f %2s", v, "cm^3");
		
		// declare variable and output the circumference calculation
		double c = 2 * Math.PI * radius;
		System.out.printf("\nCircumference:%14.3f %2s", c, "cm");
		
		// declare variable
		double s_area = 4 * Math.PI * radius *radius;
		System.out.printf("\nSurface area: %14.3f %2s", s_area, "cm^2");
		
		// close keyboard
		keyboard.close();
		
		// show application close
		System.out.println("\n\nEnd of Spherical Stunts");
		
	}

}
