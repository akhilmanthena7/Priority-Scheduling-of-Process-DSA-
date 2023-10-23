import java.util.Scanner;

public class PrioritySchedulingWithBinaryHeap {
    public static void main(String[] args) {
        // Create a BinaryHeap to store processes with priorities
        BinaryHeap priorityQueue = new BinaryHeap();

        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of processes
        System.out.print("Enter the number of processes: ");
        int numProcesses = scanner.nextInt();
        scanner.nextLine();

        // Create an array to store information about each process
        ProcessEntity[] processes = new ProcessEntity[numProcesses];

        // Loop to gather information about each process
        for (int i = 0; i < numProcesses; i++) {
            // Prompt the user to enter the name of the process
            System.out.print("Enter Process Name for Process " + (i + 1) + ": ");
            String processName = scanner.nextLine();

            // Prompt the user to enter the burst time for the process
            System.out.print("Enter Burst Time for Process " + (i + 1) + ": ");
            int burstTime = scanner.nextInt();
            scanner.nextLine();

            // Create a ProcessEntity object for the process and add it to the priority queue
            processes[i] = new ProcessEntity(i + 1, processName, burstTime);
            priorityQueue.add(processes[i]);
        }

        int priority = 1; // Initialize the priority value

        // Print a header for the table of process information
        System.out.println("Process ID  Process Name  Burst Time  Priority");

        // Process each element in the priority queue
        while (!priorityQueue.isEmpty()) {
            // Remove a process with the highest priority from the queue
            ProcessEntity process = priorityQueue.remove();

            // Set the priority for the process
            process.setPriority(priority);
            priority++; // Increment the priority value for the next process

            // Display the process information in a table format
            System.out.println(process.getProcessId() + "           " + process.getProcessName() + "               " + process.getBurstTime() + "                  " + process.getPriority());
        }
    }
}