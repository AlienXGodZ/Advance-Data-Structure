import java.util.ArrayList;

public class Test34 {

    static void addedge(ArrayList<ArrayList<Integer>> graph, int u, int v) {

        graph.get(u).add(v);

    }

    static boolean dfs(ArrayList<ArrayList<Integer>> graph,int current,boolean[] visited,boolean[] pathvisited){

        visited[current] = true;
        pathvisited[current] = true;

        for(int neighbour : graph.get(current)){

            if(!visited[neighbour]){

                if(dfs(graph,neighbour,visited,pathvisited)){

                    return true;

                }

            }else if(pathvisited[neighbour]){

                return true;

            }

        }

        pathvisited[current] = false;
        return false;


    }

    public static void main(String[] args) {

        int vertices = 4;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {

            graph.add(new ArrayList<>());

        }

        addedge(graph, 0, 1);
        addedge(graph, 1, 2);
        addedge(graph, 2, 3);
        addedge(graph, 3, 1);

        boolean cycle = false;

        boolean[] visited = new boolean[vertices];
        boolean[] pathvisited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {

            if (!visited[i]) {

                if (dfs(graph, i, visited, pathvisited)) {

                    cycle = true;
                    break;

                }

            }
        }

        System.out.println("CYCLE FOUND:" + cycle);
    }
}