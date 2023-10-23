import java.util.ArrayList;

public class BinaryHeap {
    private ArrayList<ProcessEntity> heap;
    // Create an ArrayList to store processes in a binary heap structure.

    public BinaryHeap() {
        heap = new ArrayList<>();
        // Initialize the ArrayList when a BinaryHeap object is created.
    }

    public void add(ProcessEntity process) {
        heap.add(process); // Add a process to the binary heap.
        bubbleUp(heap.size() - 1); // Ensure the newly added process is in its correct position by moving it up in the heap.
    }

    public ProcessEntity remove() {
        if (heap.isEmpty()) {
            return null; // If the binary heap is empty, return null.
        }

        ProcessEntity removedProcess = heap.get(0); // Get the process with the highest priority (at the root).
        int lastIndex = heap.size() - 1;
        heap.set(0, heap.get(lastIndex)); // Replace the root with the last process in the heap.
        heap.remove(lastIndex); // Remove the last process.
        bubbleDown(0); // Ensure the binary heap property is maintained by moving the new root down.

        return removedProcess; // Return the process with the highest priority.
    }

    public boolean isEmpty() {
        return heap.isEmpty(); // Check if the binary heap is empty.
    }

    private void bubbleUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;

            if (heap.get(index).getPriority() < heap.get(parentIndex).getPriority()) {
                swap(index, parentIndex); // Swap the process with its parent if it has higher priority.
                index = parentIndex; // Move up to the parent position.
            } else {
                break; // Stop moving up if the process has lower or equal priority than its parent.
            }
        }
    }

    private void bubbleDown(int index) {
        int size = heap.size();
        while (true) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int smallerChildIndex = index;

            // Find the child with the smaller priority.
            if (leftChildIndex < size && heap.get(leftChildIndex).getPriority() < heap.get(smallerChildIndex).getPriority()) {
                smallerChildIndex = leftChildIndex;
            }
            if (rightChildIndex < size && heap.get(rightChildIndex).getPriority() < heap.get(smallerChildIndex).getPriority()) {
                smallerChildIndex = rightChildIndex;
            }

            if (smallerChildIndex == index) {
                break; // If the current process has lower or equal priority than both children, stop moving down.
            } else {
                swap(index, smallerChildIndex); // Swap the process with the smaller-priority child.
                index = smallerChildIndex; // Move down to the child's position.
            }
        }
    }

    private void swap(int i, int j) {
        ProcessEntity temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp); // Swap two processes in the heap.
    }
}
