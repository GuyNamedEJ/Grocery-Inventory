package assignment3;


/**
 * author: EJ Milord
 */

import java.time.LocalDate;

public abstract class ProcessedFood extends FoodItem implements Stackable {

	String packaging;
	String expirationDate;
	boolean isStackable;
	int MaxStackCount;
	String StackDescription;
	
	/**
	 * Constructor that sets an empty item.
	 * Inherits FoodItem Constructor and adds expiration date and packaging
	 */
	ProcessedFood()
	{
		super();
		LocalDate date = LocalDate.parse(getProductionDate()).plusDays(5);
		this.expirationDate = date.toString();
		this.packaging = "Plastic";
	}
	
	/**
	 * 
	 * @param date Date passed in yyyy-mm-dd Formate
	 * @return returns true if date set, false if not
	 */
	public boolean setExpirationDate(String date)
	{

		if( date == "0000-00-00")
		{
			this.expirationDate = date;
			return true;
		}
		
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
		
		if((temp.isAfter(production) && temp.isAfter(production.plusYears(5)) )|| temp.isBefore(production))
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
	 * @param packaging takes Packaging option and checks if valid. 
	 * @return if valid returns true and set packaging option; if not returns false
	 */
	public boolean setPackaging(String packaging)
	{
		if (packaging == null) 
			return false;
	
		if(packaging.matches("(?i)Plastic|Metal|Paper|None")) 
		{
			this.packaging = packaging;
			return true;
		} 
		
		else
		{
			return false;
		}
			
	}
	
	/**
	 * 
	 * @return returns the packaging option
	 */
	public String getPackaging()
	{
		return this.packaging;
	}
	
	/**
	 * 
	 * @return returns the Expiration Date
	 */
	
	public String getExpirationDate()
	{
		return this.expirationDate;
	}
	
	@Override
	public boolean setStackable(boolean stack)
	{
		if(stack == true)
		{
			this.isStackable = true;
			return true;
		}
		
		else
		{
			this.isStackable = false;
			return false;
		}
	}
	
	
	@Override
	public boolean isStackable()
	{
		return this.isStackable;
	}
	
	@Override
	public boolean setMaxStackCount(int stack)
	{
		if(stack < 1)
		{
			return false;
		}
		
		else
		{
			this.MaxStackCount = stack;
			return true;
		}
	}
	
	@Override
	public int getMaxStackCount()
	{
		return this.MaxStackCount;
	}
	
	@Override
	public boolean setStackDescription(String description)
	{
		if(description == null)
		{
			return false;
		}
		
		else
		{
			this.StackDescription = description;
			
			return true;
		}
		
	}
	
	@Override 
	public String getStackDescription()
	{
		return this.StackDescription;
	}
	
	/**
	 * Returns the Object as a string 
	 */
	public String toString()
	{
		return "Name: " + this.getName() + "\n" + 
				"Brand: " + this.getBrand() + "\n" + 
				"UPC Code: " + this.getUpc() + "\n" + 
				"Production Date: " + this.getProductionDate() + "\n" + 
				"Unit Weight: " + this.getUnitWeight() + "\n" + 
				"Age: " + this.getProductAge() + " days" +"\n" + 
				"Expiration Date: " + this.getExpirationDate() + "\n" + 
				"Packaging: " + this.getPackaging();
	}
}
