package edu.towson.cis.cosc442.project3.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class VendingMachineItemTest.
 */
public class VendingMachineItemTest {

	/** The vend. */
	private VendingMachineItem vend;
	
	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		vend = new VendingMachineItem("Sunkist", 2.0);
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
	 * Test vending machine item name.
	 * This test case shows that the constructor can assign the specified name to a VendingMachineItem object
	 * and uses the getName method to verify equality.
	 */
	@Test
	public void testVendingMachineItemName() {
		VendingMachineItem vend2 = new VendingMachineItem("Sunkist", 2.0);
		assertEquals("Sunkist", vend2.getName());
	}

	/**
	 * Test vending machine item price of zero.
	 * This test case shows that a price of zero dollars cannot be assigned to a VendingMachineItem object and an exception is 
	 * expected to be thrown.
	 */
	@Test
	public void testVendingMachineItemPriceOfZero() {
		try
		{
			VendingMachineItem vend2 = new VendingMachineItem("Sunkist", 0.0);
			fail("Exception expected");
		}
		catch (VendingMachineException v)
		{
			
		}	
		
	}
	
	/**
	 * Test vending machine item price.
	 * This test case shows that the constructor does proper assignment of the price of an item if that price >= 0.
	 */
	@Test
	public void testVendingMachineItemPrice() {
		VendingMachineItem vend2 = new VendingMachineItem("Sunkist", 2.0);
		assertEquals(2.0, vend2.getPrice(), 0.001);
	}

	
	/**
	 * Test vending machine item price exception.
	 * This test case shows that a negative price cannot be assigned to a VendingMachineItem object and an exception should be thrown.
	 */
	@Test
	public void testVendingMachineItemPriceException() {
		try
		{
			VendingMachineItem vend2 = new VendingMachineItem("Sunkist", -2.0);
			fail("Exception expected");
		}
		catch(VendingMachineException v)
		{
			
		}
		
	}
	

	/**
	 * Test get name.
	 * This test case shows that the getName method returns the assigned name of a declared VendingMachineItem object.
	 */
	@Test
	public void testGetName() {
		assertEquals("Sunkist", vend.getName());
	}

	/**
	 * Test get price.
	 * This test case shows that the getPrice returns the assigned price of a declared VendingMachineItem object.
	 */
	@Test
	public void testGetPrice() {
		assertEquals(2.0, vend.getPrice(), 0.001);
	}

}
