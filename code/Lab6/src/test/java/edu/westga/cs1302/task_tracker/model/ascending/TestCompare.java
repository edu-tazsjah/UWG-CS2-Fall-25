package edu.westga.cs1302.task_tracker.model.ascending;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class TestCompare {

	@Test
    void testConstructorThrowsExceptionIfNull() {
        assertThrows(IllegalArgumentException.class, () -> new TaskAscendingComparator(null));
    }

    @Test
    void testConstructorAcceptsValidArgument() {
        // Just pass a dummy non-null object since we don't need actual ListView
        Object dummy = new Object();
        assertDoesNotThrow(() -> new TaskAscendingComparator(dummy));
    }

    @Test
    void testCompare_LowBeforeMedium() {
        Task lowTask = new Task("Task 1", "Low priority task", TaskPriority.LOW);
        Task medTask = new Task("Task 2", "Medium priority task", TaskPriority.MEDIUM);
        TaskAscendingComparator comp = new TaskAscendingComparator(new Object());

        assertTrue(comp.compare(lowTask, medTask) < 0);
    }

    @Test
    void testCompare_MediumBeforeHigh() {
        Task medTask = new Task("Task 2", "Medium priority task", TaskPriority.MEDIUM);
        Task highTask = new Task("Task 3", "High priority task", TaskPriority.HIGH);
        TaskAscendingComparator comp = new TaskAscendingComparator(new Object());

        assertTrue(comp.compare(medTask, highTask) < 0);
    }

    @Test
    void testCompare_HighAfterLow() {
        Task lowTask = new Task("Task 1", "Low task", TaskPriority.LOW);
        Task highTask = new Task("Task 3", "High task", TaskPriority.HIGH);
        TaskAscendingComparator comp = new TaskAscendingComparator(new Object());

        assertTrue(comp.compare(highTask, lowTask) > 0);
    }

    @Test
    void testCompare_EqualPriorityReturnsZero() {
        Task lowTask1 = new Task("Task 1", "Low task 1", TaskPriority.LOW);
        Task lowTask2 = new Task("Task 2", "Low task 2", TaskPriority.LOW);
        TaskAscendingComparator comp = new TaskAscendingComparator(new Object());

        assertEquals(0, comp.compare(lowTask1, lowTask2));
    }

}
