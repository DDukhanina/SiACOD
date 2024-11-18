package ru.vsu.cs.siacod.gr12_2.dukhanina_d_a;

public class BinaryHeapPriorityQueue {
    private class Node {
        int priority;
        int element;

        public Node(int priority, int element) {
            this.priority = priority;
            this.element = element;
        }
    }

    private Node[] heap;
    private int size;

    public BinaryHeapPriorityQueue() {
        heap = new Node[10000];
        size = 0;
    }

    public void insert(int element, int priority) {
        Node node = new Node(priority, element);
        heap[size] = node;
        size++;
        heapifyUp(size - 1);
    }

    public String extractMax() {
        if (this.heap == null || size == 0) {
            return "null";
        }
        int maxIndex = 0;
        Node maxNode = heap[0];
        heap[maxIndex] = heap[size - 1];
        size--;
        heapifyDown(maxIndex);
        return "" + maxNode.element;
    }

    public void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap[index].priority > heap[parentIndex].priority) {
            Node temp = heap[index];
            heap[index] = heap[parentIndex];
            heap[parentIndex] = temp;
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    public void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int largest = index;

        if (leftChildIndex < size && heap[leftChildIndex].priority > heap[largest].priority) {
            largest = leftChildIndex;
        }

        if (rightChildIndex < size && heap[rightChildIndex].priority > heap[largest].priority) {
            largest = rightChildIndex;
        }

        if (largest != index) {
            Node temp = heap[index];
            heap[index] = heap[largest];
            heap[largest] = temp;
            heapifyDown(largest);
        }
    }
}