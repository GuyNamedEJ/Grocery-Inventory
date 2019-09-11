package assignment3;

/**
 * author: EJ Milord
 */

import java.time.Duration;
import java.time.LocalDate;


public abstract class FoodItem {
	
	private String name;
	private String brand;
	private long upc;
	private String productionDate;
	private double unitWeight;
	private long age;
	
	/**
	 * FoodItem Constructor
	 * Creates a blank food item
	 */
	FoodItem()
	{
		this.name="";
		this.brand ="";
		this.productionDate = LocalDate.now().toString();
		
	}
	
	/**
	 * 
	 * @param name Name of the item
	 * @return true when set properly
	 */
	public boolean setName(String name)
	{
		if(name == null)
		{
			return false;
		}
		if(!name.matches("[A-Za-z '-]{2,50}"))
		{
			return false;
		}
		
		else
		{
			this.name = name;
			return true;
		}
		
	}
	
	/**
	 * 
	 * @return returns the name of the item
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * 
	 * @param brand Name of the Brand of the food item
	 * @return
	 */
	public boolean setBrand(String brand)
	{
		if(brand == null)
		{
			return false;
		}
		if(!brand.matches("[A-Za-z '-]{2,50}"))
		{
			return false;
		}
		
		else
		{
			this.brand = brand;
			return true;
		}
	}
	
	/**
	 * 
	 * @return Returns the brand name of the item
	 */
	public String getBrand()
	{
		return this.brand;
	}
	
	/**
	 * 
	 * @param UPC 12 digit UPC code that identifies the item
	 * @return returns true if UPC is set correctly
	 */
	
	public boolean setUpc(long UPC)
	{
		
		String code = Long.toString(UPC);
		
		if((code.length() != 12) || code.charAt(0) == '0')
		{
			return false;
		}
		
		else
		{
			this.upc = Long.parseLong(code);
			return true;
		}
	}
	/**
	 * 
	 * @returns the UPC code for the item
	 */
	public long getUpc()
	{
		return this.upc;
	}
	
	/**
	 * 
	 * @param date takes in the Date as a string in yyyy-mm-dd format
	 * @return
	 */
	public boolean setProductionDate(String date)
	{
		if(date == null)
		{
			date = "0000-00-00";
		}
		
		if(!date.matches("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$"))
		{
			return false;
		}
		
		LocalDate temp = LocalDate.parse(date);
		
		if(temp.isAfter(LocalDate.now()))
		{
			return false;
		}
		
		else
		{
			temp = LocalDate.parse(date);
			this.productionDate = temp.toString();
			return true;
		}

	}

	/**
	 * 
	 * @return returns the Production date of the object
	 */
	public String getProductionDate()
	{
		return this.productionDate;
	}
	
	/**
	 * 
	 * @param weight sets the unit weight of the item
	 * @return returns true if set correctly
	 */
	public boolean setUnitWeight(double weight)
	{
		
		
		if(weight < 0)
		{
			return false;
		}
		
		else
			{
				this.unitWeight = weight;
				return true;
			}
	}
	/**
	 * 
	 * @return Sets the Age of the item by finding the difference of the production Date from today
	 */
	public boolean setProductAge()
	{
		LocalDate date1 = LocalDate.parse(getProductionDate());
		
		this.age = Duration.between(date1.atStartOfDay(), LocalDate.now().atStartOfDay()).toDays();
		return true;
	}
	
	/**
	 * 
	 * @return returns the Age of the Object
	 */
	public long getProductAge()
	{
		LocalDate date1 = LocalDate.parse(getProductionDate());
		return Duration.between(date1.atStartOfDay(), LocalDate.now().atStartOfDay()).toDays();	
		
	}
	
	public Double getUnitWeight()
	{
		return this.unitWeight;
	}
	
	public String toString()
	{
		return "Name: " + this.name + "\n" + 
				"Brand: " + this.brand + "\n" + 
				"UPC Code: " + this.upc + "\n" + 
				"Production Date: " + this.productionDate + "\n" + 
				"Unit Weight: " + this.unitWeight + "\n" + 
				"Age: " + this.getProductAge() + " days" ;
	}
}
	
	

