import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Test37 {

    static void addedge(ArrayList<ArrayList<Integer>> graph, int u ,int v){

        graph.get(u).add(v);
        graph.get(v).add(u);

    }

    static void shortestdistance(ArrayList<ArrayList<Integer>> graph,int current){

        boolean[] visited = new boolean[graph.size()];

        int[] distance = new int[graph.size()];

        Queue<Integer> queue = new LinkedList<>();

        visited[current] = true;

        distance[current] = 0;

        queue.add(current);

        while(!queue.isEmpty()){

            int poll = queue.poll();

            for(int neighbour : graph.get(poll)){

                if(!visited[neighbour]){

                    visited[neighbour] = true;

                    distance[neighbour] = distance[poll] + 1;

                    queue.add(neighbour);

                }

            }

        }

        for(int i = 0; i < graph.size(); i++){

            System.out.println("Distance From" + " "+ current + " "+"To" + " "+ i + "=" + " "+distance[i]);

        }

    }

    public static void main(String[] args){

        int vertices = 5;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < vertices; i++){

            graph.add(new ArrayList<>());

        }

        addedge(graph,0,1);
        addedge(graph,0,2);
        addedge(graph,1,3);
        addedge(graph,2,4);

        shortestdistance(graph,0);


    }
}
