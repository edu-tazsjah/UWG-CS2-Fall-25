package edu.westga.cs1302.task_tracker.model;

import java.util.ArrayList;
import java.util.List;

/** Extends Task model that can be added to Task model
 * 
 * @author CS 1302
 * @version Fall 2025
 * 
 */
public class ContainerTask extends Task {
	
	private List<Task> subtasks = new ArrayList<Task>();

	/** Creates a ContainerTask model that extended Task model
	 * 
	 * @param name of the task
	 * @param description of the task
	 * @param priority of the task
	 */
	public ContainerTask(String name, String description, TaskPriority priority) {
		super(name, description, priority);
	}
	
	/** Returns Tasks that are in this ContainerTask object
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return list of Tasks
	 */
	@Override
	public List<Task> getSubTasks() {
		return this.subtasks;
	}
	
	/** Adds a Task object to this ContainerTask object
	 * 
	 * @precondition task != null
	 * @postcondition none
	 * 
	 * @return this containing Task objects
	 * 
	 */
	@Override
	public ContainerTask addTask(Task task) {
		if (task == null) {
			throw new IllegalArgumentException("Subtask cannot be null");
		}
		
		this.subtasks.add(task);
		return this;
	}
	
	/** Returns String name of this ContainerTask object
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * return string name of this
	 */
	@Override
	public String toString() {
		String result = this.getName() + " (Sub)";
		return result;
	}
}
