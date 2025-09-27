package edu.westga.cs1302.project1.model.task;

import edu.westga.cs1302.project1.model.Task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TestTaskMethodSetDescription {
	
	@Test
	void setNullDescription() {
		Task task = new Task("Task", "FirstDescription", "priority");
		task.setDescription(null);
		assertEquals("", task.getDescription());
	}
	
	@Test
	void setEmptyDescription() {
		Task task = new Task("Task", "FirstDescription", "priority");
		task.setDescription("");
		assertEquals("", task.getDescription());
	}
	
	@Test
	void setCorrectDescription() {
		Task task = new Task("Task", "FirstDescription", "priority");
		task.setDescription("Description");
		assertEquals("Description", task.getDescription());
	}

}
