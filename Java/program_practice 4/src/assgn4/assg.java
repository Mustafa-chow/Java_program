package assgn4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class assg {
public static final String FILE_NAME = "MicrosoftStockData.txt";
    
    
    static int dataCount =0;
	
	// Declare formatting constants
    public static final String COLFMT1 = "%s";
    public static final String COLFMT2 = "%15.2f";
    public static final String COLFMT3 = "%20d";
    public static final String COLFMT4 = "%10.2f";
    public static final String COLFMT5 = "%10.2f";
    public static final String COLFMT6 = "%20.2f";
    private static String header;
    public static void readTextFile(ArrayList<String> d, 
    		ArrayList<Double> c, ArrayList<Integer> v,
    		ArrayList<Double> o, ArrayList<Double> h, ArrayList<Double> l)
        {
            
            // Declare variables
            Scanner fileIn = null;
            boolean headerRead;
            String line;
            //int dataCount;
        
            // Attempt to open input file
            try
            {
            	
            	// Assign external file to file handle
                fileIn = new Scanner(new FileInputStream(FILE_NAME));
            
                // Loop to read data
                headerRead = false;
                //dataCount = 0;
                while (fileIn.hasNextLine())
                {
                    
                    // Read line and test if header row
                    line = fileIn.nextLine();
                	if (!headerRead)
                	{
                		header = line;
                		headerRead = true;
                	}
                	else
                	{
                		String[] split = line.split(",");
                		d.add(split[0]);
                		c.add(Double.parseDouble(split[1]));
                		v.add(Integer.parseInt(split[2]));
                		o.add(Double.parseDouble(split[3]));
                		h.add(Double.parseDouble(split[4]));
                		l.add(Double.parseDouble(split[5]));
                		

                        // Increment line counter
                        dataCount = dataCount + 1;
                       
                		
                	}

                }
                
                // Show number of lines read
                System.out.println(dataCount + " data line(s) " +
                        "read from file '" + FILE_NAME + "'.");
                // Close input file
                fileIn.close();
                
            }
            
            // Handle file error
            catch (FileNotFoundException e)
            {
                System.out.println("Error: file '" + FILE_NAME +
                    "' not found.");
                System.out.println("Default folder: " + 
                    System.getProperty("user.dir"));
                System.out.println("Error message:\n" + e.getMessage());
            }
        
        }
    
    @SuppressWarnings("resource")
	public static void printData(ArrayList<String> d, 
    		ArrayList<Double> c, ArrayList<Integer> v,
    		ArrayList<Double> o, ArrayList<Double> h, ArrayList<Double> l) throws IOException
    {
    	
    	System.out.println("\nFirs 12 days of data rangaing from "
    			+ d.get(0)+" - " + d.get(11));
    	System.out.println("Date\t\t Close\t\t Volume\t\t Open\t\t High\t\t low");
    	for (int i = 0; i<12; i++)
    	{
    		System.out.printf(
           		COLFMT1 + COLFMT2 + COLFMT3 + COLFMT4 + COLFMT5 + COLFMT6 + "%n", 
           		d.get(i), 
        		c.get(i), 
        		v.get(i), 
        		o.get(i),
        		h.get(i),
        		l.get(i));
    	}
    	
    }
    
    public static void analyzeData(ArrayList<String> d, 
    		ArrayList<Double> c, ArrayList<Integer> v,
    		ArrayList<Double> o, ArrayList<Double> h, ArrayList<Double> l, ArrayList<Integer> y, ArrayList<Double> endC)
    {

    	int i=0, maxIndex=-1; 
    	Double max= null;
    	for (Double x : c) 
    	{
		    if ((x!=null) && ((max==null) || (x>max))) 
		    {
		      max = c.get(i);
		      maxIndex = i;
		    }
		    i++;
    	 }
		 
    	
    	System.out.println("\nHighest closing stock data date: "+d.get(maxIndex) +" and value: "+c.get(maxIndex));
    	
		 int j =0, minIndex=-1; 
		 Double min= null;
		for (Double x : c) 
		{
		  if ((x!=null) && ((min==null) || (x<min))) 
		  {
		    min = c.get(j);
		    minIndex = j;
		  }
		  j++;
		}
	  	System.out.println("Lowest closing stock data date: "+d.get(minIndex) +" and value: "+c.get(minIndex));
	  	
	  	int idx = 0, diff_idx = -1;
	  	Double difference = null;
	  	
	  	for (Double x : h) 
		{
		  if ((x!=null) && ((difference==null) || (x<(h.get(idx) - l.get(idx))))) 
		  {
		    difference = h.get(idx) - l.get(idx);
		    diff_idx = idx;
		  }
		  idx++;
		}
	  	
	  	System.out.println("The higgestest difference is: "+ difference);// + 
	  	System.out.println("The date is: "+ d.get(diff_idx));
    	String[] only_year1 = d.get(0).split("/");
    	y.add(Integer.parseInt(only_year1[2]));
    	endC.add(c.get(0));
    	
    	
    	
    	
    	for (int index= 1; index<d.size(); i++)
    	{
    		String s1 = d.get(index);
    		String s2 = d.get(index -1);
    		int i1 = s1.length()-1;
    		int i2 = s2.length()-1;
    		if (s1.charAt(i1) != s2.charAt(i2))
    		{
    			only_year1 = new String[3];
    			only_year1 = d.get(0).split("/");
    			y.add(Integer.parseInt(only_year1[2]));
    			endC.add(c.get(0));
    			
    		}
    		
    		
    	}
    	for (int x = 0; x<y.size(); x++)
    	{
    		System.out.printf("%13s %13.2f", y.get(x), endC.get(x));
    	}
    	
    	
    }
	
    
    
    public static void main(String[] args) throws IOException
    {
        
        // Declare variables
        ArrayList<String> date = new ArrayList<String>();
        ArrayList<Double> close = new ArrayList<Double>();
        ArrayList<Integer> vol = new ArrayList<Integer>();
        ArrayList<Double> open = new ArrayList<Double>();
        ArrayList<Double> high = new ArrayList<Double>();
        ArrayList<Double> low = new ArrayList<Double>();
        ArrayList<Integer> year = new ArrayList<Integer>();
        ArrayList<Double> closing_val = new ArrayList<Double>();
        

        // Show application header
        System.out.println("Welcome to Text File Input And Output " +
    		"With File Specification");
        System.out.println("--------------------------------------" +
    		"-----------------------\n");

        // Load data from text file
        readTextFile(date, close, vol, open, high, low);
        printData(date, close, vol, open, high, low);
        analyzeData(date, close, vol, open, high, low, year, closing_val);

  

        // Show application close
        System.out.println("\nEnd of Text File Input And Output " +
    		"With File Specification");

    } 
	
}
