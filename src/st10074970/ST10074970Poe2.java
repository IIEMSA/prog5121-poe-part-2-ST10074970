package st10074970;

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ST10074970Poe2 {

    private static final String[] usernames = new String[100];
    private static final String[] passwords = new String[100];
    private static int userCount = 0;
    private static final int MAX_USERNAME_LENGTH = 20;
    private static boolean loggedIn = false; // Track login status
    private static int taskCounter = 0; // Autogenerated task number

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to EasyKanban");

            while (true) {
                if (!loggedIn) {
                    System.out.println("\n1. Sign In");
                    System.out.println("2. Sign Up");
                    System.out.println("3. Exit");
                    System.out.print("Enter your choice: ");

                    if (scanner.hasNextInt()) {
                        int choice = scanner.nextInt();
                        scanner.nextLine();

                        switch (choice) {
                            case 1: {
                                String loginStatus = signIn(scanner);
                                System.out.println(loginStatus);
                                break;
                            }
                            case 2: {
                                String registrationMessage = signUp(scanner);
                                System.out.println(registrationMessage);
                                break;
                            }
                            case 3: {
                                System.out.println("Exiting the application. Goodbye!");
                                return;
                            }
                            default: System.out.println("Invalid choice. Please try again.");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a valid integer choice.");
                        scanner.nextLine();
                    }
                } else {
                    System.out.println("\nChoose an option:");
                    System.out.println("1. Add Tasks");
                    System.out.println("2. Show Report (Coming Soon)");
                    System.out.println("3. Quit");
                    System.out.print("Enter your choice: ");

                    if (scanner.hasNextInt()) {
                        int choice = scanner.nextInt();
                        scanner.nextLine();

                        switch (choice) {
                            case 1: {
                                System.out.println("Enter the number of tasks");
                                if (scanner.hasNextInt()){
                                    int numTasks = scanner.nextInt();
                                    Task[] tasks = new Task[numTasks];
                                    String name;
                                    String description;
                                    int number;
                                    String developerDetails;       
                                    String status;
                                    int duration;
                                    String statusChoice;
                                    for (int i = 0; i < numTasks; i++){
                                        System.out.println("Enter task " + (i + 1) + "'s name");
                                        name = scanner.nextLine();
                                        System.out.println("Enter the task " + (i + 1) + "'s description");
                                        description = scanner.nextLine();
                                        number = i + 1;
                                        System.out.println("Enter the developers name and surname");
                                        developerDetails = scanner.nextLine();
                                        System.out.println("Select the status for task" + (i + 1));
                                        System.out.println("1. To Do");
                                        System.out.println("2. Done");
                                        System.out.println("3. Doing");
                                        statusChoice = scanner.nextLine();
                                        if (statusChoice.equals(1)){
                                            status = "To Do";
                                        } else if (statusChoice.equals(2)){
                                            status = "Done";
                                        } else {
                                            status = "Doing";
                                        }
                                        System.out.println("Enter the duration of the task " + (i + 1));
                                        duration = scanner.nextInt();
                                        Task t = new Task(name, number, developerDetails, description, status, duration);
                                        tasks[i] = t;
                                    }
                                    for (int i = 0; i < numTasks; i++){
                                        System.out.println(tasks[i].printTaskDetails() + '\n');
                                    }
                                    System.out.println("Total Duration: " + tasks[0].returnTotalHours(tasks));
                                } else {
                                    System.out.println("Invalid input. Please enter a valid integer choice.");
                                }
                                break;
                            }
                            case 2: {
                                System.out.println("Feature is still in development. Coming Soon.");
                                break;
                            }
                            case 3: {
                                System.out.println("Exiting the application. Goodbye!");
                                return;
                            }
                            default: System.out.println("Invalid choice. Please try again.");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a valid integer choice.");
                        scanner.nextLine();
                    }
                }
            }
        }
    }

    private static void addTask(Scanner scanner) {
        System.out.println("\n=== Add Task ===");

        // Autogenerated task number
        int taskNumber = taskCounter++;

        // Collect task name
        System.out.print("Enter task name: ");
        String taskName = scanner.nextLine();

        // Collect task description
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        // Check if description length exceeds 50 characters
        if (description.length() > 50) {
            System.out.println("Please enter a task description of less than 50 characters.");
            return;
        }

        // Collect task deadline
        System.out.print("Enter task deadline (e.g., YYYY-MM-DD): ");
        String deadline = scanner.nextLine();

        // Collect task priority
        System.out.print("Enter task priority (High/Medium/Low): ");
        String priority = scanner.nextLine();

        // Collect developer details
        System.out.print("Enter developer's first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter developer's last name: ");
        String lastName = scanner.nextLine();

        // Collect task duration
        System.out.print("Enter estimated task duration in hours: ");
        int duration = 0;
        if (scanner.hasNextInt()) {
            duration = scanner.nextInt();
            scanner.nextLine(); // Consume newline after reading int
        } else {
            System.out.println("Invalid input. Duration should be an integer.");
            scanner.nextLine(); // Clear invalid input
            return;
        }

        // Collect task status with validation loop
        String status = null;
        while (status == null) {
            System.out.println("Select task status:");
            System.out.println("1. To Do");
            System.out.println("2. Doing");
            System.out.println("3. Done");
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                int statusChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline after reading int
                switch (statusChoice) {
                    case 1: {
                        status = "To Do";
                        break;
                    }
                    case 2: {
                        status = "Doing";
                        break;
                    }
                    case 3: {
                        status = "Done";
                        break;
                    }
                    default: System.out.println("Invalid choice. Please enter a valid option.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer choice.");
                scanner.nextLine(); // Clear invalid input
            }
        }

        // Generate task ID
        String taskID = generateTaskID(taskName, taskNumber, lastName);

        // Display task details using JOptionPane
        String taskDetails = String.format("Task Status: %s\nDeveloper: %s %s\nTask Number: %d\nTask Name: %s\nTask Description: %s\nTask ID: %s\nDuration: %d hours",
                                            status, firstName, lastName, taskNumber, taskName, description, taskID.toUpperCase(), duration);
        JOptionPane.showMessageDialog(null, taskDetails, "Task Details", JOptionPane.INFORMATION_MESSAGE);

        // Console output for debugging
        System.out.println("Task added:");
        System.out.println("Task ID: " + taskID.toUpperCase()); // Convert to uppercase
        System.out.println("Name: " + taskName);
        System.out.println("Description: " + description);
        System.out.println("Deadline: " + deadline);
        System.out.println("Priority: " + priority);
        System.out.println("Developer: " + firstName + " " + lastName);
        System.out.println("Duration: " + duration + " hours");
        System.out.println("Status: " + status);
    }

    // Method to generate task ID
    private static String generateTaskID(String taskName, int taskNumber, String lastName) {
        String taskID = taskName.substring(0, 2) + ":" + taskNumber + ":" + lastName.substring(lastName.length() - 3);
        return taskID;
    }

    private static String signIn(Scanner scanner) {
        System.out.println("\n=== Sign In ===");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        int index = findUserIndex(username);
        if (index == -1) {
            return "Username not found. Please sign up first.";
        }

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (passwords[index].equals(password)) {
            loggedIn = true;
            return "Sign in successful. Welcome, " + username + "! It is great to see you again.";
        } else {
            return "Username or password incorrect. Please try again.";
        }
    }

    private static String signUp(Scanner scanner) {
        System.out.println("\n=== Sign Up ===");
        if (userCount >= usernames.length) {
            return "User limit reached. Cannot sign up.";
        }

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        if (!checkUsername(username)) {
            return "Invalid username. Username must contain an underscore (_) and be no longer than " + MAX_USERNAME_LENGTH + " characters.";
        }

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (!checkPasswordComplexity(password)) {
            return "Password does not meet complexity requirements.\nPassword must be at least eight characters long and contain a capital letter, a number, and a special character.";
        }

        usernames[userCount] = username;
        passwords[userCount] = password;
        userCount++;
        return "Sign up successful. You can now sign in with your credentials.";
    }

    private static boolean checkUsername(String username) {
        return username.contains("_") && username.length() <= MAX_USERNAME_LENGTH;
    }

    private static boolean checkPasswordComplexity(String password) {
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(password);
        return m.matches();
    }

    private static int findUserIndex(String username) {
        for (int i = 0; i < userCount; i++) {
            if (usernames[i].equals(username)) {
                return i;
            }
        }
        return -1;
    }
}