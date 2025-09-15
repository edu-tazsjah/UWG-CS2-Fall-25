package edu.westga.cs1302.bill.test.model.billcalculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.bill.model.Bill;
import edu.westga.cs1302.bill.model.BillCalculator;
import edu.westga.cs1302.bill.model.BillItem;

class TestBillCalculator {

	@Test
	void testGetSubtotalOneItem() {
		Bill bill = new Bill();
		BillItem juice = new BillItem("Juice", 2);
		bill.addItem(juice);
		ArrayList<BillItem> items = bill.getItems();
		
		double actualSubtotal = 2;
		assertEquals(actualSubtotal, BillCalculator.getSubtotal(BillCalculator.toArray(items)));
	}
	
	@Test
	void testGetSubtotalMultipleItems() {
		Bill bill = new Bill();
		BillItem juice = new BillItem("Juice", 2);
		BillItem soda = new BillItem("Juice", 6);
		BillItem candy = new BillItem("Juice", 2);
		bill.addItem(juice);
		bill.addItem(candy);
		bill.addItem(soda);
		ArrayList<BillItem> items = bill.getItems();
		
		double actualSubtotal = 10;
		assertEquals(actualSubtotal, BillCalculator.getSubtotal(BillCalculator.toArray(items)));
	}
	
	@Test
	void testGetTaxOneItem() {
		Bill bill = new Bill();
		BillItem juice = new BillItem("Juice", 2);
		bill.addItem(juice);
		ArrayList<BillItem> items = bill.getItems();
		
		double actualTax = 2 * Bill.TAX_RATE;
		assertEquals(actualTax, BillCalculator.getTax(BillCalculator.toArray(items)));
	}
	
	@Test
	void testGetTaxMultipleItems() {
		Bill bill = new Bill();
		BillItem juice = new BillItem("Juice", 2);
		BillItem soda = new BillItem("Juice", 6);
		BillItem candy = new BillItem("Juice", 2);
		bill.addItem(juice);
		bill.addItem(candy);
		bill.addItem(soda);
		ArrayList<BillItem> items = bill.getItems();
		
		double actualTax = 10 * Bill.TAX_RATE;
		assertEquals(actualTax, BillCalculator.getTax(BillCalculator.toArray(items)));
	}
	
	@Test
	void testGetTipOneItem() {
		Bill bill = new Bill();
		BillItem juice = new BillItem("Juice", 2);
		bill.addItem(juice);
		ArrayList<BillItem> items = bill.getItems();
		
		double actualTip = 2 * Bill.TIP_RATE;
		assertEquals(actualTip, BillCalculator.getTip(BillCalculator.toArray(items)));
	}
	
	@Test
	void testGetTipMultipleItems() {
		Bill bill = new Bill();
		BillItem juice = new BillItem("Juice", 2);
		BillItem soda = new BillItem("Juice", 6);
		BillItem candy = new BillItem("Juice", 2);
		bill.addItem(juice);
		bill.addItem(candy);
		bill.addItem(soda);
		ArrayList<BillItem> items = bill.getItems();
		
		double actualTip = 10 * Bill.TIP_RATE;
		assertEquals(actualTip, BillCalculator.getTip(BillCalculator.toArray(items)));
	}
	
	@Test
	void testGetTotalOneItem() {
		Bill bill = new Bill();
		BillItem juice = new BillItem("Juice", 2);
		bill.addItem(juice);
		ArrayList<BillItem> items = bill.getItems();
		
		double actualTotal = 2 + (2 * Bill.TAX_RATE) + (2 * Bill.TIP_RATE);
		
		assertEquals(actualTotal, BillCalculator.getTotal(BillCalculator.toArray(items)));
	}
	
	@Test
	void testGetTotalMultipleItems() {
		Bill bill = new Bill();
		BillItem juice = new BillItem("Juice", 2);
		BillItem soda = new BillItem("Juice", 6);
		BillItem candy = new BillItem("Juice", 2);
		bill.addItem(juice);
		bill.addItem(candy);
		bill.addItem(soda);
		ArrayList<BillItem> items = bill.getItems();
		
		double actualTotal = 10 + (10 * Bill.TAX_RATE) + (10 * Bill.TIP_RATE);
		
		assertEquals(actualTotal, BillCalculator.getTotal(BillCalculator.toArray(items)));
	}

}
