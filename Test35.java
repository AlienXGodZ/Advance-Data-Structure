import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Test35 {

    static void addedge(ArrayList<ArrayList<Integer>> graph,int u,int v){

        graph.get(u).add(v);

    }

    static void  topologicalsort(ArrayList<ArrayList<Integer>> graph,int current,Stack<Integer> stack,boolean[] visited){

        visited[current] = true;

        for(int neighbour : graph.get(current)){

            if(!visited[neighbour]){

                topologicalsort(graph,neighbour,stack,visited);

            }

        }

        stack.push(current);


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

        boolean[] visited = new boolean[vertices];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < vertices; i++){

            if(!visited[i]){

                topologicalsort(graph,0,stack,visited);

            }

        }

        while(!stack.isEmpty()){

            System.out.print(stack.pop() + " ");

        }




    }
}
