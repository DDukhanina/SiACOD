package org.example;

import java.util.*;

public class FordFulkerson {
    static class Edge {
        int to, capacity, flow;

        Edge(int to, int capacity) {
            this.to = to;
            this.capacity = capacity;
            this.flow = 0;
        }
    }

    static class Graph {
        List<List<Edge>> adj;
        int size;

        Graph(int size) {
            this.size = size;
            adj = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                adj.add(new ArrayList<>());
            }
        }

        void addEdge(int from, int to, int capacity) {
            adj.get(from).add(new Edge(to, capacity));
        }

        List<Edge> getEdges(int node) {
            return adj.get(node);
        }
    }

    static int bfs(Graph graph, int source, int sink, int[] parent) {
        boolean[] visited = new boolean[graph.size];
        Arrays.fill(parent, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;

        int[] capacity = new int[graph.size];
        Arrays.fill(capacity, 0);
        capacity[source] = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int u = queue.poll();

            for (Edge edge : graph.getEdges(u)) {
                if (!visited[edge.to] && edge.flow < edge.capacity) {
                    visited[edge.to] = true;
                    parent[edge.to] = u;
                    if (edge.to == sink) {
                        return Math.min(edge.capacity - edge.flow, Integer.MAX_VALUE);
                    }
                    queue.add(edge.to);
                }
            }
        }
        return 0;
    }

    static int fordFulkerson(Graph graph, int source, int sink) {
        int[] parent = new int[graph.size];
        int maxFlow = 0;

        while (true) {
            int flow = bfs(graph, source, sink, parent);
            if (flow == 0) break;

            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                for (Edge edge : graph.getEdges(u)) {
                    if (edge.to == v) {
                        edge.flow += flow;
                    }
                }
                for (Edge edge : graph.getEdges(v)) {
                    if (edge.to == u) {
                        edge.flow -= flow;
                    }
                }
            }
            maxFlow += flow;
        }
        return maxFlow;
    }

    public static int minCellsToPaint(char[][] field, int XMinotavr, int YMinotavr) {
        int N = field.length; // количество строк
        int M = field[0].length; // количество столбцов

        int source = YMinotavr * M + XMinotavr;
        int sink = M * N;
        Graph graph = new Graph(N * M + 1);

        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (field[i][j] == '.') {
                    int node = i * M + j;

                    for (int[] dir : directions) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        if (ni >= 0 && ni < N && nj >= 0 && nj < M && field[ni][nj] == '.') {
                            int to = ni * M + nj;
                            graph.addEdge(node, to, 1);
                        }
                    }

                    if (i == 0 || i == N - 1 || j == 0 || j == M - 1) {
                        graph.addEdge(node, sink, 1);
                    }
                }
            }
        }
        int maxFlow = fordFulkerson(graph, source, sink);
        return maxFlow;
    }
}