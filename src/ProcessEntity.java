public class ProcessEntity {
    private int processId; // An identifier for the process.
    private String processName; // The name of the process.
    private int burstTime; // The time it takes for the process to execute.
    private int priority; // The priority of the process.

    public ProcessEntity(int processId, String processName, int burstTime) {
        this.processId = processId; // Initialize the process ID.
        this.processName = processName; // Initialize the process name.
        this.burstTime = burstTime; // Initialize the burst time.
        this.priority = -1; // Initialize the priority as -1 (unassigned).
    }

    public int getProcessId() {
        return processId; // Get the process ID.
    }

    public String getProcessName() {
        return processName; // Get the process name.
    }

    public int getBurstTime() {
        return burstTime; // Get the burst time.
    }

    public int getPriority() {
        return priority; // Get the priority.
    }

    public void setPriority(int priority) {
        this.priority = priority; // Set the priority for the process.
    }
}
