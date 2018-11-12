
//======================================================================
//
// Title:      Money Monarchs
// Course:     CSC 3020
// Homework:   Homework 2
// Author:     Mustafa Chowdhury, ge3306
// Date:       02/06/2018
// Description:
//   application that converts between currencies US Dollar ($), Euro (€), and Japanese Yen (¥).  
//	Prompt the user for a conversion code to convert the currency
//
//======================================================================


package Money_monarchs;

//import classes
import java.util.Scanner;

//===========================================================
//class Money_monarchs
//===========================================================

public class Money_monarchs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//------------------------------
	    // main
	    //------------------------------
		
		// creating keyboard for input 
		Scanner keyboard = new Scanner(System.in);
		
		
		// declaring string variables and store UNI code 
		// of the currency of Japanese Yen, USD, Euro
		final String y = "\u00A5";
		final String d = "\u0024";
		final String e = "\u20AC";
		
		
		
		// show application header
		System.out.println("Welcome to the Money Monachers\n-------------------------------");
		
		
		// print out menu for the user 
		System.out.println("\n[Press a] US Dollar -> Euro"
				+ "\n\n[Press b] US Dollar -> Japanese Yen"
				+ "\n\n[Press c] Euro -> US Dollar"
				+ "\n\n[Press d] Euro -> Japanese Yen"
				+ "\n\n[Press e] Japanese Yen -> US Dollar"
				+ "\n\n[Press f] Japanese Yen -> Euro"
				+ "\n\n[Press x] Exit\n");
	
		
		
		// while loop execute until user chose to exit
		while(true)
		{
			// ask user to enter an option and only take the 1st element by using charAt
			System.out.print("\nPlease choose an option: ");
			char n = keyboard.next().charAt(0);
			
			System.out.println("____________________________");
			
			
			
			// switch statement
			switch(n) 
			{
			
			case 'a':
				
				System.out.print("\nEnter US dollar that you want to convert the Euro: ");
				double us_dollar = keyboard.nextDouble();
				
				
				// calculate the conversation rate
				final double euro = 0.81;
				double converted_euro = us_dollar * euro;
				
				
				// show the conversion rate of the currency
				System.out.printf("%n%s%1.2f %s %s%1.2f %s", d, us_dollar, "USD =", e, converted_euro, "Euro\n");
				
				break;
				
			
			case 'b':
				
				System.out.print("\nEnter US dollar that you want to convert into Japanese Yen: ");
				double us_dollar1 = keyboard.nextDouble();
				
				
				// calculate the conversation rate
				final double yen = 108.68;
				double converted_yen = us_dollar1 * yen;
				
				
				// show the conversion rate of the currency
				System.out.printf("%n%s%1.2f %s %s%1.2f %s", d, us_dollar1, "USD =", y, converted_yen, "Japanese Yen\n");
				
				break;
				
			
			case 'c':
				
				System.out.print("\nEnter Euro that you want to convert into US Dollar: ");
				double euro1 = keyboard.nextDouble();
				
				
				// calculate the conversation rate
				final double us_dollar2 = 1.24;
				double converted_dollar = us_dollar2 * euro1;
				
				
				// show the conversion rate of the currency
				System.out.printf("%n%s%1.2f %s %s%1.2f %s", e, euro1, "Euro =", d, converted_dollar, "USD\n");
				
				break;
				
			
			case 'd':
				
				System.out.print("\nEnter Euro that you want to convert into Japanese Yen: ");
				double euro2 = keyboard.nextDouble();
				
				
				// calculate the conversation rate
				final double yen1 = 134.28;
				double converted_yen1 = yen1 * euro2;
				
				
				// show the conversion rate of the currency
				System.out.printf("%n%s%1.2f %s %s%1.2f %s", e, euro2, "Euro =", y, converted_yen1, "Japanese Yen\n");
				
				break; 
				
			
			case 'e':
				
				System.out.print("\nEnter Japanese Yen that you want to convert into US Dollar: ");
				double yenn = keyboard.nextDouble();
				
				
				// calculate the conversation rate
				final double dollars = 0.0092;
				double converted_dollars = yenn * dollars;
				
				
				// show the conversion rate of the currency
				System.out.printf("%n%s%1.2f %s %s%1.2f %s", y, yenn, "Japanese Yen =", d, converted_dollars, "USD\n");
				
				break;
			
			
			case 'f':
				
				System.out.print("\nEnter Japanese Yen that you want to convert into Euro: ");
				double yennn = keyboard.nextDouble();
				
				
				// calculate the conversation rate
				final double euros = 0.0074;
				double converted_euros = yennn * euros;
				
				
				// show the conversion rate of the currency
				System.out.printf("%n%s%1.2f %s %s%1.2f %s", y, yennn, "Japanese Yen =", e, converted_euros, "Euro\n");
				
				break;
			
			
			case 'x':
				
				// closing keyboard
				keyboard.close();
				
				
				// show closing statement and exit the program
				System.out.println("\nThank you for using Money Monarchs");
				System.out.println("\nExiting.........");
				
			
				return;
				
			default:
				
				// execute when user input enter different character 
				System.out.println("\nInvalid entry");
				
				break;
				
			}// end switch statement
			
			
		} // end while loop
		
	}

}
