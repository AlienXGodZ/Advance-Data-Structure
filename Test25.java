import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Test25 {

    static void addedge(ArrayList<ArrayList<Integer>> graph,int u,int v){

        graph.get(u).add(v);
        graph.get(v).add(u);

    }

    static void dfs(ArrayList<ArrayList<Integer>> graph,int current,boolean[] visited){

        visited[current] = true;

        System.out.print(current + " ");

            for(int neighbour : graph.get(current)){

                if(!visited[neighbour]){

                    dfs(graph, neighbour,visited);

                }
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
        addedge(graph,1,4);

        boolean[] visited = new boolean[vertices];

        dfs(graph,0,visited);



    }
}
