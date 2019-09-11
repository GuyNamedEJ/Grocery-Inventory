package assignment4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;



import org.junit.jupiter.api.Test;




class Assignment4Tester {

	// Test for Processedfood-------------------------------------------------------------------------------------------------------------------

	// Test for Description

	/**
	 * Test: a valid input
	 * Result: Pass
	 * Reason: It is valid, length greater than 1
	 */
	@Test
	void testValidDes() {
		ProcessedFood i = new Cheese();
		String validDes = "Test";
		i.setStackDesctiption(validDes);
		assertEquals(validDes, i.getStackDescription());
	}
	
	/**
	 * Test: a short description
	 * Result: Pass
	 * Reason: the invalid string is never set
	 */
	@Test
	void testShortDes() {
		ProcessedFood i = new Cheese();
		String validDes = "Test";
		String invalidDes = "i";
		i.setStackDesctiption(validDes);
		i.setStackDesctiption(invalidDes);
		assertEquals(validDes, i.getStackDescription());
	}

	/**
	 * Test: a null
	 * Result: Pass
	 * Reason: this is in the setter
	 */
	@Test
	void testNullDes() {
		ProcessedFood i = new Cheese();
		String validName = "Test";
		i.setStackDesctiption(validName);
		i.setStackDesctiption(null);
		assertNotNull(i.getStackDescription());
	}

	/**
	 * Test: a constructor
	 * Result: Pass
	 * Reason: a constructor was made
	 */
	@Test
	void testDesConstructor() {
		ProcessedFood i = new Cheese();
		assertNotNull(i.getStackDescription());
	}

	// Test for Stackable

	/**
	 * Test: set stackable true
	 * Result: Pass
	 * Reason: it can only be true or false
	 */
	@Test
	void testStackableTrue() {
		ProcessedFood i = new Cheese();
		boolean value = true;
		i.setStackable(value);
		assertEquals(value, i.isStackable());
	}

	/**
	 * Test: set stackable false
	 * Result: Pass
	 * Reason: it can only be true or false
	 */
	@Test
	void testStackableFalse() {
		ProcessedFood i = new Cheese();
		boolean value = false;
		i.setStackable(value);
		assertEquals(value, i.isStackable());
	}
	
	//Test for Max stack amount
	
	/**
	 * Test: for a valid stack amount
	 * Result: Pass
	 * Reason: it must be at least 1
	 */
	@Test
	void testValidStackAmount() {
		ProcessedFood i = new Cheese();
		int validAmount = 1;
		i.setMaxStackCount(validAmount);
		assertEquals(validAmount, i.getMaxStackCount());
	}
	
	
	/**
	 * Test: for a valid stack amount
	 * Result: Pass
	 * Reason: it must be at least 1, invalid is never set
	 */
	@Test
	void testNotValidStackAmount() {
		ProcessedFood i = new Cheese();
		int validAmount = 1;
		int invalidAmount = 0;
		i.setMaxStackCount(validAmount);
		i.setMaxStackCount(invalidAmount);
		assertEquals(validAmount, i.getMaxStackCount());
		
	}

	//Test for Protein-----------------------------------------------------------------------------------------------------------------------------------------------

	//Test for Description
	
	/**
	 * Test: a valid input
	 * Result: Pass
	 * Reason: It is valid, length greater than 1
	 */
	@Test
	void testValidDesProtein() {
		Protein i = new Protein();
		String validDes = "Test";
		i.setStackDesctiption(validDes);
		assertEquals(validDes, i.getStackDescription());
		
	}
	
	/**
	 * Test: a short description
	 * Result: Pass
	 * Reason: the invalid string is never set
	 */
	@Test
	void testShortDesProtein() {
		Protein i = new Protein();
		String validDes = "Test";
		String invalidDes = "i";
		i.setStackDesctiption(validDes);
		i.setStackDesctiption(invalidDes);
		assertEquals(validDes, i.getStackDescription());
	}
	
	/**
	 * Test: a constructor
	 * Result: Pass
	 * Reason: a constructor was made
	 */
	@Test
	void testDesConstrutorProtein() {
		Protein i = new Protein();
		assertNotNull(i.getStackDescription());
		
	}
	
	/**
	 * Test: a null
	 * Result: Pass
	 * Reason: this is in the setter
	 */
	@Test
	void testDesNullProtein() {
		Protein i = new Protein();
		String validDes = "test";
		i.setStackDesctiption(validDes);
		i.setStackDesctiption(null);
		assertNotNull(validDes, i.getStackDescription());
	}
	
	//Test for Stackable
	
	/**
	 * Test: set stackable true
	 * Result: Pass
	 * Reason: it can only be true or false
	 */
	@Test
	void testStackableTrueProtein() {
		Protein i = new Protein ();
		boolean value = true;
		i.setStackable(value);
		assertEquals(value, i.isStackable());
	}
	
	/**
	 * Test: set stackable false
	 * Result: Pass
	 * Reason: it can only be true or false
	 */
	@Test
	void testStackableFalseProtein() {
		Protein i = new Protein ();
		boolean value = false;
		i.setStackable(value);
		assertEquals(value, i.isStackable());
	}

	//Test for Max Stack amount
	
	/**
	 * Test: for a valid stack amount
	 * Result: Pass
	 * Reason: it must be at least 1
	 */
	@Test
	void testValidStackAmountProtein() {
		Protein i = new Protein();
		int validAmount = 1;
		i.setMaxStackCount(validAmount);
		assertEquals(validAmount, i.getMaxStackCount());
	}
	
	
	/**
	 * Test: for a valid stack amount
	 * Result: Pass
	 * Reason: it must be at least 1, invalid is never set
	 */
	@Test
	void testNotValidStackAmountProtein() {
		Protein i = new Protein();
		int validAmount = 1;
		int invalidAmount = 0;
		i.setMaxStackCount(validAmount);
		i.setMaxStackCount(invalidAmount);
		assertEquals(validAmount, i.getMaxStackCount());
		
	}

}
