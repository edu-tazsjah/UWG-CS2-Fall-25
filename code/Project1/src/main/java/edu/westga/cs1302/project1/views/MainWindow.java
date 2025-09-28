package edu.westga.cs1302.project1.views;

import edu.westga.cs1302.project1.model.Task;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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
	
	@FXML
	private TextArea currentTaskDescription;
	
	@FXML
	private TextField currentTaskPriority;

	@FXML
	private Button deleteTaskButton;
	
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
	
	/**
	 * Handles the display boxes for the current tasks
	 * 
	 * @param event that triggered this method
	 */
	public void onSelectTask(MouseEvent event) {
		if (this.listView.getSelectionModel().getSelectedItem() != null) {
			Task task = this.listView.getSelectionModel().getSelectedItem();
			String description = task.getDescription();
			String priority = task.getPriority();

			this.currentTaskDescription.setText(description);
			this.currentTaskPriority.setText(priority);
			this.deleteTaskButton.setDisable(false);
		}
	}
	
	/**
	 * Handles the description save button
	 */
	public void updateDescription() {
		if (this.listView.getSelectionModel().isEmpty()) {
			this.alert("You must have a task selected!", AlertType.ERROR);
			this.currentTaskDescription.clear();
			return;
		}
		
		Task task = this.listView.getSelectionModel().getSelectedItem();
		task.setDescription(this.currentTaskDescription.getText());
		this.alert("Successfully set the description", AlertType.INFORMATION);
	}
	
	/**
	 * Private helper method for this class.
	 * 
	 * @param message that you want to alert to the user
	 * @param type alert that you want to be displayed
	 */
	private void alert(String message, AlertType type) {
		Alert alert = new Alert(type);
		alert.setContentText(message);
		alert.showAndWait();
	}
	
	/**
	 * Removes the selected task within the GUI
	 */
	public void deleteSelectedTask() {
		if (this.listView.getSelectionModel().getSelectedItem() != null) {
			Task deleteTask = this.listView.getSelectionModel().getSelectedItem();
			this.listView.getItems().remove(deleteTask);
			this.currentTaskDescription.clear();
			this.currentTaskPriority.clear();
			if (!this.deleteTaskButton.isDisable()) {
				this.deleteTaskButton.setDisable(true);
			}
			this.alert("Successfully deleted the task.", AlertType.INFORMATION);
		}
	}
	
	/**
	 * Event handler for the button disable / enable
	 * 
	 * @param event that happened within the GUI
	 */
	public void onMouseExited(MouseEvent event) {
		if (this.listView.getSelectionModel().getSelectedItem() == null) {
			this.deleteTaskButton.setDisable(true);
		}
	}

}	
