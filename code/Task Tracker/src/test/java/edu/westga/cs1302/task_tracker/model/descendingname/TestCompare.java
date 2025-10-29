package edu.westga.cs1302.task_tracker.model.descendingname;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.DescendingName;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestCompare {
	
	@Test
	void testO1IsNull() {
		Task o1 = new Task("Task A", "desc", TaskPriority.HIGH);
		Task o2 = new Task("Task B", "desc", TaskPriority.HIGH);
		DescendingName descending = new DescendingName();
		
		assertThrows(IllegalArgumentException.class, ()->{descending.compare(null, o2);});
	}

	@Test
	void testO2IsNull() {
		Task o1 = new Task("Task A", "desc", TaskPriority.HIGH);
		Task o2 = new Task("Task B", "desc", TaskPriority.HIGH);
		DescendingName descending = new DescendingName();
		
		assertThrows(IllegalArgumentException.class, ()->{descending.compare(o1, null);});
	}
	
	@Test
	void testO1NameBeforeO2Name() {
		Task o1 = new Task("Task A", "desc", TaskPriority.LOW);
		Task o2 = new Task("Task B", "desc", TaskPriority.HIGH);
		DescendingName descending = new DescendingName();
		
		int result = descending.compare(o1, o2);

		assertTrue(result > 0);
	}
	
	@Test
	void testO1NameAfterO2Name() {
		Task o1 = new Task("Task B", "desc", TaskPriority.LOW);
		Task o2 = new Task("Task A", "desc", TaskPriority.HIGH);
		DescendingName descending = new DescendingName();
		
		int result = descending.compare(o1, o2);
		
		assertTrue(result < 0);
	}
	
	@Test
	void testO1NameSameAsO2Name() {
		Task o1 = new Task("Task A", "desc", TaskPriority.MEDIUM);
		Task o2 = new Task("Task A", "desc", TaskPriority.HIGH);
		DescendingName descending = new DescendingName();
		
		int result = descending.compare(o1, o2);

		assertTrue(result == 0);
	}
	
	@Test
	void testO1LowercaseAfterO2Uppercase() {
		Task o1 = new Task("Task a", "desc", TaskPriority.LOW);
		Task o2 = new Task("Task A", "desc", TaskPriority.LOW);
		DescendingName descending = new DescendingName();
		
		int result = descending.compare(o1, o2);

		assertTrue(result < 0);
	}
	
	@Test
	void testO1UppercaseBeforeO2Lowercase() {
		Task o1 = new Task("Task A", "desc", TaskPriority.LOW);
		Task o2 = new Task("Task a", "desc", TaskPriority.LOW);
		DescendingName descending = new DescendingName();
		
		int result = descending.compare(o1, o2);

		assertTrue(result > 0);
	}
	
	@Test
	void testToString() {
		DescendingName descending = new DescendingName();
		
		assertEquals("Name - Descending", descending.toString());
	}

}
