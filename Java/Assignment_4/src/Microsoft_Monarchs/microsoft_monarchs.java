package Microsoft_Monarchs;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;



public class microsoft_monarchs {
	
	
    
    
    static int dataCount =0;
	
	// Declare formatting constants
    private static String header;
    public static void readTextFile(ArrayList<String> d, 
    		ArrayList<Double> c, ArrayList<Integer> v,
    		ArrayList<Double> o, ArrayList<Double> h, ArrayList<Double> l)
        {
            
            // Declare variables
            Scanner fileIn = null;
            boolean headerRead;
            String line;
          
        
            // Attempt to open input file
            try
            {
            	
            	// Assign external file to file handle
                fileIn = new Scanner(new FileInputStream("MicrosoftStockData.txt"));
            
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
                        "read from file '" + "MicrosoftStockData.txt" + "'.");
                // Close input file
                fileIn.close();
                
            }
            
            // Handle file error
            catch (FileNotFoundException e)
            {
                System.out.println("Error: file '" + "MicrosoftStockData.txt" +
                    "' not found.");
                System.out.println("Default folder: " + 
                    System.getProperty("user.dir"));
                System.out.println("Error message:\n" + e.getMessage());
            }
        
        }
    
 
	public static void printData(ArrayList<String> d, 
    		ArrayList<Double> c, ArrayList<Integer> v,
    		ArrayList<Double> o, ArrayList<Double> h, ArrayList<Double> l) throws IOException
    {
    	
    	System.out.println("\nFirs 12 days of data rangaing from "
    			+ "3/5/2018 - 2/15/2018");
    	int i =0;
    	//for (int i = 0; i<12; i++)
    	while (i !=12)
    	{
    		System.out.printf("%-13s %13.2f %,15d %13.2f %13.2f %13.2f%n", d.get(i), c.get(i), v.get(i), o.get(i),h.get(i), l.get(i));
    		i++;
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

		Double diff = h.get(0) - l.get(0);
		int diff_idx = 0;
		for (int idx = 0; idx<h.size(); idx++)
		{
			if ((h.get(idx) -l.get(idx))>diff)
			{
				diff = h.get(idx) -l.get(idx);
				diff_idx = idx;
			}
				
		}
	  	
	  	
	  	

    	
    	String[] only_year = d.get(0).split("/");
	  	y.add(Integer.parseInt(only_year[2]));
    	endC.add(c.get(0));
    	for (int index= 1; index<d.size(); index++)
    	{
    		String s1 = d.get(index);
    		String s2 = d.get(index -1);
    		int i1 = s1.length()-1;
    		int i2 = s2.length()-1;
    		if (s1.charAt(i1) != s2.charAt(i2))
    		{
    			only_year = new String[3];
    			only_year = d.get(index).split("/");
    			y.add(Integer.parseInt(only_year[2]));
    	    	endC.add(c.get(index));
    		}
    		
    	}
    	
    	System.out.printf("%n%13s %20s", "Year", "Closing Value");
    	for (int x = 0; x<y.size(); x++)
    	{    		
    		System.out.printf("\n%13s %13.2f",y.get(x), endC.get(x));
    	}
    	
    	// print
    	
    	System.out.printf("\n\n %10s %23s %15s %n", "Labels", "Date", "Value");
    	System.out.printf("%-25s %10s %14.2f", "Highest Close Data",d.get(maxIndex), c.get(maxIndex));
    	System.out.printf("\n%-25s %10s %14.2f", "Lowest Close Data",d.get(minIndex), c.get(minIndex));
    	System.out.printf("\n%-25s %10s %14.2f", "High/Low Difference",d.get(diff_idx), diff);
    	
    	
    	
    }
	
    private static void chartData(ArrayList<Double> yearEndClosingV, ArrayList<Integer> endY)
    {
    	// Create panel and frame
        JPanel panel = createPanel(yearEndClosingV,endY);
        JFrame frame = new JFrame();
        frame.setSize(2400, 1800);
        frame.setTitle("Microsoft Stock Data");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Add panel to frame and show frame
        frame.add(panel);
        frame.setVisible(true);
    	
    }
  //------------------------------------------------------------------
    // createPanel
    //------------------------------------------------------------------
    public static JPanel createPanel(ArrayList<Double> yearEndClosingV, ArrayList<Integer> endY)
    {
    	DefaultCategoryDataset dataset = createDataset(yearEndClosingV, endY);
    	JFreeChart chart = createChart(dataset);  
    	JPanel panel = new ChartPanel(chart);
    	return panel;
    }
    private static DefaultCategoryDataset createDataset(ArrayList<Double> yearEndClosingV, ArrayList<Integer> endY)
    {
    	
        // Create dataset object
    	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    	
        // Loop to set dataset pairs (label, value)
    	for (int i = yearEndClosingV.size()-1; i != -1; i--)
    		dataset.setValue(yearEndClosingV.get(i), "", endY.get(i)); 
    	return dataset;
    	
    }
    
    
    
    private static JFreeChart createChart(DefaultCategoryDataset dataset)
    {
    	JFreeChart chart = ChartFactory.createLineChart(      
			"Microsoft Stock Data", "Year", "Stock Price" ,dataset);
    	return chart;
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

        chartData(closing_val, year);

        // Show application close
        System.out.println("\n\nEnd of Text File Input And Output " +
    		"With File Specification");

    } 
	
}