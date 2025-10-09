package edu.westga.cs1302.task_tracker.model;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

/**
 *  This class sorts tasks from ascending to descending order
 * 
 *  @author CS 1302
 *  @version Fall 2025
 */
public class TaskAscendingComparator implements Comparable<Task> {
	
	@FXML
	private ListView<Task> sorted;
	
	/** Sorts the given ListView by ascending order
	 * 
	 * @param tasks that need to be sorted
	 * @throws IllegalArgumentException
	 */
	public TaskAscendingComparator(ListView<Task> tasks) {
		if (tasks == null) {
			throw new IllegalArgumentException("ListView cannot be null");
		}
		
		this.sorted = tasks;
	}
	

	/** Compares a task to a task and returns an int
	 * 
	 * @param task that needs to be compared
	 * @return int which is the result
	 */
	@Override
	public int compareTo(Task task) {
		// TODO Auto-generated method stub
		return 0;
	}

}
