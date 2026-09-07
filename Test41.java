import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Test41{

    static void addedge(ArrayList<ArrayList<Integer>> graph,int u,int v){

        graph.get(u).add(v);
        graph.get(v).add(u);

    }

    static boolean bfscheck(ArrayList<ArrayList<Integer>> graph, int start, int vertices, int[] colour) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        colour[start] = 0;

        while (!queue.isEmpty()) {

            int current = queue.poll();

            for (int neighbour : graph.get(current)) {

                if (colour[neighbour] == -1) {

                    colour[neighbour] = 1 - colour[current];

                    queue.add(neighbour);

                } else if (colour[neighbour] == colour[current]) {

                    return false;

                }
            }
        }

        return true;

    }

    static boolean isBipartite(ArrayList<ArrayList<Integer>> graph,int vertices){

        int[] colour = new int[vertices];

        Arrays.fill(colour,-1);

        for(int i = 0; i < vertices; i++){

            if(colour[i] == -1){

                if(!bfscheck(graph,i,vertices,colour)){

                    return false;

                }
            }
        }

        return true;

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

        if(isBipartite(graph,vertices)){

            System.out.println("Graph is Bipartite");

        }else{

            System.out.println("Graph is not Bipartite");

        }
    }
}