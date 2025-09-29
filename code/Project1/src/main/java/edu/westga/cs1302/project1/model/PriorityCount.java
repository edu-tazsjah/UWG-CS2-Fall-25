package edu.westga.cs1302.project1.model;

import java.util.List;

/**
 * Contains a static method for getting priority count per task
 * 
 * @author CS 1302
 * @version Fall 2025
 */
public class PriorityCount {
	
	/**
	 * 
	 * Returns the number of tasks with the specified priority
	 * 
	 * @param listView the list thats holding the tasks
	 * @param  priority that you want to count
	 * @return number of tasks with the specified priority
	 */
	public static int getPriorityCount(List<Task> listView, String priority) {
		if (listView == null) {
			throw new IllegalArgumentException("The task list cannot be null");
		}
		
		if (priority == null || priority.isEmpty()) {
			throw new IllegalArgumentException("The selected priority cannot be null");
		}
		
		int total = 0;
		
		for (Task task : listView) {
			if (task.getPriority().equals(priority)) {
				total = total + 1;
			}
		}
		
		return total;
		
	}

}
