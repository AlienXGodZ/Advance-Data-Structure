import java.util.ArrayList;

public class Test29 {

    static void addEdge(ArrayList<ArrayList<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    static void dfs(ArrayList<ArrayList<Integer>> graph,
                    int current,
                    boolean[] visited) {

        visited[current] = true;

        for (int neighbour : graph.get(current)) {

            if (!visited[neighbour]) {
                dfs(graph, neighbour, visited);
            }
        }
    }

    public static void main(String[] args) {

        int vertices = 6;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }

        // Component 1: 0 - 1 - 2
        addEdge(graph, 0, 1);
        addEdge(graph, 1, 2);

        // Component 2: vertex 3 alone

        // Component 3: 4 - 5
        addEdge(graph, 4, 5);

        boolean[] visited = new boolean[vertices];

        int count = 0;

        for (int i = 0; i < vertices; i++) {

            if (!visited[i]) {

                dfs(graph, i, visited);

                count++;
            }
        }

        System.out.println("Connected Components = " + count);
    }
}