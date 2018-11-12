
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
// In Customer.java:  
//		Each object created from this class represents one customer and includes the following fields and methods:
//	Fields
//		(static) totalCustomers – count of all distinct customers; initialize to 0 in declaration.
//		(static) totalItems – total items purchased by all customers; initialize to 0 in declaration.
//		(static) totalCost – total cost of all items purchased by all customers; initialize to 0 in declaration.
//		ID – unique number assigned to each customer.
//		items – number of items in customer shopping cart.
//		cost – cost of all items in customer shopping cart.
//		next – pointer to next customer.
//   Have six setter and getter functions for each of the fields
// 	Have one isEqual and toString method
//
//==========================================================================================================================

// package HW6
package HW6;


//=========================
// Class Customer
//==========================

public class Customer {

	// instance variable
	// static variable for Product class
		private static int totalCustomers = 0;
		private static int totalItems = 0;
		private static double totalCost = 0;
		
		//instance variable
		private int ID;
		private int items;
		private double cost;
		private Customer next;
		
		
		//default constructor
		Customer()
		{
			totalCustomers = totalCustomers+1;
			ID = -1;
			items = -1;
			cost = -1;
			next = null;
		}
		
		// constructor with parameter
		Customer(int items, double cost)
		{
			
			
			totalCustomers = totalCustomers + 1;
			totalItems = totalItems + items;
			totalCost = totalCost + cost;
			this.ID = totalCustomers;
			this.items = items;
			this.cost = cost;
			
			next = null;

		}
		
		
		
		// all set methods implemented in below:
		
		
		public static void set_totalCustomers()
		{
			//-------------------
			// set_totalCustomers
			//----------------------
			
			totalCustomers++;
		}
		
		public static void set_totalItems(int i)
		{
					//-------------------
					// set_totalItems
					//----------------------

			// item must be positive
			if (i>0)
			{
				totalItems = totalItems + i;
			}
			else
				throw new IllegalArgumentException("product count is a positive number");
		}
		
		
		
		public static void set_totalCost(double c)
		{
			//-------------------
			// set_totalCost
			//----------------------
			
			// cost must be positive
			if (c>0)
			{
				totalCost = totalCost + c;
			}
			else
				throw new IllegalArgumentException("product count is a positive number");
		}
		
		public void setID(int id)
		{
			//-------------------
			// setID
			//----------------------
			
			// id must to be 2 digit
			if (id > 0)
				ID = id;
			else
				throw new IllegalArgumentException("product count is a positive number");
		}
		
	
		
		public void setCost (double cost)
		{
			//-------------------
			// setCost
			//----------------------
			
			if (cost>0)
				this.cost = cost;
			else
				throw new IllegalArgumentException("product count is a positive number");
		}
		
		public void setItems(int items)
		{
			//-------------------
			// setItems
			//----------------------
			
			if (items>=0)
				this.items = items;
			else
				throw new IllegalArgumentException("product count is a positive number");
		}
		
		
		public void setNext(Customer next)
		{
			// -----------------
			// setNext
			// ----------------
			this.next = next;
		}
		
		
		// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
		//
		// ** all the getter methods are in below:
		
		public static int get_totalCustomer()
		{
			return totalCustomers;
		}
		
		
		public static double get_totalCost()
		{
			return totalCost;
		}
		
		public static int get_totalItems()
		{
			return totalItems;
		}
		
		
		public int getID()
		{
			return ID;
		}
		
		public int getItems()
		{
			return items;
		}
		
		public double getCost()
		{
			return cost;
		}
		
		public Customer getNext()
		{
			return next;
		}
		
		//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
		
		// equals
		public boolean equals (Customer obj)
	    {
			// this method comparing two objects are equal or not 
	        return (this.getID() == obj.getID());
	    }
		
		// toString
		public String toString()
		{
			// this method use to print the information about its fields
			return String.format("%18s %13s %13s %n%18d %13d %13.2f", "ID", "Items", "Cost ($)", 
					getID(), getItems(), getCost());
		}
		
	
	
}
