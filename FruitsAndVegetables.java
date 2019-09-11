package assignment3;

/**
 * author: EJ Milord
 */


public class FruitsAndVegetables extends FreshFood implements Stackable
{
	String farm;
	String season;
	boolean isStackable;
	int MaxStackCount;
	String StackDescription;
	
	FruitsAndVegetables()
	{
		super();
		this.farm = "Randall Farms ";
		this.season = "Summer";
	}
	
	/**
	 * 
	 * @param farm Name of the farm
	 * @return returns true if valid; returns false if not valid
	 */
	public boolean setFarm(String farm)
	{

		if(farm == null)
		{
			return false;
		}
		if(!farm.matches("[A-Za-z '-]{2,50}"))
		{
			return false;
		}
		
		else
		{
			this.farm = farm;
			return true;
		}
	}
	
	/**
	 * 
	 * @return returns the name of the farm
	 */
	public String getFarm()
	{
		return this.farm;
	}
	
	/**
	 * 
	 * @param season Sets the season of the object
	 * @return true if valid season, false if not
	 */
	public boolean setSeason(String season)
	{
		if (season == null) 
			return false;
	
		if(season.matches("(?i)Spring|Summer|Fall|Winter|Mixed")) 
			{
				this.season = season;
				return true;
			} 
		
		else
			{
				return false;
			}
	}
	
	/**
	 * 
	 * @return Returns the season of the object
	 */
	public String getSeason()
	{
		return this.season;
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
	 * Returns the String format on a objects
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
				"Refridgerated: " + this.refrigerated + "\n" + 
				"Farm: " + this.getFarm() + "\n" + 
				"Season: " + this.getSeason() + "\n" + 
				"Stackable: " + this.isStackable() + "\n" +
				"Max Stack Count: " + this.getMaxStackCount() + "\n" +
				"Stack InStructions: " + this.getStackDescription() + "\n";
	}
}
