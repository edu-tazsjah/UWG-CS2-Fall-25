package edu.westga.cs1302.task_tracker.model.task;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.ContainerTask;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestAddTask {
	
	@Test
	void testAddTaskShouldThrowIfTaskIsNull() {
		Task mainTask = new Task("Main", "Main description", TaskPriority.MEDIUM);

		assertThrows(IllegalArgumentException.class, () -> {
			mainTask.addTask(null);
		});
	}

	@Test
	void testAddTaskCreatesNewContainerTask() {
		Task mainTask = new Task("Main", "Main description", TaskPriority.HIGH);
		Task subTask = new Task("Sub", "Sub description", TaskPriority.LOW);

		ContainerTask result = mainTask.addTask(subTask);

		assertNotNull(result);
		assertEquals(ContainerTask.class, result.getClass());
		assertNotSame(mainTask, result);
	}

	@Test
	void testContainerTaskKeepsSameDetailsAsOriginal() {
		Task mainTask = new Task("Workout", "Leg day", TaskPriority.HIGH);
		Task subTask = new Task("Stretch", "Warm up", TaskPriority.MEDIUM);

		ContainerTask result = mainTask.addTask(subTask);

		assertEquals(mainTask.getName(), result.getName());
		assertEquals(mainTask.getDescription(), result.getDescription());
		assertEquals(mainTask.getPriority(), result.getPriority());
	}

	@Test
	void testContainerTaskContainsSubTask() {
		Task mainTask = new Task("Study", "Review material", TaskPriority.HIGH);
		Task subTask = new Task("Flashcards", "Practice key terms", TaskPriority.LOW);

		ContainerTask result = mainTask.addTask(subTask);

		assertEquals(1, result.getSubTasks().size());
		assertEquals(subTask, result.getSubTasks().get(0));
	}

}
