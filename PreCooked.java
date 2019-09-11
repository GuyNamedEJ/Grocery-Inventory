package assignment3;
/**
 * This is the PreCooked class 
 * @author Talbot Nicklas 
 * @author Emmanuel Milord
 * @since 2019-03-12
 */
import java.util.Arrays;

public class PreCooked extends ProcessedFood implements Stackable {
	//Private attributes
	private boolean frozen;
	private String[] ingredients = {"","",""};
	boolean isStackable;
	int MaxStackCount;
	String StackDescription;
	
	//Constructor
	public PreCooked() {
		super();
		frozen = false;
	}
	
	/**
	 * Method to see if it is frozen or not
	 * @return True if frozen, false if not
	 */
	public boolean isFrozen() {
		return frozen;
	}

	/**
	 * Method to set if frozen or not
	 * @param frozen boolean to if frozen
	 * @return True if frozen, False if not
	 */
	public boolean setFrozen(boolean frozen) {
		return this.frozen = frozen;
	}

	/**
	 * Method to get the array of ingredients
	 * @return The array of ingredients
	 */
	public String[] getIngredients() {
		return ingredients;
	}
	
	/**
	 * Method to set the array of ingredients, array cannot be empty, null, or have a null entry. 
	 * Each   can   contain   upper-case   and   lower-case   letters,dashes, apostrophes, and spaces. Min 2 characters, max 50 characters
	 * @param ingredients the array of ingredients
	 * @return True if it meets all validation, false if not
	 */
	public boolean setIngredients(String[] ingredients) {
		if (ingredients == null || ingredients.length==0)
			return false;
		
		for (int x = 0; x < ingredients.length; x++) {
			if (ingredients[x] == null) 
				return false;
		}
		
		int i = 0;
		String s1 = ingredients[i];
		String s2 = ingredients[i+1];
		String s3 = ingredients[i+2];
			
		if (s1.matches("[A-Za-z '-]{2,50}") && s2.matches("[A-Za-z '-]{2,50}") && s3.matches("[A-Za-z '-]{2,50}")) {
			this.ingredients = ingredients;
			return true;
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
	 *Puts the attributes to string
	 */
	@Override
	public String toString() {
		return "Precooked [frozen=" + frozen + ", ingredients=" + Arrays.toString(ingredients) + "]";
	}

}
