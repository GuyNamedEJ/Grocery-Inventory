package assignment3;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;



/**
 * This project makes the user enter the products attributes. The main method asks the users about
 * the info, and sets users input as the private variables found in the other classes (If it meets the validation requirements for each attribute). 
 * @author Talbot Nicklas
 * @author EJ Milord
 * @since 2019-04-09
 * 
 */

public class assignment4 {
	
/**
 * Main Method that calls everything
 * @param args
 * @throws ParseException 
 */
	
	
	/*
	 *UPC and weight have Error handling to ensure characters are used
	 *Only numbers 
	 */

	public static void main(String[] args) throws ParseException {
		//Creates scanner object 
		Scanner userInput = new Scanner (System.in);
			
		boolean keepLooping = true;

		FoodItem[] food = new FoodItem[5];
		for ( int i = 0; i < food.length; i++ ) {
			food[i] = new Cheese();
		}
		
			
		int elementsCount = 0;
			
		while(keepLooping) {
			// Create
			System.out.println("1) Create");
			// Display
			System.out.println("2) Display");
			// Edit
			System.out.println("3) Edit");
			// Exit
			System.out.println("0) Exit");				
			// Collecting the user's input
			System.out.print("\nChoice: ");			
			int choice;
			
				try {
					choice = Integer.parseInt(userInput.nextLine());
				} catch (NumberFormatException nfe) {
					System.out.println("Please enter a number1");
					choice = -1;
				}
				
				switch(choice) {
				case 1: // Create
					boolean success = createEntry(food, elementsCount, userInput);
					if ( success )
						elementsCount++;
					break;
				case 2: // Display
					for ( int i = 0; i < elementsCount; i++ )
						System.out.println(i +")\n " + food[i]);
					System.out.println("\n");
					break;
				case 3: // Edit
					editEntry(food, elementsCount, userInput);
					break;
				case 0: // Exit
					System.out.println("Thank you");
					keepLooping = false;
					break;
				default: // Invalid input
					System.out.println("Invalid input, try again");
					choice = -1;
				}	
			}
			userInput.close();
	}
	
	private static void editEntry(FoodItem[] food, int elementsCount, Scanner userInput) 
	{
		
		for ( int i = 0; i < elementsCount; i++ )
			System.out.println(i + ")\n" + food[i]);
	
		System.out.println("Enter the index of the item you want to edit");
		int choice;
		
		/*
		 * Catch blocks are on line 668
		 * Try/Catch had cover the entire block of code to check if the 
		 * integer selected was in the array
		 * Moved the assignment of Choice into the try/catch block
		 * 
		 */
			try {
				choice = Integer.parseInt(userInput.nextLine());
			if (food[choice] instanceof FruitsAndVegetables) {
				FruitsAndVegetables	f = (FruitsAndVegetables) Array.get(food, choice);
			
				System.out.println("Enter the Number of what you want to Edit :\n1) Name: " + f.getName() 
				+ "\n2)Brand: " + f.getBrand() + "\n3)UPC: " + f.getUpc() + "\n4)Production date: " + f.getProductionDate()
				+ "\n5)Unit weight: " + f.getUnitWeight() + "\n6)Expiration Date: " + f.getExpirationDate() + "\n7)Refrigerated: 6" + f.isRefrigerated()
				+ "\n8)Farm: " + f.getFarm() + "\n9)Season: " + f.getSeason());
					
					int edit;			
					try {
						edit = Integer.parseInt(userInput.nextLine());
					} catch (NumberFormatException nfe) {
						System.out.println("Please enter a number3");
						edit = -2;
					}
				
				switch(edit) {
				case 1: //name
					boolean inputOK = false;
					while(!inputOK) {
						System.out.print("Enter the products New Name: ");
						String name = userInput.nextLine();
						inputOK = f.setName(name);
					}
					break;
				case 2: //brand
					inputOK = false;
					while(!inputOK) {
						System.out.print("Enter the products Brand: ");
						String brand = userInput.nextLine();
						inputOK = f.setBrand(brand);
					}
					break;
				case 3:	//upc
					inputOK = false;
					while (!inputOK) {
						System.out.println("Enter the products UPC (12 digits): ");
						try {
							long upc = Long.parseLong(userInput.nextLine());
							inputOK = f.setUpc(upc);
						} catch(InputMismatchException e)
						{
							System.out.println("UPC Must Be Integers Only");
							inputOK = false;
						}
					}
					break;
				case 4://production date
					inputOK = false; 
					while (!inputOK){
					System.out.println("Enter the Production Date(yyyy-MM-dd)" );
					String prodDate = userInput.nextLine();
					f.setProductionDate(prodDate);
					inputOK = f.setProductionDate(prodDate);
					}
					break;
				case 5://weight
					inputOK = false;
					while(!inputOK) {
					System.out.println("Enter the products Weight in Pounds: ");
					try {
						double weight = Double.parseDouble(userInput.nextLine());
						inputOK = f.setUnitWeight(weight);
					} catch(NumberFormatException e)
					{
						System.out.println("Weight Must Be Integers Only");
						inputOK = false;
					}
					}
					break;
				case 6://Expiration date
					inputOK= false;
					while(!inputOK){
						System.out.println("What is the Expiration Date? (yyyy-MM-dd) ");
						String date = userInput.nextLine();
						inputOK = f.setExpirationDate(date);
					}
					break;
				case 7://refigerated
					inputOK= false;
					while(!inputOK){
						System.out.println("Is it Refrigerated? ");
						String date = userInput.nextLine();
						if (date.replace(" ", "").equalsIgnoreCase("yes")) {
							inputOK = f.setRefrigerated(true);
						}else {
							f.setRefrigerated(false);
							inputOK = true;
						}
					}
					break;
				case 8: 
					inputOK= false;
					while(!inputOK){
						System.out.println("From What Farm");
						String type = userInput.nextLine();
						inputOK = f.setFarm(type);
					}
					break;
				case 9:
					inputOK = false;
					while (!inputOK) {
						System.out.println("What Season? (Summer, Fall, Winter, Spring)");
						String season = userInput.nextLine();
						inputOK = f.setSeason(season);
					}
					break;
				default: // Invalid input
					System.out.println("Invalid input, try again");
					editEntry(food,elementsCount, userInput);
					
					
				}
				f.setProductAge();
				f.getProductAge();				
				System.out.println(f);
				
			} 
		else if(food[choice] instanceof Protein) {
			Protein	f = (Protein) Array.get(food, choice);
			
			System.out.println("Enter the Number of what you want to Edit :\n1) Name: " + f.getName() 
			+ "\n2)Brand: " + f.getBrand() + "\n3)UPC: " + f.getUpc() + "\n4)Production date: " + f.getProductionDate()
			+ "\n5)Unit weight: " + f.getUnitWeight() + "\n6)Expiration Date: " + f.getExpirationDate() + "\n7)Refrigerated" + f.isRefrigerated()
			+ "\n9)Type: " + f.getType() + "\n10)Stackable/Stack Amount/DescriptioStackable" + f.isStackable());
			
			int edit;			
			try {
				edit = Integer.parseInt(userInput.nextLine());
			} catch (NumberFormatException nfe) {
				System.out.println("Please enter a number4");
				edit = -1;
			}
			
			switch(edit) {
			case 1: //name
				boolean inputOK = false;
				while(!inputOK) {
					System.out.print("Enter the products New Name: ");
					String name = userInput.nextLine();
					inputOK = f.setName(name);
				}
				break;
			case 2: //brand
				inputOK = false;
				while(!inputOK) {
					System.out.print("Enter the products Brand: ");
					String brand = userInput.nextLine();
					inputOK = f.setBrand(brand);
				}
				break;
			case 3:	//upc
				inputOK = false;
				while (!inputOK) {
					System.out.println("Enter the products UPC (12 digits): ");
					try {
						long upc = Long.parseLong(userInput.nextLine());
						inputOK = f.setUpc(upc);
					} catch(InputMismatchException e)
					{
						System.out.println("UPC Must Be Integers Only");
						inputOK = false;
					}
				}
				break;
			case 4://production date
				inputOK = false; 
				while (!inputOK){
					System.out.println("Enter the Production Date(yyyy-MM-dd)" );
					String prodDate = userInput.nextLine();
					f.setProductionDate(prodDate);
					inputOK = f.setProductionDate(prodDate);
				}
				break;
			case 5://weight
				inputOK = false;
				while(!inputOK) {
					System.out.println("Enter the products Weight in Pounds: ");
					try {
						double weight = Double.parseDouble(userInput.nextLine());
						inputOK = f.setUnitWeight(weight);
					} catch(NumberFormatException e)
					{
						System.out.println("Weight Must Be Integers Only");
						inputOK = false;
					}
				}
				break;
			case 6://Expiration date
				inputOK= false;
				while(!inputOK){
					System.out.println("What is the Expiration Date? (yyyy-MM-dd) ");
					String date = userInput.nextLine();
					inputOK = f.setExpirationDate(date);
				}
				break;
			case 7:// 
				inputOK= false;
				while(!inputOK){
					System.out.println("Is it Refrigerated? ");
					String date = userInput.nextLine();
					if (date.replace(" ", "").equalsIgnoreCase("yes")) {
						inputOK = f.setRefrigerated(true);
					}else {
						f.setRefrigerated(false);
						inputOK = true;
					}
				}
				break;
			case 8:
				inputOK= false;
				while(!inputOK){
					System.out.println("What Type? (Fish, Cattle, Game, Poultry)");
					String type = userInput.nextLine();
					inputOK = f.setType(type);
				}
				inputOK= false;
				while (!inputOK) {
					System.out.println("Is it Prepackaged");
					String pre = userInput.nextLine();
					if (pre.replace(" ", "").equalsIgnoreCase("yes") ){
						inputOK = f.setPrepackaged(true);
					}else {
						f.setPrepackaged(false);
						inputOK = true;
					}
				}
				break;
			case 9:
				inputOK= false;
				while (!inputOK) {
					System.out.println("Is it Prepackaged");
					String pre = userInput.nextLine();
					if (pre.replace(" ", "").equalsIgnoreCase("yes") ){
						inputOK = f.setPrepackaged(true);
					}else {
						f.setPrepackaged(false);
						inputOK = true;
					}
				}
				break;
			case 10:	
				inputOK= false;
			while (!inputOK) {
					System.out.println("Is it Stackable");
					String pack = userInput.nextLine();
					if (pack.replace(" ", "").equalsIgnoreCase("yes") ){
						inputOK = f.setStackable(true);
						boolean inputOK1= false;
						while(!inputOK1){
							System.out.println("What is the max stack amount? (must be greater than 1)");
							int amount = userInput.nextInt();
							inputOK1 = f.setMaxStackCount(amount);
						}
						inputOK1= false;
						while(!inputOK1){
							System.out.println("How do you stack it?");
							String des = userInput.nextLine();
							inputOK1 = f.setStackDescription(des);
						}
					}else {
						f.setStackable(false);
						inputOK = true;
					} 
					if (f.setStackable(false)) {
						f.setMaxStackCount(0);
						f.setStackDescription("");
					}
				}
				break;
			default: // Invalid input
				System.out.println("Invalid input, try again");
				editEntry(food,elementsCount, userInput);
				
			}
			f.setProductAge();
			f.getProductAge();				
			System.out.println(f);
			} 
		else if(food[choice] instanceof Cheese) {
				
			Cheese	f = (Cheese) Array.get(food, choice);
			System.out.println("Enter the Number of what you want to Edit :\n1) Name: " + f.getName() 
			+ "\n2)Brand: " + f.getBrand() + "\n3)UPC: " + f.getUpc() + "\n4)Production date: " + f.getProductionDate()
			+ "\n5)Unit weight: " + f.getUnitWeight() + "\n6)Expiration Date: " + f.getExpirationDate() +"\n7)Packaging" + f.getPackaging() 
			+ "\n8)Milk Type: " + f.getMilkType()+ "\n9)Origin: " + f.getOrigin() + "\n10)Stackable/Stack Amount/Description: " + f.isStackable());
			
			int edit;			
			try {
				edit = Integer.parseInt(userInput.nextLine());
			} catch (NumberFormatException nfe) {
				System.out.println("Please enter a number7");
				edit = -1;
			}
			
			switch(edit) {
			case 1: //name
				boolean inputOK = false;
				while(!inputOK) {
					System.out.print("Enter the products New Name: ");
					String name = userInput.nextLine();
					inputOK = f.setName(name);
				}
				break;
			case 2: //brand
				inputOK = false;
				while(!inputOK) {
					System.out.print("Enter the products Brand: ");
					String brand = userInput.nextLine();
					inputOK = f.setBrand(brand);
				}
				break;
			case 3:	//upc
				inputOK = false;
				while (!inputOK) {
					System.out.println("Enter the products UPC (12 digits): ");
					try {
						long upc = Long.parseLong(userInput.nextLine());
						inputOK = f.setUpc(upc);
					} catch(InputMismatchException e)
					{
						System.out.println("UPC Must Be Integers Only");
						inputOK = false;
					}
				}
				break;
			case 4://production date
				inputOK = false; 
				while (!inputOK){
				System.out.println("Enter the Production Date(yyyy-MM-dd)" );
				String prodDate = userInput.nextLine();
				f.setProductionDate(prodDate);
				inputOK = f.setProductionDate(prodDate);
				}
				break;
			case 5://weight
				inputOK = false;
				while(!inputOK) {
				System.out.println("Enter the products Weight in Pounds: ");
				try {
					double weight = Double.parseDouble(userInput.nextLine());
					inputOK = f.setUnitWeight(weight);
				} catch(NumberFormatException e)
				{
					System.out.println("Weight Must Be Integers Only");
					inputOK = false;
				}
				}
				break;
			case 6://Expiration date
				inputOK= false;
				while(!inputOK){
					System.out.println("What is the Expiration Date? (yyyy-MM-dd) ");
					String date = userInput.nextLine();
					inputOK = f.setExpirationDate(date);
				}
				break;
			case 7:
				inputOK= false;
				while(!inputOK){
					System.out.println("What is the packaging (Plastic, Metal, Paper, None) ");
					String pack = userInput.nextLine();
					inputOK = f.setPackaging(pack);
				}
				break;
			case 8:
				inputOK = false;
				while(!inputOK){
					System.out.println("From What Milk Type: (Cow, Sheep, Goat, Buffalo, Mixed)");
					String type = userInput.nextLine();
					inputOK = f.setMilkType(type);
				}
				break;
			case 9:
				inputOK= false;
				while(!inputOK){
					System.out.println("From What Country");
					String count = userInput.nextLine();
					inputOK = f.setOrigin(count);
					}
				break;
			case 10:
				inputOK= false;
				while (!inputOK) {
					System.out.println("Is it Stackable");
					String pack = userInput.nextLine();
					if (pack.replace(" ", "").equalsIgnoreCase("yes") ){
						inputOK = f.setStackable(true);
						boolean inputOK1= false;
						while(!inputOK1){
							System.out.println("What is the max stack amount? (must be greater than 1)");
							int amount = userInput.nextInt();
							inputOK1 = f.setMaxStackCount(amount);
						}
						inputOK1= false;
						while(!inputOK1){
							System.out.println("How do you stack it?");
							String des = userInput.nextLine();
							inputOK1 = f.setStackDescription(des);
						}
					}else {
						f.setStackable(false);
						inputOK = true;
					}
					if (f.setStackable(false)) {
						f.setMaxStackCount(0);
						f.setStackDescription("");
					}
				}
				break;
			default: // Invalid input
			System.out.println("Invalid input, try again");
			editEntry(food,elementsCount, userInput);
			}
			f.setProductAge();
			f.getProductAge();
			System.out.println(f);
			
			}
		else if (food[choice] instanceof PreCooked) {
			PreCooked	f = (PreCooked) Array.get(food, choice);
			System.out.println("Enter the Number of what you want to Edit :\n1) Name: " + f.getName() 
			+ "\n2)Brand: " + f.getBrand() + "\n3)UPC: " + f.getUpc() + "\n4)Production date: " + f.getProductionDate()
			+ "\n5)Unit weight: " + f.getUnitWeight() + "\n6)Expiration Date: " + f.getExpirationDate() +"\n7)Packaging: " + f.getPackaging() 
			+ "\n8)Frozen: " + f.isFrozen() + "\n9)Ingredients: " + f.getIngredients() + "\n10)Stackable/Stack Amount/DescriptioStackable: " + f.isStackable());
			
			int edit;			
			try {
				edit = Integer.parseInt(userInput.nextLine());
			} catch (NumberFormatException nfe) {
				System.out.println("Please enter a number5");
				edit = -1;
			}
			
			switch(edit) {
			case 1: //name
				boolean inputOK = false;
				while(!inputOK) {
					System.out.print("Enter the products New Name: ");
					String name = userInput.nextLine();
					inputOK = f.setName(name);
				}
				break;
			case 2: //brand
				inputOK = false;
				while(!inputOK) {
					System.out.print("Enter the products Brand: ");
					String brand = userInput.nextLine();
					inputOK = f.setBrand(brand);
				}
				break;
			case 3:	//upc
				inputOK = false;
				while (!inputOK) {
					System.out.println("Enter the products UPC (12 digits): ");
					try {
						long upc = Long.parseLong(userInput.nextLine());
						inputOK = f.setUpc(upc);
					} catch(InputMismatchException e)
					{
						System.out.println("UPC Must Be Integers Only");
						inputOK = false;
					}
				}
				break;
			case 4://production date
				inputOK = false; 
				while (!inputOK){
				System.out.println("Enter the Production Date(yyyy-MM-dd)" );
				String prodDate = userInput.nextLine();
				f.setProductionDate(prodDate);
				inputOK = f.setProductionDate(prodDate);
				}
				break;
			case 5://weight
				inputOK = false;
				while(!inputOK) {
				System.out.println("Enter the products Weight in Pounds: ");
				try {
					double weight = Double.parseDouble(userInput.nextLine());
					inputOK = f.setUnitWeight(weight);
				} catch(NumberFormatException e)
				{
					System.out.println("Weight Must Be Integers Only");
					inputOK = false;
				}
				}
				break;
			case 6://Expiration date
				inputOK= false;
				while(!inputOK){
					System.out.println("What is the Expiration Date? (yyyy-MM-dd) ");
					String date = userInput.nextLine();
					inputOK = f.setExpirationDate(date);
				}
				break;
			case 7:
				inputOK= false;
				while(!inputOK){
					System.out.println("What is the packaging (Plastic, Metal, Paper, None) ");
					String pack = userInput.nextLine();
					inputOK = f.setPackaging(pack);
				}
				break;
			case 8:
				inputOK = false;
				while(!inputOK){
					System.out.println("Is it Frozen? ");
					String froz = userInput.nextLine();
					if (froz.replace(" ", "").equalsIgnoreCase("yes") ){
						inputOK = f.setFrozen(true);
					}else { 
						f.setFrozen(false);
						inputOK = true;
					}
				}
				
				break;
			case 9:
				inputOK = false;
				while(!inputOK){
					String[] arrayOfIn = new String [3];
					for (int i = 0; i < arrayOfIn.length; i++) {
						System.out.println("List Three Indredients(One at a Time): ");
						arrayOfIn[i] = userInput.nextLine();
						}
					
					inputOK = f.setIngredients(arrayOfIn);	
				}
				
				break;
			case 10:
				inputOK= false;
				while (!inputOK) {
					System.out.println("Is it Stackable");
					String pack = userInput.nextLine();
					if (pack.replace(" ", "").equalsIgnoreCase("yes") ){
						inputOK = f.setStackable(true);
						boolean inputOK1= false;
						while(!inputOK1){
							System.out.println("What is the max stack amount? (must be greater than 1)");
							int amount = userInput.nextInt();
							inputOK1 = f.setMaxStackCount(amount);
						}
						inputOK1= false;
						while(!inputOK1){
							System.out.println("How do you stack it?");
							String des = userInput.nextLine();
							inputOK1 = f.setStackDescription(des);
						}
					}else {
						f.setStackable(false);
						inputOK = true;
					}
					if (f.setStackable(false)) {
						f.setMaxStackCount(0);
						f.setStackDescription("");
					}
				}
				break;
			default: // Invalid input
				System.out.println("Invalid input, try again");
				editEntry(food,elementsCount, userInput);
			}
			f.setProductAge();
			f.getProductAge();
			System.out.println(f);
				
		}
			}catch(ArrayIndexOutOfBoundsException e)
			{
				System.out.println("Invalid Choice: Array Contains a Max of 5 items");
			}
			
			catch(NumberFormatException e)
			{
				System.out.println("Invalid Entry: Please select an Integer ");
			}
}

	private static boolean createEntry(FoodItem[] food, int elementsCount, Scanner userInput) {
		// Asks the user for the type of food
		System.out.println("Choose the type of object you would like to store:");
		System.out.println("1) FruitsAndVegetables\n2) Protein\n3) Cheese");
		System.out.print("4) Precooked\nChoice: ");
			
		int choice;
		try {
			choice = Integer.parseInt(userInput.nextLine());
		} catch (NumberFormatException nfe) {
			System.out.println("Please enter a number6");
			choice = -1;
		}
		
					
			switch(choice) {
			case 1: //FruitsAndVegetables
				boolean success = createFruitsAndVegetables(food, elementsCount, userInput);
				return success;
			case 2: //Protein
				success = createProtein(food, elementsCount,userInput);
				return success;
			case 3: //Cheese
				success = createCheese(food, elementsCount,userInput);
				return success;
			case 4: // Precooked
				success = createPrecooked(food, elementsCount,userInput);
				return success;
			default:
				System.out.println("Please enter a number8");
				choice = -1;
			}
		
		return false;
}

	/**
	 * method that creates FruitsAndVegetables
	 * @param userInput 
	 * @return 
	 */
	public static boolean createFruitsAndVegetables(FoodItem[] food, int elementsCount, Scanner userInput) {
		FruitsAndVegetables f = new FruitsAndVegetables();
		
		boolean inputOK = false;
		while(!inputOK) {
			System.out.print("Enter the products Name: ");
			String name = userInput.nextLine();
			inputOK = f.setName(name);
		}
		
		inputOK = false;
		while(!inputOK) {
			System.out.print("Enter the products Brand: ");
			String brand = userInput.nextLine();
			inputOK = f.setBrand(brand);
		}
		
		inputOK = false;
		while (!inputOK) {
			System.out.println("Enter the products UPC (12 digits): ");
			try {
				long upc = Long.parseLong(userInput.nextLine());
				inputOK = f.setUpc(upc);
			} catch(NumberFormatException e)
			{
				System.out.println("UPC Must Be Integers Only");
				inputOK = false;
			}
		}
	
		inputOK = false; 
		while (!inputOK){
		System.out.println("Enter the Production Date(yyyy-MM-dd)" );
		String prodDate = userInput.nextLine();
		f.setProductionDate(prodDate);
		inputOK = f.setProductionDate(prodDate);
		}
		
		inputOK = false;
		while(!inputOK) {
		System.out.println("Enter the products Weight in Pounds: ");
		try {
			double weight = Double.parseDouble(userInput.nextLine());
			inputOK = f.setUnitWeight(weight);
		} catch(NumberFormatException e)
		{
			System.out.println("Weight Must Be Integers Only");
			inputOK = false;
		}
	
		}
		inputOK= false;
		while(!inputOK){
			System.out.println("What is the Expiration Date? (yyyy-MM-dd) ");
			String date = userInput.nextLine();
			inputOK = f.setExpirationDate(date);
		}
		
		inputOK= false;
		while(!inputOK){
			System.out.println("Is it Refrigerated? ");
			String date = userInput.nextLine();
			if (date.replace(" ", "").equalsIgnoreCase("yes")) {
				inputOK = f.setRefrigerated(true);
			}else {
				f.setRefrigerated(false);
				inputOK = true;
			}
		}
		inputOK= false;
		while(!inputOK){
			System.out.println("From What Farm");
			String type = userInput.nextLine();
			inputOK = f.setFarm(type);
		}
		inputOK = false;
		while (!inputOK) {
			System.out.println("What Season? (Summer, Fall, Winter, Spring)");
			String season = userInput.nextLine();
			inputOK = f.setSeason(season);
		}
	
		
		
		f.setProductAge();
		f.getProductAge();
		food[elementsCount] = f;
		return true;
		}
	
	/**
	 * method that makes the protein
	 * @return 
	 */
	public static boolean createProtein(FoodItem[] food, int elementsCount,Scanner userInput){
		Protein f = new Protein();
		
		boolean inputOK = false;
		while(!inputOK) {
			System.out.print("Enter the products Name: ");
			String name = userInput.nextLine();
			inputOK = f.setName(name);
		}
		
		inputOK = false;
		while(!inputOK) {
			System.out.print("Enter the products Brand: ");
			String brand = userInput.nextLine();
			inputOK = f.setBrand(brand);
		}
		
		inputOK = false;
		while (!inputOK) {
			System.out.println("Enter the products UPC (12 digits): ");
			try {
				long upc = Long.parseLong(userInput.nextLine());
				inputOK = f.setUpc(upc);
			} catch(NumberFormatException e)
			{
				System.out.println("UPC Must Be Integers Only");
				inputOK = false;
			}
		}
	
		inputOK = false; 
		while (!inputOK){
		System.out.println("Enter the Production Date(yyyy-MM-dd)" );
		String prodDate = userInput.nextLine();
		f.setProductionDate(prodDate);
		inputOK = f.setProductionDate(prodDate);
		}
		
		inputOK = false;
		while(!inputOK) {
		System.out.println("Enter the products Weight in Pounds: ");
		try {
			double weight = Double.parseDouble(userInput.nextLine());
			inputOK = f.setUnitWeight(weight);
		} catch(NumberFormatException e)
		{
			System.out.println("Weight Must Be Integers Only");
			inputOK = false;
		}
		}
		inputOK= false;
		while(!inputOK){
			System.out.println("What is the Expiration Date? (yyyy-MM-dd) ");
			String date = userInput.nextLine();
			inputOK = f.setExpirationDate(date);
		}
		
		inputOK= false;
		while(!inputOK){
			System.out.println("Is it Refrigerated? ");
			String date = userInput.nextLine();
			if (date.replace(" ", "").equalsIgnoreCase("yes")) {
				inputOK = f.setRefrigerated(true);
			}else {
				f.setRefrigerated(false);
				inputOK = true;
			}
		}
		inputOK= false;
		while(!inputOK){
			System.out.println("What Type? (Fish, Cattle, Game, Poultry)");
			String type = userInput.nextLine();
			inputOK = f.setType(type);
		}
		inputOK= false;
		while (!inputOK) {
			System.out.println("Is it Prepackaged");
			String pre = userInput.nextLine();
			if (pre.replace(" ", "").equalsIgnoreCase("yes") ){
				inputOK = f.setPrepackaged(true);
			}else {
				f.setPrepackaged(false);
				inputOK = true;
			}
		}
		
		inputOK= false;
		while (!inputOK) {
			System.out.println("Is it Stackable");
			String pack = userInput.nextLine();
			if (pack.replace(" ", "").equalsIgnoreCase("yes") ){
				inputOK = f.setStackable(true);
				boolean inputOK1= false;
				while(!inputOK1){
					System.out.println("What is the max stack amount? (must be greater than 1)");
					int amount = userInput.nextInt();
					inputOK1 = f.setMaxStackCount(amount);
				}
				inputOK1= false;
				while(!inputOK1){
					System.out.println("How do you stack it?");
					String des = userInput.nextLine();
					inputOK1 = f.setStackDescription(des);
				}
			}else {
				f.setStackable(false);
				inputOK = true;
			}
		}
		
		f.setProductAge();
		f.getProductAge();
		food[elementsCount] = f;
		return true;
		
	
		
	}
	
	/**
	 * method that creates cheese
	 * @return 
	 */
	public static boolean createCheese(FoodItem[] food, int elementsCount,Scanner userInput) {
		Cheese f = new Cheese();
		
		boolean inputOK = false;
		while(!inputOK) {
			System.out.print("Enter the products Name: ");
			String name = userInput.nextLine();
			inputOK = f.setName(name);
		}
		
		inputOK = false;
		while(!inputOK) {
			System.out.print("Enter the products Brand: ");
			String brand = userInput.nextLine();
			inputOK = f.setBrand(brand);
		}
		
		inputOK = false;
		while (!inputOK) {
			System.out.println("Enter the products UPC (12 digits): ");
			try {
				long upc = Long.parseLong(userInput.nextLine());
				inputOK = f.setUpc(upc);
			} catch(NumberFormatException e)
			{
				System.out.println("UPC Must Be Integers Only");
				inputOK = false;
			}
		}
	
		inputOK = false; 
		while (!inputOK){
		System.out.println("Enter the Production Date(yyyy-MM-dd)" );
		String prodDate = userInput.nextLine();
		f.setProductionDate(prodDate);
		inputOK = f.setProductionDate(prodDate);
		}
		
		inputOK = false;
		while(!inputOK) {
		System.out.println("Enter the products Weight in Pounds: ");
		try {
			double weight = Double.parseDouble(userInput.nextLine());
			inputOK = f.setUnitWeight(weight);
		} catch(NumberFormatException e)
		{
			System.out.println("Weight Must Be Integers Only");
			inputOK = false;
		}
		}
		
		inputOK= false;
		while(!inputOK){
			System.out.println("What is the Expiration Date? (yyyy-MM-dd) if none enter (0000-00-00) ");
			String date = userInput.nextLine();
			date.replace(" ", "");
			inputOK = f.setExpirationDate(date);
		}
		
		inputOK= false;
		while(!inputOK){
			System.out.println("What is the packaging (Plastic, Metal, Paper, None) ");
			String pack = userInput.nextLine();
			inputOK = f.setPackaging(pack);
		}
		
		inputOK = false;
		while(!inputOK){
			System.out.println("From What Milk Type: (Cow, Sheep, Goat, Buffalo, Mixed)");
			String type = userInput.nextLine();
			inputOK = f.setMilkType(type);
		}
		
		inputOK= false;
		while(!inputOK){
			System.out.println("From What Country");
			String count = userInput.nextLine();
			inputOK = f.setOrigin(count);
			}
			
		inputOK= false;
		while (!inputOK) {
			System.out.println("Is it Stackable");
			String pack = userInput.nextLine();
			if (pack.replace(" ", "").equalsIgnoreCase("yes") ){
				inputOK = f.setStackable(true);
				boolean inputOK1= false;
				while(!inputOK1){
					System.out.println("What is the max stack amount? (must be greater than 1)");
					int amount = userInput.nextInt();
					inputOK1 = f.setMaxStackCount(amount);
				}
				inputOK1= false;
				while(!inputOK1){
					System.out.println("How do you stack it?");
					String des = userInput.nextLine();
					inputOK1 = f.setStackDescription(des);
				}
			}else {
				f.setStackable(false);
				inputOK = true;
			}
		}
		f.setProductAge();
		f.getProductAge();
		food[elementsCount] = f;
		return true;
	}
	
	/**
	 * method that creates precooked
	 * @return 
	 */
	public static boolean createPrecooked(FoodItem[] food, int elementsCount,Scanner userInput) {
		PreCooked f = new PreCooked();
		
		boolean inputOK = false;
		while(!inputOK) {
			System.out.print("Enter the products Name: ");
			String name = userInput.nextLine();
			inputOK = f.setName(name);
		}
		
		inputOK = false;
		while(!inputOK) {
			System.out.print("Enter the products Brand: ");
			String brand = userInput.nextLine();
			inputOK = f.setBrand(brand);
		}
		
		inputOK = false;
		while (!inputOK) {
			System.out.println("Enter the products UPC (12 digits): ");
			try {
				long upc = Long.parseLong(userInput.nextLine());
				inputOK = f.setUpc(upc);
			} catch(NumberFormatException e)
			{
				System.out.println("UPC Must Be Integers Only");
				inputOK = false;
			}
		}
	
		inputOK = false; 
		while (!inputOK){
		System.out.println("Enter the Production Date(yyyy-MM-dd)" );
		String prodDate = userInput.nextLine();
		f.setProductionDate(prodDate);
		inputOK = f.setProductionDate(prodDate);
		}
		
		inputOK = false;
		while(!inputOK) {
		System.out.println("Enter the products Weight in Pounds: ");
		try {
			double weight = Double.parseDouble(userInput.nextLine());
			inputOK = f.setUnitWeight(weight);
		} catch(NumberFormatException e)
		{
			System.out.println("Weight Must Be Integers Only");
			inputOK = false;
		}
		}
		
		inputOK= false;
		while(!inputOK){
			System.out.println("What is the Expiration Date? (yyyy-MM-dd) if none enter 0000-00-00 ");
			String date = userInput.nextLine();
			date.replace(" ", "");
			inputOK = f.setExpirationDate(date);
		}
		
		inputOK= false;
		while(!inputOK){
			System.out.println("What is the packaging (Plastic, Metal, Paper, None) ");
			String pack = userInput.nextLine();
			inputOK = f.setPackaging(pack);
		}
		
		inputOK = false;
		while(!inputOK){
			System.out.println("Is it Frozen? ");
			String froz = userInput.nextLine();
			if (froz.replace(" ", "").equalsIgnoreCase("yes") ){
				inputOK = f.setFrozen(true);
			}else { 
				f.setFrozen(false);
				inputOK = true;
			}
		}
		
		inputOK = false;
		while(!inputOK){
			String[] arrayOfIn = new String [3];
			for (int i = 0; i < arrayOfIn.length; i++) {
				System.out.println("List Three Indredients(One at a Time): ");
				arrayOfIn[i] = userInput.nextLine();
				}
			
			inputOK = f.setIngredients(arrayOfIn);	
		}
		
		inputOK= false;
		while (!inputOK) {
			System.out.println("Is it Stackable");
			String pack = userInput.nextLine();
			if (pack.replace(" ", "").equalsIgnoreCase("yes") ){
				inputOK = f.setStackable(true);
				boolean inputOK1= false;
				while(!inputOK1){
					System.out.println("What is the max stack amount? (must be greater than 1)");
					int amount = userInput.nextInt();
					inputOK1 = f.setMaxStackCount(amount);
				}
				inputOK1= false;
				while(!inputOK1){
					System.out.println("How do you stack it?");
					String des = userInput.nextLine();
					inputOK1 = f.setStackDescription(des);
				}
			}else {
				f.setStackable(false);
				inputOK = true;
			}
		}
		f.setProductAge();
		f.getProductAge();
		food[elementsCount] = f;
		return true;
	}

}
