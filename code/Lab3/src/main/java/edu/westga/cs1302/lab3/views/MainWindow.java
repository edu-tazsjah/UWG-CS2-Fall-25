package edu.westga.cs1302.lab3.views;

import edu.westga.cs1302.lab3.model.Bill;
import edu.westga.cs1302.lab3.model.BillItem;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Controller class for drawing various things to our canvas window.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {
	
	@FXML private TextField billItemName;
	@FXML private TextField billItemAmount;
	@FXML private TextArea billDisplayArea;
	
	private Bill bill;
	private BillView billview;
    
    /**
     * Perform any needed initialization of UI components and underlying objects.
     */
    public void initialize() {
    	this.bill = new Bill();
    	this.billview = new BillView();
    }
    
    /**
     * This is the main code that assist with the UI within the GUI
     */
    
    public void addBillItem() {	
    	String name = this.billItemName.getText();
    	String amountText = this.billItemAmount.getText();
    	
    	double amountNumber = 0;
    	
    	try {
    		double number = Double.parseDouble(amountText);
    		amountNumber = number;
    	} catch (NumberFormatException exception) {
    		System.out.println("This is not a number!");
    	}
    	
    	BillItem item = new BillItem(name, amountNumber);
    	this.bill.addItem(item);
  
    	this.billDisplayArea.setText(this.billview.getText(this.bill));
    }
    
}
