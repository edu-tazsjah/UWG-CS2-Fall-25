package edu.westga.cs1302.project1.model.task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project1.model.Task;

class TestTaskConstructor {

	@Test
	void testNullTaskName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "description", "priority");
		});
	}
	
	@Test
	void testEmptyTaskName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("", "description", "priority");
		});
	}
	
	@Test
	void testCorrectName() {
		Task task = new Task("Task", "description", "priority");
		assertEquals("Task", task.toString());
	}
	
	@Test
	void testNullDescription() {
		Task task = new Task("Task", null, "priority");
		assertEquals("", task.getDescription());
	}
	
	@Test
	void testEmptyDescription() {
		Task task = new Task("Task", "", "priority");
		assertEquals("", task.getDescription());
	}
	
	@Test
	void testCorrectDescription() {
		Task task = new Task("Task", "Description", "priority");
		assertEquals("Description", task.getDescription());
	}
	
	@Test
	void testNullTaskPriority() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("Task", "description", null);
		});
	}
	
	@Test
	void testEmptyTaskPriority() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("Task", "description", "");
		});
	}
	
	@Test
	void testCorrectTaskPriority() {
		Task task = new Task("Task", "description", "priority");
		assertEquals("priority", task.getPriority());
	}
	

}
