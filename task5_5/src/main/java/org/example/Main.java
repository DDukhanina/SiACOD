package org.example;

public class Main {
    public static void main(String[] args) {
        AStar.Node initialNode = new AStar().new Node(0, 0);
        AStar.Node finalNode = new AStar().new Node(4, 4);

        AStar aStar = new AStar(5, 5, initialNode, finalNode);
        int[][] blocksArray = {{1, 1}, {2, 2}, {3, 3}};
        aStar.setBlock(blocksArray);

        System.out.println("Ищем путь от начальной до конечной вершины...");
        long startTime = System.currentTimeMillis();
        aStar.findPath();
        long endTime = System.currentTimeMillis();

        System.out.println("Поиск пути занял " + (endTime - startTime) + " мс");
        System.out.println("Найденный путь: " + aStar.findPath());
    }
}