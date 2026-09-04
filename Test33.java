import java.sql.Array;
import java.util.ArrayList;

public class Test33{

    static void addedge(ArrayList<ArrayList<Integer>> graph, int u ,int v){

        graph.get(u).add(v);
        graph.get(v).add(u);

    }

    static boolean dfs(ArrayList<ArrayList<Integer>> graph,int current,int parent,int vertices,boolean[] visited) {

        visited[current] = true;

        for (int neighbour : graph.get(current)) {

            if (!visited[neighbour]) {

                if (dfs(graph, neighbour, current,vertices,visited)) {
                    return true;
                }
            }else if (neighbour != parent) {

                    return true;

                }
            }

            return false;
        }



    public static void main(String[] args){

        int vertices = 4;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < vertices; i++){

            graph.add(new ArrayList<>());

        }

        addedge(graph,0,1);
        addedge(graph,1,2);
        addedge(graph,2,3);
        addedge(graph,3,0);

        boolean[] visited = new boolean[vertices];

        boolean cycle = false;

        for(int i = 0; i < vertices; i++){

            if(!visited[i]){

                if(dfs(graph,0,-1,vertices,visited)){
                    cycle = true;
                    break;

                }

            }
        }

        System.out.println("Cycle is Found:" + " " + cycle);

    }
}