package org.example;

public class Main {
    public static void main(String[] args) {
        char[][] field = {
                {'.', '.', '/', '.', '/', '.'},
                {'/', '/', '.', '.', '/', '.'},
                {'.', '.', '.', '.', '/', '.'},
                {'/', '/', '.', '.', '.', '.'},
                {'.', '.', '/', '/', '.', '.'}
        };

        System.out.println(FordFulkerson.minCellsToPaint(field, 2, 2));
    }
}