package DFA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DFA {
	static int pos_for_one;
	static int total_zero;
	
	public static void main (String... args) throws IOException
	{
		FileReader file_read=new FileReader("Input.txt");
		
		@SuppressWarnings("resource")
		BufferedReader buffer_read = new BufferedReader(file_read);
		String a;
		while ((a = buffer_read.readLine()) != null)
		{
			int length = a.length();
			
			boolean found = false;
			
			// looking for the position of the first one in binary string
			for (int i = 0; i<length; i++)
			{

				char ch = a.charAt(i);
				if (ch == '1')
				{
					pos_for_one = i;
					break;
				}	
			}
			
			// looking for any othe 1 after finding 1st one
			int second_pos_one = a.indexOf('1', pos_for_one + 1);
			
			// if there is no more 1 after first one
			if (second_pos_one == -1)
			{
				// culculating how many zero's after 1
				total_zero = length - pos_for_one + 1;
				
				// looking for even number of 0
				if (total_zero%2 == 0)
					found = true;
			}
			else
				found = false;
			
				
			if (found == true)
				System.out.println("\n"+a+": is accepted\n");
			else
				System.out.println(a+": is not accepted");
		}
	}

}
