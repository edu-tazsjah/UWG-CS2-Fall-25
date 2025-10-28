package edu.westga.cs1302.task_tracker.model;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

/**
 *  This class sorts tasks from ascending to descending order
 * 
 *  @author CS 1302
 *  @version Fall 2025
 */
public class TaskAscendingComparator implements Comparator<Task> {
	
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
	 * @return int which is the result
	 */
	@Override
	public int compare(Task t1, Task t2) {
		return t1.getPriority().compareTo(t2.getPriority());
	}

}
