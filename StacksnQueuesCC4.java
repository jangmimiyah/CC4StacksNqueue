import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class StacksnQueuesCC4 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean firstRun = true;
            boolean continueProgram = true;
            
            while (continueProgram) {
                System.out.print("Choose data structure (stack/queue" + (firstRun ? ")" : "/end)") + ": ");
                String choice = scanner.next().toLowerCase();
                
                if (!firstRun && choice.equals("end")) {
                    System.out.println("Program terminated.");
                    break; // No need for continueProgram = false;
                }
                
                
                if (!choice.equals("stack") && !choice.equals("queue")) {
                    System.out.println("Invalid choice. Please enter 'stack' or 'queue'.");
                    continue;
                }
                
                System.out.print("Enter array size (n): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a valid integer for n.");
                    scanner.next(); // consume invalid input
                }
                int n = scanner.nextInt();
                
                switch (choice) {
                    case "stack" -> {
                        Stack<Integer> stack = new Stack<>();
                        while (true) {
                            System.out.print("Choose operation (push/pop/end): ");
                            String operation = scanner.next().toLowerCase();
                            switch (operation) {
                                case "push" -> {
                                    if (stack.size() < n) {
                                        System.out.print("Enter value: ");
                                        while (!scanner.hasNextInt()) {
                                            System.out.println("Invalid input. Please enter an integer value.");
                                            scanner.next();
                                        }
                                        int value = scanner.nextInt();
                                        stack.push(value);
                                    } else {
                                        System.out.println("Stack is full!");
                                    }
                                }
                                case "pop" -> {
                                    if (!stack.isEmpty()) {
                                        System.out.println("Popped: " + stack.pop());
                                    } else {
                                        System.out.println("Stack is empty!");
                                    }
                                }
                                case "end" -> {
                                    System.out.println("Stack contents: " + stack);
                                    break;
                                }
                                default -> System.out.println("Invalid operation.");
                            }
                            if (operation.equals("end")) break;
                        }
                    }
                    case "queue" -> {
                        Queue<Integer> queue = new LinkedList<>();
                        while (true) {
                            System.out.print("Choose operation (enqueue(en)/dequeue(de)/end): ");
                            String operation = scanner.next().toLowerCase();
                            switch (operation) {
                                case "en" -> {
                                    if (queue.size() < n) {
                                        System.out.print("Enter value: ");
                                        while (!scanner.hasNextInt()) {
                                            System.out.println("Invalid input. Please enter an integer value.");
                                            scanner.next();
                                        }
                                        int value = scanner.nextInt();
                                        queue.add(value);
                                    } else {
                                        System.out.println("Queue is full!");
                                    }
                                }
                                case "de" -> {
                                    if (!queue.isEmpty()) {
                                        System.out.println("Dequeued: " + queue.poll());
                                    } else {
                                        System.out.println("Queue is empty!");
                                    }
                                }
                                case "end" -> {
                                    System.out.println("Queue contents: " + queue);
                                    break;
                                }
                                default -> System.out.println("Invalid operation.");
                            }
                            if (operation.equals("end")) break;
                        }
                    }
                }
                firstRun = false;
            }
        }
    }
}
