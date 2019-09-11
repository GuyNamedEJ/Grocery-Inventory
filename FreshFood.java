package assignment3;


/**
 * author: EJ Milord
 */

import java.time.LocalDate;


public abstract class FreshFood extends FoodItem
{
	String expirationDate;
	boolean refrigerated;
	
	FreshFood()
	{
		super();
		LocalDate date = LocalDate.parse(getProductionDate()).plusDays(5);
		this.expirationDate = date.toString();
		this.refrigerated = false;
}
	
	/**
	 * 
	 * @param date Date is a passed in value that is the expiration date in yyyy-mm-dd format
	 * @return returns true if valid; false if not valid
	 */
	public boolean setExpirationDate(String date)
	{	
		
		if( date == null)
		{
			return false;
		}
		
		if(!date.matches("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$"))
		{
			return false;
		}
		
		LocalDate temp = LocalDate.parse(date);
		LocalDate production = LocalDate.parse(getProductionDate());
		
		if((temp.isAfter(production) && temp.isAfter(production.plusDays(30)) )|| temp.isBefore(production))
		{
			return false;
		}
		
		else 
		{
			this.expirationDate = temp.toString();
			return true;
		}
	}
	
	/**
	 * 
	 * @return Returns the expiration date of the item
	 */
	public String getExpirationDate()
	{
		return this.expirationDate;
	}
	
	/**
	 * 
	 * @param value The boolean value of whether or not the item is refrigerated
	 * @return returns true if refrigerated; false if not
	 */
	public boolean setRefrigerated(boolean value)
	{
		if(value == true)
			this.refrigerated = true;
		else
			this.refrigerated = false;
		
		return refrigerated;
	}
	
	/**
	 * 
	 * @return returns the value of refrigerated 
	 */
	public boolean isRefrigerated()
	{
		return this.refrigerated;
	}
	
	/**
	 * Returns the String format of the object
	 */
	public String toString()
	{
		return "Name: " + this.getName() + "\n" + 
				"Brand: " + this.getBrand() + "\n" + 
				"UPC Code: " + this.getUpc() + "\n" + 
				"Production Date: " + this.getProductionDate() + "\n" + 
				"Unit Weight: " + this.getUnitWeight() + "\n" + 
				"Age: " + this.getProductAge() + " days" + "\n" + 
				"Expiration Date: " + this.expirationDate + "\n" + 
				"Refridgerated: " + this.refrigerated;
	}

}
