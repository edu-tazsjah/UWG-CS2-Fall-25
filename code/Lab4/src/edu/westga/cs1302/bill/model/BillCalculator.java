package edu.westga.cs1302.bill.model;

/** Calculates the subtotal, tax, tip, and total for BillItem objects
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class BillCalculator {
	
	/** Returns the SubTotal double of an array of BillItems
	 * 
	 * @precondition billItem(x) != null
	 * @postcondition none
	 * 
	 * @param billItem the array of the Bill object 
	 * @return the subtotal double of the bill
	 * 
	 */
	public static double getSubtotal(BillItem[] billItem) {
//		for(BillItem item : billItem) {
//			if(item.getAmount() > 0) {
//				
//			}
//			else {
//				return 0;
//			}
//		}
		return 0;
	}
	
	/** Returns the Tax double of an array of BillItems
	 * 
	 * @precondition billItem(x) != null
	 * @postcondition none
	 * 
	 * @param billItem the array of the Bill object 
	 * @return the tax double of the bill
	 * 
	 */
	public static double getTax(BillItem[] billItem) {
		return 0;
	}
	
	/** Returns the Tip double of an array of BillItems
	 * 
	 * @precondition billItem(x) != null
	 * @postcondition none
	 * 
	 * @param billItem the array of the Bill object 
	 * @return the tip double of the bill
	 * 
	 */
	public static double getTip(BillItem[] billItem) {
		return 0;
	}
	
	/** Returns the Total amount of an array of BillItems
	 * 
	 * @precondition billItem(x) != null
	 * @postcondition none
	 * 
	 * @param billItem the array of the Bill object 
	 * @return the total double of the bill
	 * 
	 */
	public static double getTotal(BillItem[] billItem) {
		return 0;
	}

}
