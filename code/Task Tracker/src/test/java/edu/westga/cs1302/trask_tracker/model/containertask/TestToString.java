package edu.westga.cs1302.trask_tracker.model.containertask;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.ContainerTask;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

public class TestToString {
	
	@Test
	void testToStringReturnsCorrectFormat() {
		ContainerTask task = new ContainerTask("Project", "Main container", TaskPriority.HIGH);
		assertEquals("Project (+)", task.toString());
	}

	@Test
	void testToStringDifferentName() {
		ContainerTask task = new ContainerTask("Homework", "CS assignment", TaskPriority.MEDIUM);
		assertEquals("Homework (+)", task.toString());
	}

}
