import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Test36 {

    static void addedge(ArrayList<ArrayList<Integer>> graph,int u,int v){

        graph.get(u).add(v);

    }

    static void topologicalsort(ArrayList<ArrayList<Integer>> graph,int vertices){

        boolean[] visited = new boolean[vertices];

        int[] indegree = new int[vertices];

        for(int i = 0; i < vertices; i++){

        for(int neighbour : graph.get(i)){

            indegree[neighbour]++;

        }
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < vertices; i++){

            if(indegree[i] == 0){

                queue.add(i);

            }

        }

        while(!queue.isEmpty()){

            int current = queue.poll();

            System.out.print(current + " ");

            for(int neighbour : graph.get(current)){

                indegree[neighbour]--;

                if(indegree[neighbour] == 0 && !visited[neighbour]){

                    queue.add(neighbour);

                }

            }

        }
    }

    public static void main(String[] args){

        int vertices = 4;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < vertices; i++){

            graph.add(new ArrayList<>());

        }

        addedge(graph,0,1);
        addedge(graph,0,2);
        addedge(graph,1,3);
        addedge(graph,2,3);

        topologicalsort(graph,vertices);

    }
}
