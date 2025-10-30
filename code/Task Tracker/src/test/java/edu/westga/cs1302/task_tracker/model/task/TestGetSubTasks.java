package edu.westga.cs1302.task_tracker.model.task;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

public class TestGetSubTasks {
	
	@Test
	void getSubTaskWhenTaskIsEmpty() {
		Task task = new Task("Go Shopping", "At Kroger", TaskPriority.HIGH);
		assertTrue(task.getSubTasks().isEmpty());
	}
	
	@Test
	void getSubTaskWhenTaskIsNotEmpty() {
		Task task = new Task("Go Shopping", "At Kroger", TaskPriority.HIGH);
		task.addTask(new Task("Get Rice", "For a dollar", TaskPriority.HIGH));
		
		assertTrue(task.getSubTasks().isEmpty());
	}

}
