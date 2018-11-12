
//============================================================================================
//
// Title:      Camping Critters
// Course:     CSC 3020
// Homework:   Homework 5
// Author:     Mustafa Chowdhury, ge3306
// Date:       03/31/2018
// Description:
//   This program have 2 classes (1)HW5.java and (2) Product.java
// In HW5.java:  its read file and save all information into an object. And its keep track of the sell product
// and ordered product. every time when products sell or order its update all inventory information which is 
// located into Product.java class
// At last this program write a file and store all updated information inventory into that file
//
//=====================================================================================================



// package
// this package also contains Product.java class
package HW5;

// importing packages
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


// class HW5
public class HW5 {
	
	// write file name
	public static String fileName_out = "ProductInventoryOut.txt";
	
	// read file name
	public static final String FILE_NAME = "ProductInventoryIn.txt";
	
	//public static 
	static int lineCount = 0;
	static int option;
	static int p_code;
	static int quantity;
	
	// creating global keyboard
	public static Scanner keyboard = new Scanner(System.in);
	
	
	
	
	// this method print the menu
	public static void showMenu()
	{
		//------------------------------------------
		// showMenu
		// --------------------------------------------
		
		//printing menu
		System.out.println("\n\n   Camping Critters Menu\n"
				+ " __________________________\n");
		System.out.println("  1 - Sell product");
		System.out.println("  2 - Order product");
		System.out.println("  3 - List product inventory");
		System.out.println("  4 - Exit");
		
		System.out.print("\nEnter an option: ");	
	}
	
	
	
	//		*****   ####  ^^^ ******* !!!!!!!! ###########
	
	
	
	// this method read the text file and save data into object
	public static void readFile(Product obj[]) throws NumberFormatException, IOException
	{
		
		//----------------------------------------------
		// readFile
		//---------------------------------------------
		
		
		// read the file using BufferReader
		FileReader file_read=new FileReader(FILE_NAME);
	    BufferedReader buffer_read=new BufferedReader(file_read);
	    String line;
	   
	    
	    // using loops to store data into object's array
	    while ((line=buffer_read.readLine())!=null) {
	      
	    	// cut the whiteSpace using substring and 
	    	// than trim remove trailing and forward spaces
	        obj[lineCount] = new Product(Integer.parseInt(line.substring(0,6).trim()), 
	        								line.substring(7,31).trim(),
	        								Double.parseDouble(line.substring(33,42).trim()),
	        								Integer.parseInt(line.substring(45,51).trim()));

	        
	        // increment the line until the line is NULL
	        lineCount = lineCount + 1;
	    }
	    buffer_read.close();
	    file_read.close();

	}
	
	
	
	
	// 	++++++++++++++++++ --------------- ****************** /////////////////
	
	
	
	
	
	// this method update inventory after sell
	public static void sellProduct(Product obj[]) throws IOException
	{
		// --------------------------------------------
		// sellProduct
		//---------------------------------------------
		
		// Declaring variable
		int i;
		int idx = -1;
		
		// validating user input
		// Prompt user to input correct code until its get the correct code 
		do
		{
			System.out.print("Please enter the product code you want to sell: \n");
		
			p_code = keyboard.nextInt();
			
			for (i = 0; i<obj.length; i++)
			{
				if (p_code == obj[i].getCode())
				{
					idx = i;
				}
			}
		}while(idx == -1);
		
		
		// this statement execute when product count is greater than 0
		if (obj[idx].getCount() >0)
		{
		
	
			System.out.print("Please enter the quantity of the product you want to sell: \n");
			
			quantity = keyboard.nextInt();
			
			
		
			
			while((quantity < 1) ||  (quantity > obj[idx].getCount() ) )
			{
				System.out.print("Please enter the quantity of the product you want to sell: \n");
				quantity = keyboard.nextInt();
				
			}
			
			// updating product count 
			obj[idx].setCount(obj[idx].getCount() - quantity);
			
			// calling method, 
			// this method update all inventory info
			total_inventory_data(obj);
			
			//printing sold product info 
			System.out.println("\nSold Product ("+ obj[idx].getName() +") Information:\n");
			
			//print sold product info's
			// in two columns. 1st column is label and 2nd column is product info
			System.out.printf("\t%-1s%23d  %n\t%-1s%27d %n\t%-1s%,14.2f ", "Product Code:",obj[idx].getCode(), "Quantity:",quantity,
					"Reveneu from the sale:",(obj[idx].getCost() * quantity));
			System.out.println("\n\t--------------------------------------\n");
			
			// write the file after updated
			file_Write(obj);
				
			
		}
		// if product count is 0, it will show this message
		else
		{
			System.out.println("\nERROR:\n******"
					+ "\n\tThere are no more quantity left to sell of the *" + obj[idx].getName()+ "* product"
							+ "\n\tPlease order the *" +  obj[idx].getName()+ "* product.\n");
		}
		
	}
	
	
	
	
	//      ========= ======= ========= =========== ============ ========== =========== =========
	
	
	
	// this method update inventory after  products ordered
	public static void orderProduct(Product[] obj) throws IOException
	{
		//----------------------------------------
		// orderProduct
		//----------------------------------------
		
		// Declaring local variable
		int i;
		int idx = -1;
		
		//  validating user input
		do
		{
			System.out.print("Please enter the product code that you want to order: ");
			//if (keyboard.hasNextInt())
			p_code = keyboard.nextInt();
			
			for (i = 0; i<obj.length; i++)
			{
				if (p_code == obj[i].getCode())
				{
					idx = i;
				}
			}
		}while(idx == -1);
		
		
		if (idx != -1)
		{
			int quantity;
			
			// validating product quantity
			System.out.print("Please enter the quantity of the product you want to order: ");
			
			quantity = keyboard.nextInt();
			while(quantity < 1)
			{
				System.out.print("Please enter the quantity of the product you want to order: ");
				quantity = keyboard.nextInt();	
			}
		
			// increasing quantity for the product
			obj[idx].setCount(obj[idx].getCount() + quantity);
			
			
			// calling function
			total_inventory_data(obj);
			
			
			// print details about product ordered
			System.out.println("\nInformation about Orderd Products (" + obj[idx].getName()+"):\n");
			
			
			
			//print order product info's
			// in two columns. 1st column is label and 2nd column is product info
			System.out.printf("\t%-1s%19d  %n\t%-1s%23d %n\t%-1s%,14.2f ", "Product Code:",obj[idx].getCode(), "Quantity:",quantity,
					"Cost of the order:",(obj[idx].getCost() * quantity));
					
			System.out.println("\n\t----------------------------------\n");
			
			// write the file after updated
			file_Write(obj);
			
		}
		
	}
	
	
	
	// 		^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	
	
	
	// method total_inventory_data
	// which update all products information
	@SuppressWarnings("static-access")
	public static void total_inventory_data(Product[] inventory_data)
	{
		//-----------------------------------------
		// this method count update all the data
		//------------------------------------------
		int  total_icount = 0;
		double total_ivalue = 0;
		for(int i= 0; i <inventory_data.length; i++)
		{
			// set the updated product count
			inventory_data[i].setProductCount();
			
			// set the total inventory count after updated
			total_icount = total_icount + inventory_data[i].getCount();
			inventory_data[i].setInventoryCount(total_icount);
			
			// set the total inventory value after updated
			total_ivalue = total_ivalue + (inventory_data[i].getCost() * inventory_data[i].getCount());
			inventory_data[i].setInventoryValue(total_ivalue, total_icount);
			
		}
		
	}
	
	@SuppressWarnings("static-access")
	public static void print_Product_Inventory(Product[] inventory_data)
	{
		//--------------------------------------------
		// print_Product_Inventory
		//-----------------------------------------------
		
		// Declaring variable
		int total_pCount = 0, total_icount = 0;
		double total_ivalue = 0;
		
		// updating Inventory information
		for(int i= 0; i <inventory_data.length; i++)
		{
			// set the updated product count
			total_pCount++;
			inventory_data[i].setProductCount();
			
			// set the total inventory count after updated
			total_icount = total_icount + inventory_data[i].getCount();
			inventory_data[i].setInventoryCount(total_icount);
			
			// set the total inventory value after updated
			total_ivalue = total_ivalue + (inventory_data[i].getCost() * inventory_data[i].getCount());
			inventory_data[i].setInventoryValue(total_ivalue, total_icount);
			
		}
		
		// printing total Inventory info
		System.out.printf("Product Count: %15s", total_pCount);
		System.out.printf("\nInventory Value: %13.2f", total_ivalue);
		System.out.printf("\nInventory Count: %13d\n", total_icount);
		
	}
	
	
	//					-!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!      
	
	
	
	// Method listProduct_inventory
	public static void listProduct_inventory(Product[] obj) throws IOException
	{
		//-------------------------------------
		// this method print all data
		//--------------------------------------
		
		// Show number of lines read
	    System.out.println(lineCount + " data line(s) " +
              "read from file '" + FILE_NAME + "'.");
		
		// printing data about all inventory info
		
		System.out.printf("\n\t %13s %20s %20s %20s %n",
				"Product Code", "Product Name", "Product Price", "Product Quantity");
		
		System.out.println("\t -----------------------------------------"
				+ "--------------------------------------");
		
		// print all the stock information about the product
		for(int i=0 ; i< obj.length; i++) {
			System.out.printf("\t%13d %20s %20.2f %20d\n",
				obj[i].getCode(), obj[i].getName(), obj[i].getCost(), obj[i].getCount());

		}

		System.out.println("\t ____________________________________________________"
				+ "_______________________________\n\n");
		
		
		
		// Calling method
		print_Product_Inventory(obj);
			
	}
	
	
	//	------- *********** ------------ **************
	
	
	//write a file
	public static void file_Write(Product[] obj) throws IOException
	{
			//--------------------------
			// 	file_write
			// -------------------------
				
			FileWriter f_write = new FileWriter(fileName_out);
		
			BufferedWriter bw = new BufferedWriter(f_write);
			
			
			// write in the file
			for(int i=0 ; i< obj.length; i++)
			{
				bw.write(String.format("%-5d %-12s %13.2f %8d%n",
						obj[i].getCode(), obj[i].getName(), obj[i].getCost(), obj[i].getCount()));
				
			}
			
			// closing file
			bw.close();
	}
	
	
	//		***********************************************************************************
	
	
	
	
	// method main
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		//---------------------------------------
		// main
		//---------------------------------------
		
		// show application header
		System.out.println("Welcome to the Camping Critters"
				+ "\n-----------------------------------------------------");
		
		
		// Declaring size
		int size = 10;
		
		
		// declaring an object of class Product
		Product[] products = new Product[size];
		
		
		// read data from the text file
		readFile(products);
		
		
		// loops run unit user enter 4
		do
		{
			// calling menu function
			showMenu();
			option = keyboard.nextInt();
			
			
			if (option == 1)
			{
				//calling sellProduct method
				sellProduct(products);
			
			}
			
			
			
			else if (option == 2)
			{
				// calling orderProduct method
				orderProduct(products);
				
			}
			
			
			else if (option == 3)
			{
				// calling listProduct_inventory method
				listProduct_inventory(products);
				
			}
			
			
			else if (option ==4)
			{
				// show application footer
				System.out.println("\n----------------------"
						+ "-----------------------------\nThank you");
				// closing keyboard
				keyboard.close();
				
				// write the file before close
				file_Write(products);
				
				// system exit
				System.exit(0);
			}
			else
			{
				System.out.println("\nInvalid Entry");
			}
			
		}while (true);	
		
	}

}


