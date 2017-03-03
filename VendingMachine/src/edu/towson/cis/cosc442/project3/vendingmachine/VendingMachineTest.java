package edu.towson.cis.cosc442.project3.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class VendingMachineTest.
 */
public class VendingMachineTest {

	/** The vending. */
	private VendingMachine vending;
	
	/** The item. */
	private VendingMachineItem item;
	
	/** The item 2. */
	private VendingMachineItem item2;
	
	/** The item 3. */
	private VendingMachineItem item3;
	
	/** The item 4. */
	private VendingMachineItem item4;
	
	/**
	 * Sets up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		vending = new VendingMachine();
		item = new VendingMachineItem("Sunkist", 3.0);
		item2 = new VendingMachineItem("Oreos", 1.25);
		item3 = new VendingMachineItem("Dr. Pepper", 2.50);
		item4 = new VendingMachineItem("Fritos", 1.75);
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test add item. 
	 * adds the item object to the array and asserts that that object is equal to the item returned by the getItem method
	 * This test case tests if the addItem method adds a VendingMachine object to the array to a specified place. 
	 */
	@Test
	public void testAddItem() {
		vending.addItem(item, "B");
		assertEquals(item, vending.getItem("B"));
	}
	
	/**
	 * Test add item filled slot.
	 * adds item2 object to the array and tries to add a different object to the same slot
	 * This test case tests the adding of an item to slot that is already filled. It is expected to throw an exception.
	 */
	@Test
	public void testAddItemFilledSlot() {
		vending.addItem(item2, "B");
		try{
			vending.addItem(item3, "B");
			fail("Exception expected");
		}
		catch (VendingMachineException v)
		{
			
		}
		
	}
	
	/**
	 * Test add item invalid code.
	 * Attempts to add the item object to slot "E" which is invalid.
	 * This test case attempts to add an item to an invalid location.
	 */
	@Test
	public void testAddItemInvalidCode() {
		
		try{
			vending.addItem(item, "E");
			fail("Exception expected");
		}
		catch (VendingMachineException v)
		{
			
		}
	}
	
	/**
	 * Test remove item.
	 * asserts that the removedItem is equal to the added item
	 * This test case attempts to remove an item that is in the array.
	 */
	@Test
	public void testRemoveItem() {
		vending.addItem(item2, "C");
		assertEquals(item2, vending.removeItem("C"));
		
	}
	
	/**
	 * Test remove item from empty slot.
	 * This test case is for attempting to remove an item from an empty slot.
	 */
	@Test
	public void testRemoveItemFromEmptySlot() {
		try{
			vending.removeItem("C");
			fail("Exception expected");
		}
		catch (VendingMachineException v){
			
		}
		
	}
	
	/**
	 * Test remove item from invalid slot.
	 * adds item4 to slot C so the array is not empty
	 * then test in attempt to remove from invalid slot "F"
	 * This test case attempts to remove an item from an invalid slot.
	 */
	@Test
	public void testRemoveItemFromInvalidSlot() {
		try{
			vending.addItem(item4, "C");
			vending.removeItem("F");
			fail("Exception expected");
		}
		catch (VendingMachineException v){
			
		}
		
	}
	

	/**
	 * Test insert money.
	 * Tests the basic adding of a positive amount of money to the vending machine. 
	 */
	@Test
	public void testInsertMoney() {
		vending.insertMoney(5.0);
		assertEquals(5.0, vending.getBalance(), 0.001);
	}
	
	/**
	 * Test insert invalid money amount.
	 * This test case attempts to insert a negative amount of money to the vending machine. 
	 */
	@Test
	public void testInsertInvalidMoneyAmount() {
		try
		{
			vending.insertMoney(-5.0);
			fail("Invalid Amount of Money");
		}
		catch (VendingMachineException v)
		{
			
		}
		}
	
	/**
	 * Test insert zero money.
	 * This test case attempts to insert an amount of 0 dollars into the vending machine and is expected to throw an exception.
	 */
	@Test
	
	public void testInsertZeroMoney() {
		try
		{
			vending.insertMoney(0.0);
			fail("Invalid Amount of Money");
		}
		catch (VendingMachineException v)
		{
			
		}
		}
		
	/**
	 * Test get balance initial balance.
	 * This test case is to show that the initial balance of 0 dollars can be returned by the getBalance method.
	 */
	@Test
	public void testGetBalanceInitialBalance() {
		assertEquals(0.0, vending.getBalance(), 0.001);
	}

	/**
	 * Test get balance.
	 * This test case shows that the getBalance method works on a positive amount of inserted money.
	 */
	@Test
	public void testGetBalance() {
		vending.insertMoney(10.0);
		assertEquals(10.0, vending.getBalance(), 0.001);
	}
	
	/**
	 * Test get negative balance.
	 * This test case shows that a negative balance cannot exist in the vending machine. It is expected to throw an exception.
	 */
	@Test
	public void testGetNegativeBalance() {
		try {
			vending.insertMoney(-5.0);
			vending.getBalance();
			fail("Exception expected");
		}
		catch (VendingMachineException v)
		{
			
		}
		
	}
	
	/**
	 * Test make purchase less money.
	 * This test case is to show that a purchase cannot be made if the balance is less than the price of the item.
	 */
	@Test
	public void testMakePurchaseLessMoney() {
		vending.insertMoney(1.50);
		vending.addItem(item, "D");      //item has a price of 3.0
		assertFalse(vending.makePurchase("D"));
	}

	
	/**
	 * Test make purchase null code.
	 * This test case shows that an exception should be thrown if the user attempts to buy an item without specifying the slot.
	 * The slot specified is equal to null.
	 */
	@Test
	public void testMakePurchaseNullCode() {
		vending.insertMoney(5.50);
		try
		{
			vending.makePurchase(null);
			fail("Exception expected");
		}
		catch (NullPointerException n)
		{
			
		}
		
	}
	
	/**
	 * Test make purchase.
	 * This test case is to show that a purchase can be made on a valid item with a balance >= item's price
	 */
	@Test
	public void testMakePurchase() {
		vending.insertMoney(5.0);
		vending.addItem(item, "A");  //item's price = 3.0
		assertTrue(vending.makePurchase("A"));
		
	}
	
	/**
	 * Test make purchase balance.
	 * This test case verifies that the balance is reduced by the item's price when a purchase is made.
	 */
	@Test
	public void testMakePurchaseBalance() {
		vending.insertMoney(5.0); 
		vending.addItem(item, "A");
		vending.makePurchase("A");
		assertEquals(2.0, vending.getBalance(), 0.001);
	}
	

	/**
	 * Test return change.
	 * This test case shows that the returnChange method returns the remaining balance after the item's price has been subtracted
	 * from it after making a purchase.
	 */
	@Test
	public void testReturnChange(){
		
		vending.insertMoney(5.0);
		vending.addItem(item2, "A");
		vending.makePurchase("A");
		assertEquals(3.75, vending.returnChange(), 0.001);
		
	}
	
	/**
	 * Test return change of zero.
	 * This test case shows that if the balance is 0, it is not reassigned to zero and the change of zero is returned.
	 * Ensures decision coverage of the if statement I added to the returnChange method
	 */
	@Test
	public void testReturnChangeOfZero()
	{
			assertEquals(0, vending.returnChange(), 0.001);	
	}
	
	
	
	/**
	 * Test return change zero balance.
	 * This test case shows that the balance is set to 0 after a purchase is made.
	 */
	@Test
	public void testReturnChangeZeroBalance(){
		
		vending.insertMoney(3.0);
		vending.addItem(item2, "B");
		vending.makePurchase("B");
		vending.returnChange();
		assertEquals(0.0, vending.getBalance(), 0.001);
		
	}

}
