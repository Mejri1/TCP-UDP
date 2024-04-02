package messagerie;

import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class TaskClient {
    public static void main(String[] args) {
        try {
            TaskManager taskManager = (TaskManager) Naming.lookup("rmi://localhost/TaskManagerService");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nEnter your choice:");
                System.out.println("1. Add Task");
                System.out.println("2. Remove Task");
                System.out.println("3. Get Task List");
                System.out.println("4. Exit");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter task to add: ");
                        scanner.nextLine(); // Consume newline
                        String newTask = scanner.nextLine();
                        taskManager.addTask(newTask);
                        System.out.println("Task added successfully!");
                        break;
                    case 2:
                        System.out.print("Enter task to remove: ");
                        scanner.nextLine(); // Consume newline
                        String taskToRemove = scanner.nextLine();
                        taskManager.removeTask(taskToRemove);
                        System.out.println("Task removed successfully!");
                        break;
                    case 3:
                        List<String> tasks = taskManager.getTaskList();
                        System.out.println("Tasks:");
                        for (String task : tasks) {
                            System.out.println("- " + task);
                        }
                        break;
                    case 4:
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice!");
                }
            }

        } catch (Exception e) {
            System.err.println("TaskManager client exception: " + e.getMessage());
        }
    }
}
