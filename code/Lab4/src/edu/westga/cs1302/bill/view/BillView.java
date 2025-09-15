package edu.westga.cs1302.bill.view;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillCalculator;

/** Supports displaying the information contained in a Bill.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class BillView {

	/** Return a String containing the list of bill items and total for the bill.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param bill the bill to be viewed
	 * 
	 * @return a String containing the list of bill items and total for the bill
	 */
	public static String getText(Bill bill) {
		
		String text = "ITEMS" + System.lineSeparator();
		
		text += System.lineSeparator();
		text += "SUBTOTAL - $" + BillCalculator.getSubtotal(BillCalculator.toArray(bill.getItems())) + System.lineSeparator();
		text += "TAX - $" + BillView.roundToNearestHundredth(BillCalculator.getTax(BillCalculator.toArray(bill.getItems()))) + System.lineSeparator();
		text += "TIP - $" + BillView.roundToNearestHundredth(BillCalculator.getTip(BillCalculator.toArray(bill.getItems()))) + System.lineSeparator();
		text += "TOTAL - $" + BillView.roundToNearestHundredth(BillCalculator.getTotal(BillCalculator.toArray(bill.getItems())));
		
		return text;
	}
	
	private static double roundToNearestHundredth(double value) {
		return (int) (value * 100) / 100.0;
	}
}
