package Problems.TaskManagementSystem;

import java.util.Date;
import java.util.List;

public class TaskManagementSystemDemo {
    public static void run() {
        TaskManager taskManager = TaskManager.getInstance();

        User user1 = new User("1", "John Doe", "john@example.com");
        User user2 = new User("2", "Jane Smith", "jane@example.com");

        Task task1 = new Task("1", "Task 1", "Description 1", new Date(), 1, user1);
        Task task2 = new Task("2", "Task 2", "Description 2", new Date(), 2, user2);
        Task task3 = new Task("3", "Task 3", "Description 3", new Date(), 1, user1);

        taskManager.createTask(task1);
        taskManager.createTask(task2);
        taskManager.createTask(task3);

        task2.setDescription("Updated description");
        taskManager.updateTask(task2);

        List<Task> searchResults = taskManager.searchTasks("Task");
        System.out.println("Search Results:");
        for (Task task : searchResults) {
            System.out.println(task.getTitle());
        }

        List<Task> filteredTasks = taskManager.filterTasks(TaskStatus.PENDING, new Date(0), new Date(), 1);
        System.out.println("Filtered Tasks:");
        for (Task task : filteredTasks) {
            System.out.println(task.getTitle());
        }

        taskManager.markTaskAsCompleted("1");

        List<Task> taskHistory = taskManager.getTaskHistory(user1);
        System.out.println("Task History for " + user1.getName() + ":");
        for (Task task : taskHistory) {
            System.out.println(task.getTitle());
        }

        taskManager.deleteTask("3");
    }
}
