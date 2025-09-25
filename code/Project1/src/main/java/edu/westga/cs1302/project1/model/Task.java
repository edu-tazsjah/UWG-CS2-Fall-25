package edu.westga.cs1302.project1.model;

public class Task {
	
	private String name;
	private String description;
	private String priority;
	
	/** Creates a new Task model
	 * 
	 * @precondition name != null
	 * 				!name.isEmpty
	 * 				priority != null
	 * 				!priority.isEmpty
	 * @postcondition none
	 * 
	 * @param name of the Task model
	 * @param description of the Task model
	 * @param priority of the Task model
	 * 
	 * @throws IllegalArgumentException
	 */
	public Task(String name, String description, String priority) {
		if (name == null || name.isEmpty()) {
			throw new IllegalArgumentException("Task name cannot be null!");
		}
		
		if (priority == null || priority.isEmpty()) {
			throw new IllegalArgumentException("Task priority cannot be null!");
		}
		
		this.name = name;
		this.description = description;
		this.priority = priority;
	}
	
	/** Returns the name of the Task model
	 * 
	 * @return string name of the Task
	 * 
	 */
	public String toString() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getPriority() {
		return this.priority;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

}
