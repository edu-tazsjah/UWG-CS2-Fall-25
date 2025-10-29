package edu.westga.cs1302.task_tracker.model.ascendingname;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.task_tracker.model.AscendingName;
import edu.westga.cs1302.task_tracker.model.Task;
import edu.westga.cs1302.task_tracker.model.Task.TaskPriority;

class TestCompare {
	
	@Test
	void testO1IsNull() {
		Task o1 = new Task("Task A", "desc", TaskPriority.HIGH);
		Task o2 = new Task("Task B", "desc", TaskPriority.HIGH);
		AscendingName ascending = new AscendingName();
		
		assertThrows(IllegalArgumentException.class, ()->{ascending.compare(null, o2);});
	}
	
	@Test
	void testO2IsNull() {
		Task o1 = new Task("Task A", "desc", TaskPriority.HIGH);
		Task o2 = new Task("Task B", "desc", TaskPriority.HIGH);
		AscendingName ascending = new AscendingName();
		
		assertThrows(IllegalArgumentException.class, ()->{ascending.compare(o1, null);});
	}
	
	@Test
	void testO1NameBeforeO2Name() {
		Task o1 = new Task("Task A", "desc", TaskPriority.LOW);
		Task o2 = new Task("Task B", "desc", TaskPriority.HIGH);
		AscendingName ascending = new AscendingName();
		
		int result = ascending.compare(o1, o2);
		
		assertTrue(result < 0);
	}
	
	@Test
	void testO1NameAfterO2Name() {
		Task o1 = new Task("Task B", "desc", TaskPriority.LOW);
		Task o2 = new Task("Task A", "desc", TaskPriority.HIGH);
		AscendingName ascending = new AscendingName();
		
		int result = ascending.compare(o1, o2);
		
		assertTrue(result > 0);
	}
	
	@Test
	void testO1NameSameAsO2Name() {
		Task o1 = new Task("Task A", "desc", TaskPriority.MEDIUM);
		Task o2 = new Task("Task A", "desc", TaskPriority.HIGH);
		AscendingName ascending = new AscendingName();
		
		int result = ascending.compare(o1, o2);
		
		assertTrue(result == 0);
	}
	
	@Test
	void testO1LowercaseAfterO2Uppercase() {
		Task o1 = new Task("Task a", "desc", TaskPriority.LOW);
		Task o2 = new Task("Task A", "desc", TaskPriority.HIGH);
		AscendingName ascending = new AscendingName();
		
		int result = ascending.compare(o1, o2);
		
		assertTrue(result > 0);
	}
	
	@Test
	void testO1UppercaseBeforeO2Lowercase() {
		Task o1 = new Task("Task A", "desc", TaskPriority.HIGH);
		Task o2 = new Task("Task a", "desc", TaskPriority.MEDIUM);
		AscendingName ascending = new AscendingName();
		
		int result = ascending.compare(o1, o2);
		
		assertTrue(result < 0);
	}
	
	@Test
	void testToString() {
		AscendingName ascending = new AscendingName();
		
		assertEquals("Name - Ascending", ascending.toString());
	}

}
