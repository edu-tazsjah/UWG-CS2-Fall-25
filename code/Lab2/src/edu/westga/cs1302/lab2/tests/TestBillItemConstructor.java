package edu.westga.cs1302.lab2.tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.lab2.model.Bill;
import edu.westga.cs1302.lab2.model.BillItem;

class TestBillItemConstructor {

	@Test
	void addEmptyBillItemName() {
		Bill bill = new Bill();
		BillItem bi = new BillItem("", 1);
		bill.addItem(bi);
		assertEquals(bill.getItems().get(0), bi);
	}
	
	@Test
	void addBillItem() {
		Bill bill = new Bill();
		BillItem bi = new BillItem("Test", 1);
		bill.addItem(bi);
		assertEquals(bill.getItems().get(0), bi);
	}
	
	@Test
	void oneBelowMinimum() {
		assertThrows(IllegalArgumentException.class, () -> new BillItem("Test", 0));
	}
	
	@Test
	void oneAtMinimum() {
		BillItem billitem = new BillItem("Bill", 1);
		assertEquals(1, billitem.getAmount());
	}
	
	@Test
	void oneAboveMinimum() {
		BillItem billitem = new BillItem("Bill", 2);
		assertEquals(2, billitem.getAmount());
	}

}
