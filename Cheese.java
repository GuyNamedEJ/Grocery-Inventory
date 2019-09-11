package assignment3;
/**
 * This is the Cheese class 
 * @author Talbot Nicklas 
 * @author Emmanuel Milord
 * @since 2019-03-12
 */
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Cheese extends ProcessedFood implements Stackable {
	//Private attributes
	private String milkType;
	private String origin;
	boolean isStackable;
	int MaxStackCount;
	String StackDescription;
	
	//Constructor
	public Cheese() {
		milkType = "";
		origin = "";	
	}
	
	/**
	 * Method to get the milkType
	 * @return the milkType
	 */
	public String getMilkType() {
		return milkType;
	}

	/**
	 * Method to set the milkType if, not null, and is an option
	 * @param milkType the type of milk
	 * @return True if an option, False if not
	 */
	public boolean setMilkType(String milkType) {
		if (milkType == null) 
			return false;
	
		if(milkType.matches("(?i)sheep|cow|goat|buffalo|mixed")) {
		this.milkType = milkType;
		return true;
		} return false;
	}
	
	/**
	 * Method to get the origin
	 * @return The String origin
	 */
	public String getOrigin() {
		return origin;
	}
	
	/**
	 * Method to set the origin, if it is a country in the JSON file.
	 * @param origin the country of the cheese
	 * @return True if it is a country in the JSON file, False if not
	 */
	public boolean setOrigin(String origin) {
		try {
			JSONArray a = (JSONArray) (new JSONParser()).parse(new FileReader("src/countries.json"));
			for ( Object country : a ) {
				String countryName = (String)((JSONObject)country).get("name");
				String countryCode = (String)((JSONObject)country).get("code");
				if (origin.equalsIgnoreCase(countryName)||origin.equalsIgnoreCase(countryCode)) {
				this.origin = countryName;
				return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}return false;
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
	 * Puts the attributes to string
	 */
	@Override
	public String toString()
	{
		return "Name: " + this.getName() + "\n" + 
				"Brand: " + this.getBrand() + "\n" + 
				"UPC Code: " + this.getUpc() + "\n" + 
				"Production Date: " + this.getProductionDate() + "\n" + 
				"Unit Weight: " + this.getUnitWeight() + "\n" + 
				"Age: " + this.getProductAge() + " days" + "\n" + 
				"Expiration Date: " + this.expirationDate + "\n" + 
				"Country of Origin: " + this.getOrigin() + "\n" + 
				"Milk Type: " + this.getMilkType() + "\n" +  
				"Stackable: " + this.isStackable() + "\n" +
				"Max Stack Count: " + this.getMaxStackCount() + "\n" +
				"Stack InStructions: " + this.getStackDescription();
	}
	

}
