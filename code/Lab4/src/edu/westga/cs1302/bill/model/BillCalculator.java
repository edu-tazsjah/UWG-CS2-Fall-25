package edu.westga.cs1302.bill.model;

import java.util.ArrayList;

/** Calculates the subtotal, tax, tip, and total for BillItem objects
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class BillCalculator {
	
	/** Returns the SubTotal double of an array of BillItems
	 * 
	 * @precondition billItem(x) != null
	 * 				billItem != null
	 * @postcondition none
	 * 
	 * @param billItem the array of the Bill object 
	 * @return the subtotal double of the bill
	 * 
	 */
	public static double getSubtotal(BillItem[] billItem) {
		if (billItem == null) {
			throw new IllegalArgumentException("There are no items in this Bill");
		}
		
		for (BillItem item : billItem) {
			if (item == null) {
				throw new IllegalArgumentException("This bill item is null");
			}
		}
		
		double subtotal = 0;
		for (BillItem item : billItem) {
			if (item.getAmount() > 0) {
				subtotal = subtotal + item.getAmount();
			} else {
				return 0;
			}
		}
		return subtotal;
	}
	
	/** Returns the Tax double of an array of BillItems
	 * 
	 * @precondition billItem(x) != null
	 * 				billItem != null
	 * @postcondition none
	 * 
	 * @param billItem the array of the Bill object 
	 * @return the tax double of the bill
	 * 
	 */
	public static double getTax(BillItem[] billItem) {
		if (billItem == null) {
			throw new IllegalArgumentException("There are no items in this Bill");
		}
		
		for (BillItem item : billItem) {
			if (item == null) {
				throw new IllegalArgumentException("This bill item is null");
			}
		}
		
		double subtotal = 0;
		for (BillItem item : billItem) {
			if (item.getAmount() > 0) {
				subtotal = subtotal + item.getAmount();
			} else {
				return 0;
			}
		}
		
		double tax = subtotal * Bill.TAX_RATE;
		return tax;
	}
	
	/** Returns the Tip double of an array of BillItems
	 * 
	 * @precondition billItem(x) != null
	 * 				billItem != null
	 * @postcondition none
	 * 
	 * @param billItem the array of the Bill object 
	 * @return the tip double of the bill
	 * 
	 */
	public static double getTip(BillItem[] billItem) {
		if (billItem == null) {
			throw new IllegalArgumentException("There are no items in this Bill");
		}
		
		for (BillItem item : billItem) {
			if (item == null) {
				throw new IllegalArgumentException("This bill item is null");
			}
		}
		
		double subtotal = 0;
		for (BillItem item : billItem) {
			if (item.getAmount() > 0) {
				subtotal = subtotal + item.getAmount();
			} else {
				return 0;
			}
		}
		
		double tip = subtotal * Bill.TIP_RATE;
		return tip;
	}
	
	/** Returns the Total amount of an array of BillItems
	 * 
	 * @precondition billItem(x) != null
	 * 				billItem != null
	 * @postcondition none
	 * 
	 * @param billItem the array of the Bill object 
	 * @return the total double of the bill
	 * 
	 */
	public static double getTotal(BillItem[] billItem) {
		if (billItem == null) {
			throw new IllegalArgumentException("There are no items in this Bill");
		}
		
		for (BillItem item : billItem) {
			if (item == null) {
				throw new IllegalArgumentException("This bill item is null");
			}
		}
		
		double subtotal = 0;
		for (BillItem item : billItem) {
			if (item.getAmount() > 0) {
				subtotal = subtotal + item.getAmount();
			} else {
				return 0;
			}
		}
		
		double tax = subtotal * Bill.TAX_RATE;
		double tip = subtotal * Bill.TIP_RATE;
		double total = subtotal + tax + tip;
		
		return total;
		
	}
	
	/** Converts an ArrayList into an Array
	 * 
	 * @param items which is the array list
	 * @return array
	 */
	public static BillItem[] toArray(ArrayList<BillItem> items) {
		return items.toArray(new BillItem[0]);
	}

}
