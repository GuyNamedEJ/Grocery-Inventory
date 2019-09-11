package assignment3;
/**
 * This is the protein class 
 * @author Talbot Nicklas 
 * @author Emmanuel Milord
 * @since 2019-03-12
 */

public class Protein extends FreshFood implements Stackable {
	//Private attributes
	private String type;
	private boolean prepackaged;
	boolean isStackable;
	int MaxStackCount;
	String StackDescription;
	
	//Constructor
	public Protein() {
		super();
		type = "";
		prepackaged = false;
	}
	
	/**
	 * Get the string type of protein 
	 * @return the type of protein
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the string to type, If it is one of the options and not null.
	 * @param String the type of protein
	 * @return True if is an option, False if not
	 */
	public boolean setType(String type) {
		if (type == null) {
			return false;
		}
		if (type.matches("(?i)cattle|game|fish|poultry")) {
			this.type = type;
			return true;
		}else
		return false;
		
	}
	
	/**
	 * Boolean to see if prepackaged
	 * @return True if yes, False if no
	 */
	public boolean isPrepackaged() {
		return prepackaged;
	}
	
	/**
	 * Set prepackaged to true or false
	 * @param prepackaged Boolean to set prepackaged or not
	 * @return Boolean prepackaged
	 */
	public boolean setPrepackaged(boolean prepackaged) {
		return this.prepackaged = prepackaged;
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
				"Refridgerated: " + this.refrigerated + "\n" + 
				"Type: " + this.getType() + "\n" + 
				"Prepackaged?: " + this.isPrepackaged() + "\n" + 
				"Stackable: " + this.isStackable() + "\n" +
				"Max Stack Count: " + this.getMaxStackCount() + "\n" +
				"Stack InStructions: " + this.getStackDescription();
	}

	
}
