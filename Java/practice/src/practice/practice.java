package practice;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class practice {


	public static void main(String... args) {
		Scanner keyboard = new Scanner(System.in);
	
		System.out.println("Enter a phrase: ");
		String s = keyboard.nextLine();
		while((s.length() == 1) && (s.charAt(0) != 'z'))
		{
			System.out.print("HAHAHAHAHA");
			System.out.println("Enter a phrase: ");
			String st = keyboard.nextLine();
			
		}
		System.out.println("\n worked ");
	}
}	

