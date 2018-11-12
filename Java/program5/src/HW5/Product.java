//============================================================================================
//
// Title:      Camping Critters
// Course:     CSC 3020
// Homework:   Homework 5
// Author:     Mustafa Chowdhury, ge3306
// Date:       03/31/2018
// Description:
//   This program have 2 classes (1)HW5.java and (2) Product.java
//
// In Product.java:
//					Its contain static filed, instance variable and method
//	its have total of six variable, six getters and setters method and one equal and one toSring method
// this class method used in HW5.java to set and get information about its variable
//
//=====================================================================================================

// package
package HW5;


//class Product
public class Product {
	
	// static variable for Product class
	private static int productCount = 0;
	private static double inventoryValue = 0;
	private static int inventoryCount = 0;
	
	//instance variable
	private int code;
	private String name;
	private double cost;
	private int count;
	
	//default constructor
	Product()
	{
		productCount = productCount+1;
		code = -1;
		name = "(not set)";
		cost = -1;
		count = -1;
	}
	
	// constructor with parameter
	Product(int code, String name, double cost, int count)
	{
		this.code = code;
		this.name = name;
		this.cost = cost;
		this.count = count;
		productCount = productCount+1;
		inventoryValue = inventoryValue + (cost*count);
		inventoryCount = inventoryCount + count;
	}
	
	
	
	// all set methods implemented in below:
	
	
	public static void setProductCount()
	{
		//-------------------
		// setProductCount
		//----------------------
		
		productCount++;
	}
	
	public static void setInventoryValue(double cost, int c)
	{
				//-------------------
				// setInventoryValue
				//----------------------

		// cost and count must be positive
		if (cost>=0 && c>=0)
		{
			inventoryValue = inventoryValue + (cost*c);
		}
		else
			throw new IllegalArgumentException("product count is a positive number");
	}
	
	
	
	public static void setInventoryCount(int iCount)
	{
		//-------------------
		// setInventoryCount
		//----------------------
		
		// inventory count must be positive
		if (iCount>=0)
		{
			inventoryCount = inventoryCount + iCount;
		}
		else
			throw new IllegalArgumentException("product count is a positive number");
	}
	
	public void setCode(int code)
	{
		//-------------------
		// setCode
		//----------------------
		
		// code must to be 2 digit
		if (code>=10 && code<100)
			this.code = code;
		else
			throw new IllegalArgumentException("product count is a positive number");
	}
	
	public void setName(String name)
	{
		//-------------------
		// setName
		//----------------------
		
		this.name = name;
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
	
	public void setCount(int count)
	{
		//-------------------
		// setCount
		//----------------------
		
		if (count>=0)
			this.count = count;
		else
			throw new IllegalArgumentException("product count is a positive number");
	}
	
	
	
	// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	//
	// ** all the getter methods are in below:
	
	public static int getProductCount()
	{
		return productCount;
	}
	
	public static double getInventoryValue()
	{
		return inventoryValue;
	}
	
	public static int getInventoryCount()
	{
		return inventoryCount;
	}
	
	public String getName()
	{
		return name;
	}
	
	public double getCost()
	{
		return cost;
	}
	
	public int getCode()
	{
		return code;
	}
	
	public int getCount()
	{
		return count;
	}
	
	//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	
	public boolean equals (Product obj)
    {
		// this method comparing two objects are equal or not 
        return (this.getCode() == obj.getCode());
    }
	
	
	public String toString()
	{
		// this method use to print the information about its fields
		return String.format("%s %13s %13s %13s %n%d %13s %13.2f %13d", "Code", "Name", "Cost", "Quantity",
				getCode(), getName(), getCost(), getCount());
	}
	
	 
	
}
