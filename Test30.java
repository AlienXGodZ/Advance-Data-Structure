import java.util.*;

public class Test30 {

    static void addEdge(ArrayList<ArrayList<Integer>> graph,
                        int u, int v) {

        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    static void bfs(ArrayList<ArrayList<Integer>> graph,
                    int start,
                    boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {

            int current = queue.poll();

            for (int neighbour : graph.get(current)) {

                if (!visited[neighbour]) {

                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
    }

    public static void main(String[] args) {

        int vertices = 6;

        ArrayList<ArrayList<Integer>> graph =
                new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Component 1
        addEdge(graph, 0, 1);
        addEdge(graph, 1, 2);

        // Component 2
        // Vertex 3 is alone

        // Component 3
        addEdge(graph, 4, 5);

        boolean[] visited = new boolean[vertices];

        int count = 0;

        for (int i = 0; i < vertices; i++) {

            if (!visited[i]) {

                bfs(graph, i, visited);

                count++;
            }
        }

        System.out.println("Connected Components = " + count);
    }
}