package edu.westga.cs1302.project1.utils.prioritycount;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import edu.westga.cs1302.project1.model.PriorityCount;
import edu.westga.cs1302.project1.model.Task;

public class TestPriorityCount {
	
	@Test
    void testNullTaskListThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            PriorityCount.getPriorityCount(null, "HIGH");
        });
    }

    @Test
    void testNullPriorityThrowsException() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Task 1", "Laundry", "HIGH"));

        assertThrows(IllegalArgumentException.class, () -> {
            PriorityCount.getPriorityCount(tasks, null);
        });
    }

    @Test
    void testEmptyPriorityThrowsException() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Task 1", "Laundry", "HIGH"));

        assertThrows(IllegalArgumentException.class, () -> {
            PriorityCount.getPriorityCount(tasks, "");
        });
    }

    @Test
    void testCountHighPriorityTasks() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Task 1", "Do laundry", "HIGH"));
        tasks.add(new Task("Task 2", "Wash dishes", "LOW"));
        tasks.add(new Task("Task 3", "Homework", "HIGH"));

        int result = PriorityCount.getPriorityCount(tasks, "HIGH");

        assertEquals(2, result);
    }

    @Test
    void testCountLowPriorityTasks() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Task 1", "Do laundry", "LOW"));
        tasks.add(new Task("Task 2", "Wash dishes", "LOW"));
        tasks.add(new Task("Task 3", "Homework", "HIGH"));

        int result = PriorityCount.getPriorityCount(tasks, "LOW");

        assertEquals(2, result);
    }

    @Test
    void testCountWhenNoTasksMatch() {
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Task 1", "Do laundry", "LOW"));
        tasks.add(new Task("Task 2", "Wash dishes", "MEDIUM"));

        int result = PriorityCount.getPriorityCount(tasks, "HIGH");

        assertEquals(0, result);
    }

    @Test
    void testEmptyListReturnsZero() {
        List<Task> tasks = new ArrayList<>();

        int result = PriorityCount.getPriorityCount(tasks, "HIGH");

        assertEquals(0, result);
    }

}
