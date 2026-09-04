import java.util.*;

public class Test32 {

    static void bfs(int[][] graph,
                    int start,
                    boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {

            int current = queue.poll();

            if(!visited[current]){

                visited[current] = true;
            }


            for (int i = 0 ; i < graph.length; i++){

                    if (!visited[i] && graph[current][i] == 1) {

                        queue.add(i);
                    }
                }
            }
        }


    public static void main(String[] args) {

        int[][] graph = {{0,1,1,0,0,0},
                         {1,0,1,0,0,0},
                         {1,0,0,0,0,0},
                         {0,0,0,0,0,0},
                         {0,0,0,0,0,1},
                         {0,0,0,0,1,0}};

        boolean[] visited = new boolean[graph.length];

        int count = 0;

        for (int i = 0; i < graph.length; i++) {

            if (!visited[i]) {

                bfs(graph, i, visited);

                count++;
            }
        }

        System.out.println("Connected Components = " + count);
    }
}