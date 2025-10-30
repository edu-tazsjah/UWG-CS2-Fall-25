package edu.westga.cs1302.trask_tracker.model.containertask;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.ContainerTask;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestAddTask {
	
	@Test
	void testAddTaskShouldThrowIfTaskIsNull() {
		ContainerTask container = new ContainerTask("Main", "Top-level", TaskPriority.HIGH);
		
		assertThrows(IllegalArgumentException.class, () -> {
			container.addTask(null);
		});
	}

	@Test
	void testAddTaskAddsSubtaskToList() {
		ContainerTask container = new ContainerTask("Main", "Top-level", TaskPriority.HIGH);
		Task subTask = new Task("Sub", "Sub-description", TaskPriority.MEDIUM);

		container.addTask(subTask);

		assertEquals(1, container.getSubTasks().size());
		assertEquals(subTask, container.getSubTasks().get(0));
	}

	@Test
	void testAddTaskReturnsSameContainerObject() {
		ContainerTask container = new ContainerTask("Main", "Top-level", TaskPriority.HIGH);
		Task subTask = new Task("Sub", "Sub-description", TaskPriority.MEDIUM);

		ContainerTask returned = container.addTask(subTask);

		assertEquals(container, returned);
	}

	@Test
	void testAddMultipleSubtasks() {
		ContainerTask container = new ContainerTask("Main", "Top-level", TaskPriority.HIGH);
		Task sub1 = new Task("Sub1", "Subtask one", TaskPriority.LOW);
		Task sub2 = new Task("Sub2", "Subtask two", TaskPriority.MEDIUM);

		container.addTask(sub1);
		container.addTask(sub2);

		assertEquals(2, container.getSubTasks().size());
		assertTrue(container.getSubTasks().contains(sub1));
		assertTrue(container.getSubTasks().contains(sub2));
	}

}
