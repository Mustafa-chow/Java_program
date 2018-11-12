

//=======================================================================================================================
//
// Title:      Millennial Mart 
// Course:     CSC 3020
// Homework:   Homework 6
// Author:     Mustafa Chowdhury, ge3306
// Date:       04/14/2018
// Description:
//   This program have 2 classes (1)HW6.java and (2) Customer.java
//
// In HW5.java:  
//		This class contains the main method and uses the Customer class to represent each customer in the store checkout line.
//		The line is represented as a queue (first-in first-out).  Begin with an empty queue
//	    In the main method, loop twenty times.  Within each loop, either add a customer to the queue or remove a customer 
//		from the queue, and then print the customers in the queue.  Add a customer if the queue is empty 
//		or if a randomly generated value is true (use random function nextBoolean for this). Otherwise, remove a customer.  
// 		Print a message showing the ID of the customer added or removed.  
//
//==========================================================================================================================


// package
package HW6;

// import package
import java.util.Random;


//=============================
// Class HW6
//=========================
public class HW6 {

	
	// static variables
	static int total_customer=0;
	static int customer_handled = 0;
	static int customer_in_queue=0;
	static double cost = 0.0;
	static int total_item = 0;
	static int num_of_customer = 0;
	
	
	
	// creating two sential nodes
	// of type Customer
	Customer head, tail;
	
	// HW6 constructor and 
	// both sential nodes point to null
	HW6()
	{
		head = null;
		tail = null;
	}
	

	
	// insert method
	void insertCustomer(Customer ptr)
	{
		//-------------------------------
		// insertCustomer
		// ----------------------------
		
		// if linked list is not empty 
		// than tail next is pointing to next node and 
		//afterthat update the tail node and point to the newnode
	
		if (this.head != null)
		{
			this.tail.setNext(ptr);
			this.tail = ptr; 
		}
		else
		{
			// if head is null than new node created and 
			//than head and tail both pointing to new node
			this.head = ptr;
			this.tail = ptr;
		}
		num_of_customer++;

	}
	

	
	// removeCustomer method of type class Customer
	Customer removeCustomer()
	{
		//-------------------------------
		// removeCustomer
		// ----------------------------
		
		// creating Customer object
		// and pointing to head of the link list
		Customer one = this.head;
		
		// updating the head and point it to the next node
		this.head = this.head.getNext();
		
		return one;
	}
	
	
	
	
	//printCustomer method
	public void printCustomers()
	{

		//--------------------------------
		// printCustimers
		//------------------------------
		

		// creating object
		Customer left_customer = removeCustomer();
		
		
		// printing Id f the customer who left
		//System.out.println("\n<<<--- Customer "+left_customer.getID()+" is left from the queue\n");
		System.out.println("\n<<<--- Customer "+left_customer.getID()+" is left from the queue\n");
		num_of_customer--;
		
		
		//calling method, this method prit details about left customer id item and cost
		print_removeCustomer(left_customer);
		
		

		// printing all information about the customer who are in the queue
	
		System.out.println("-----------------------------");
		System.out.println("** Customers in the queue: " +num_of_customer);
		System.out.println("-----------------------------\n");

		

		while (left_customer != tail)
		{
			
			
			
			left_customer = left_customer.getNext();
			
			System.out.println(left_customer.toString()+"\n");
			
			// Calculating total cost
			cost = cost + left_customer.getCost();
			
			// calculating total item
			total_item += left_customer.getItems();

		}		

	}

	
	public void print_removeCustomer(Customer obj)
	{
		//-----------------------------
		// print_removeCustomer
		//--------------------------------
		
		// printing all information  about item and cost
		System.out.println("left customer information:\n\n" +obj.toString());
		System.out.printf("\t%40s%n%n",
				"_________________________________");
		
		System.out.println();
		
		
		// Calculating total cost
		cost = cost + obj.getCost();
		
		// calculating total item
		total_item += obj.getItems();
	}
	
	
	

	// main method
	public static void main(String[] args) throws InterruptedException {
		
		
		//--------------------------------------
		// main
		//--------------------------------------
		
		
		// object of HW6 class
		HW6 queue=new HW6();
		
		
		// Creating object of Random class
		// to generate the random number of item and cost
		Random random = new Random();
		
		// application header
		System.out.println("Welcome to the Millennia Mart\n"
				+ "---------------------------------\n");
		
		
		// Declaring variable
		int i = 1;
		
		// loops will run 20 times
		while(i<=20)
		{
			
			// if the linked list is empty or 
			// random number boolean is true
			if (queue.head == null || random.nextBoolean())
			{	
				//creating Customer object and 
				//initialize it with constructor with parameter and inside parameter
				//using ranomd number to generate both the item and cost
				Customer customer_obj = new Customer(random.nextInt(40-1)+1, (double)random.nextInt(200-1)+1);
				
				
				
				// calling insertCustomer method
				queue.insertCustomer(customer_obj);
				
				
				
				// new customer will be added end of the linked list
				customer_obj= queue.tail;
				
				
				//upading the number of customer in the queue
				customer_in_queue++;
				
				
				// updating total customer
				total_customer++;
				
				
				//printing the Id of the customer who enter into the queue
				
				System.out.println("Customer " +customer_obj.getID()+" is added into the queue -->>\n");
				
				//print the # of customers in the queue
				System.out.println("------------------------------");
				System.out.println("** Customer in the queue: "+ num_of_customer);
				System.out.println("------------------------------\n");

			}
			else
			{
				
				// calling printCustomer method
				//
				
				queue.printCustomers();
				
				
				
				
				// when customer left the queue 
				//updating total # of customer in the queue
				customer_in_queue = customer_in_queue - 1;
				
				
				// updating total number of customer handled
				customer_handled++;
				
				
				//collecting how many customers are in the store
				total_customer = customer_handled + customer_in_queue;
			
				
			}
			
			//push the time for few seconds
			Thread.sleep(1000);  
			
			//updating the loop
			i++;
		}
		
		
		System.out.println("***************************** Shift is ended *****************************\n");
		
		System.out.println("Summary of information: \n------------------------------\n");
		
		// printing all the information about the customers and their purchase items and cost
		System.out.printf("%s  %10d %n%s %10d %n%s %13d %n%s %17d %n%s %,14.2f%n",
				"Customers handled:", customer_handled,  "Customers in queue:",customer_in_queue, "Total Customers:", 
				total_customer, "Total items:", total_item, "Total cost ($):", cost);
		
		// show application footer
		System.out.println("_______________________________\n\n"
				+ "\t! Have a Nice Day !");
				   
		
	}
	
	

}
