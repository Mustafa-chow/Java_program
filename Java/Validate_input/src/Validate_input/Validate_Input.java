package Validate_input;

import java.util.Scanner;

public class Validate_Input {
	
	
	private static Scanner keyboard;

	

	public static void main(String[] args) {
		keyboard = new Scanner(System.in);
		
		System.out.println("Enter a Isbn number: ");
		String i = keyboard.nextLine();
		
		System.out.println("Enter a preriodic element: ");
		String t = keyboard.nextLine();
		
		
		
		System.out.println("Enter a state: ");
		String s = keyboard.nextLine();
		System.out.println("Enter a measurement: ");
		String m = keyboard.nextLine();

		if(!valaidate.Isbn(i))
		{
			System.out.println("Invalid isbn");
		}
		else 
			System.out.println("ok isbn");
		
		if(!valaidate.table(t))
		{
			System.out.println("Invalid table");
		}
		else
			System.out.println("table works");
		if (!valaidate.measurement(m))
		{
			System.out.println("Invalid measure");
		}
		else
			System.out.println(" measure works");

			
		if (!valaidate.state(s))
		{
			System.out.println("Invaid State");
		}
		else
			System.out.println("state ok");
		
	}

}

