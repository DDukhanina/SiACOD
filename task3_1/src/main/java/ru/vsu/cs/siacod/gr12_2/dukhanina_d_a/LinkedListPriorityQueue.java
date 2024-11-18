package ru.vsu.cs.siacod.gr12_2.dukhanina_d_a;

import java.util.LinkedList;

public class LinkedListPriorityQueue {
    private class Node {
        int priority;
        int element;

        public Node(int priority, int element) {
            this.priority = priority;
            this.element = element;
        }
    }

    private LinkedList<Node> list;
    private int size;

    public LinkedListPriorityQueue() {
        this.list = new LinkedList<>();
        this.size = 0;
    }

    public void insert(int element, int priority) {
        list.add(new Node(priority, element));
        size++;
    }

    public String extractMax() {
        if (list.isEmpty()) {
            return "null";
        }
        int maxIndex = 0;
        int maxVal = list.get(0).priority;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).priority < maxVal) {
                maxVal = list.get(i).priority;
                maxIndex = i;
            }
        }
        return "" + list.remove(maxIndex).element;
    }
}