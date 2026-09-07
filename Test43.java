import javax.swing.*;
import java.util.*;

public class Test43{

    static void addedge(ArrayList<ArrayList<Integer>> graph,int u,int v){

        graph.get(u).add(v);
        graph.get(v).add(u);

    }

    static void shortestpath(ArrayList<ArrayList<Integer>> graph,int start,int destination,int vertices){

        Queue<Integer> queue = new LinkedList<>();

        boolean[] visited = new boolean[vertices];

        int[] parent = new int[vertices];

        Arrays.fill(parent,-1);

        queue.add(start);

        visited[start] = true;

        while(!queue.isEmpty()){

            int current = queue.poll();

            if(current == destination){

                break;

            }

            for(int neighbour : graph.get(current)){

                if(!visited[neighbour]){

                    visited[neighbour] = true;

                    parent[neighbour] = current;

                    queue.add(neighbour);

                }

            }

        }

        if(!visited[destination]){

            System.out.println("No Path Exists");
            return;

        }

        ArrayList<Integer> path = new ArrayList<>();

        while(destination!= -1){

            path.add(destination);

            destination = parent[destination];

        }

        Collections.reverse(path);

        System.out.println("Shortest Path: " + path);
        System.out.println("Distance: " + (path.size()-1));

    }



    public static void main(String[] args){

        int vertices = 5;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < vertices; i++){

            graph.add(new ArrayList<>());

        }

        addedge(graph,0,1);
        addedge(graph,0,2);
        addedge(graph,1,4);
        addedge(graph,1,3);
        addedge(graph,2,4);

        shortestpath(graph,0,3,vertices);



    }
}