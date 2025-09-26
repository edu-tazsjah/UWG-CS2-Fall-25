package edu.westga.cs1302.project1.views;

import edu.westga.cs1302.project1.model.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Controller class for drawing various things to our canvas window.
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class MainWindow {
	
	@FXML
	private TextField newTaskName;
	
	@FXML
	private TextArea newTaskDescription;
	
	@FXML
	private ComboBox<String> newTaskPriority;
	
	@FXML
	private ListView<Task> listView;

	/**
	 * Perform any needed initialization of UI components and underlying objects.
	 */
	public void initialize() {
		this.newTaskPriority.getItems().add("HIGH");
		this.newTaskPriority.getItems().add("MEDIUM");
		this.newTaskPriority.getItems().add("LOW");
	}

	/**
	 * Creates a new Task model and adds it to the list via GUI
	 */
	public void addNewTask() {
		try {
			String name = this.newTaskName.getText();
			String description = this.newTaskDescription.getText();
			String priority = this.newTaskPriority.getSelectionModel().getSelectedItem();
			Task newTask = new Task(name, description, priority);
			this.listView.getItems().add(newTask);
		} catch (IllegalArgumentException | NullPointerException exception) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setContentText(exception.getMessage());
			alert.showAndWait();
		}
    	
    }
}
