package edu.westga.cs1302.trask_tracker.model.containertask;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.ContainerTask;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestGetSubTasks {
	
	@Test
	void testGetSubTasksInitiallyEmpty() {
		ContainerTask container = new ContainerTask("Main", "Top-level task", TaskPriority.HIGH);
		assertTrue(container.getSubTasks().isEmpty());
	}

	@Test
	void testGetSubTasksReturnsAllAddedTasks() {
		ContainerTask container = new ContainerTask("Main", "Top-level task", TaskPriority.HIGH);
		Task sub1 = new Task("Sub1", "First subtask", TaskPriority.LOW);
		Task sub2 = new Task("Sub2", "Second subtask", TaskPriority.MEDIUM);

		container.addTask(sub1);
		container.addTask(sub2);

		assertEquals(2, container.getSubTasks().size());
		assertTrue(container.getSubTasks().contains(sub1));
		assertTrue(container.getSubTasks().contains(sub2));
	}

	@Test
	void testGetSubTasksReflectsListChanges() {
		ContainerTask container = new ContainerTask("Main", "Top-level task", TaskPriority.HIGH);
		Task sub = new Task("Sub", "Subtask", TaskPriority.MEDIUM);

		container.addTask(sub);

		var subTasks = container.getSubTasks();
		assertEquals(1, subTasks.size());

		Task sub2 = new Task("Another", "Next subtask", TaskPriority.LOW);
		container.addTask(sub2);

		assertEquals(2, subTasks.size());
		assertTrue(subTasks.contains(sub2));
	}

}
